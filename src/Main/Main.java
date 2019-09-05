package Main;

public class Main {
	public static int n = 10;
	public static int c = 10;
	public static Buffer buff;
	
	public static Cliente[] cl;
	public Servidor[] ser;
	
	public static void main(String[] args) {
		buff = new Buffer(n);
		cl = new Cliente[c];
		
		for (int i = 0; i < c; i++) {
			cl[i] = new Cliente(i+"", n, buff);
			cl[i].start();
		}
		
		
	}
	
}
