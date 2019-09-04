package Main;

public class Mensaje {
	
	private String mensaje;
	
	boolean leido = false;
	
	private Buffer buffer;
	
	public Mensaje( String pMensaje, Buffer pBuffer) {
		mensaje = pMensaje;
		buffer = pBuffer;
	}
	
	public void enviarMensaje() {
		buffer.almacenar(this);
		while(!leido) {
			try {
				wait();
			}catch(Exception e) {
				
			}
		}
	}
	
}
