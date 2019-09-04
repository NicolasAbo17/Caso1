package Main;

public class Cliente extends Thread{

	String cedula;
	int consultas;
	public Cliente(String cedula, int consultas) {
		this.cedula = cedula;
		this.consultas = consultas;
	}
	
	public void run(){
		Mensaje men = new Mensaje(cedula , this);
		
	}
	
}
