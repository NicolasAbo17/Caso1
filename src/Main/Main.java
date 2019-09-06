package Main;

public class Main {
	public static int n = 10;
	public static int b = 10;
	public static int c = 10;
	public static int s = 10;
	public static Buffer buff;
	
	public static Cliente[] cli;
	public static Servidor[] ser;
	
	public static void main(String[] args) {
		buff = new Buffer(b);
		
		cli = new Cliente[c];
		for (int i = 0; i < c; i++) {
			cli[i] = new Cliente(i+"", n, buff);
			cli[i].start();
		}
		
		ser = new Servidor[s];
		for (int i = 0; i < s; i++) {
			ser[i] = new Servidor(buff);
			ser[i].start();
		}
		
		
	}
	
}
