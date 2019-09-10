package Main;

public class Mensaje {
	
	private String mensaje;
	
	private boolean leido = false;
	
	private Buffer buffer;
	
	private int cons;
	public Mensaje( String pMensaje, Buffer pBuffer, int pCons) {
		mensaje = pMensaje;
		buffer = pBuffer;
		cons = pCons;
	}
	
	public synchronized void enviarMensaje() {
		buffer.almacenar(this);
		while(!leido) {
			try {
				wait();
			}catch(Exception e) {
				
			}
		}
	}
	
	public String getMensaje() {
		return "Soy el mensaje del cliente " + mensaje + " consulta número " + cons;
	}
	
	public synchronized void cambiarLeido() {
		leido = !leido;
		notify();
	}
	
}
