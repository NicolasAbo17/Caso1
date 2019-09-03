package Main;

import java.util.ArrayList;

public class Buffer {
	private ArrayList<Mensaje> buff;
	private int n;
	Object lleno, vacío;

	public Buffer ( int n ) {
		this.n = n;
		buff = new ArrayList<Mensaje>( );
		lleno = new Object();
		vacío = new Object();
	}

	public void almacenar ( Mensaje i ){
		synchronized( lleno ){
			while ( buff.size( ) == n ){
				try { lleno.wait( ); }
				catch( InterruptedException e ){}
			}
		}
		synchronized( this ){ buff.add( i ); }
		synchronized( vacío ){ vacío.notify(); }
	}

	public Mensaje retirar (){
		synchronized( vacío ){
			while ( buff.size( ) == 0 ){
				try { vacío.wait( ); }
				catch( InterruptedException e ){}
			}
		}
		Mensaje i;
		synchronized( this ){ i = buff.remove(0); }
		synchronized( lleno ){ lleno.notify( ); }
		return i;
	}
}
