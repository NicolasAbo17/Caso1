package Main;

public class Servidor extends Thread{
	
	private Buffer buffer;
	
	
	public void run(){
		while(true) {
			Mensaje mensaje = buffer.retirar();
			System.out.println(mensaje.getMensaje());
			mensaje.cambiarLeido();
		}
	}
	
	public Servidor(Buffer pBuffer) {
		buffer = pBuffer;
	}
	
}
