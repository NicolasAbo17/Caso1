package Main;

import java.util.ArrayList;

public class Buffer {
	private ArrayList<Mensaje> buff;
	private int n;
	private int c;
	
	Object lleno;

	public Buffer ( int n, int c ) {
		this.n = n;
		this.c = c;
		buff = new ArrayList<Mensaje>( );
		lleno = new Object();
	}

	public void almacenar ( Mensaje i ){
		synchronized( lleno ){
			while ( buff.size( ) == n ){
				try { lleno.wait( ); }
				catch( InterruptedException e ){}
			}
			synchronized( this ){ buff.add( i ); }
		}
	}

	public Mensaje retirar (){
		Mensaje i;
		synchronized( buff ){
			while ( buff.size( ) == 0 ){
				Thread.yield();
			}
			synchronized( this ){ i = buff.remove(0); }
		}
		synchronized( lleno ){ lleno.notify( ); }
		return i;
	}
	
	public synchronized void terminar() {
		if(--c == 0) {
			System.out.println("Todas las consultas finalizadas");
			System.exit(0);
		}
	}
}
