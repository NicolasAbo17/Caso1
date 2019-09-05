package Main;

public class Cliente extends Thread{

	private String cedula;
	private int consultas;
	private Buffer buff;
	
	public Cliente(String cedula, int consultas, Buffer buff) {
		this.cedula = cedula;
		this.consultas = consultas;
		this.buff = buff;
	}
	
	public void run(){
		for (int i = 0; i < consultas; i++) {
			Mensaje men = new Mensaje(cedula, buff);
			men.enviarMensaje();
		}
	}
	
}
