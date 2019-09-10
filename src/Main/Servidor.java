package Main;

public class Servidor extends Thread{
	
	private Buffer buffer;
	private String nom;
	
	public void run(){
		while(true) {
			Mensaje mensaje = buffer.retirar();
			System.out.println(mensaje.getMensaje() + " leído por el servidor " + nom);
			mensaje.cambiarLeido();
		}
	}
	
	public Servidor(Buffer pBuffer, String nom) {
		buffer = pBuffer;
		this.nom = nom;
	}
	
}
