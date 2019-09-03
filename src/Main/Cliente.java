package Main;

public class Cliente extends Thread{

	int cedula;
	int consultas;
	public Cliente(int cedula, int consultas) {
		this.cedula = cedula;
		this.consultas = consultas;
	}
	
}
