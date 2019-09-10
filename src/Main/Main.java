package Main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Main {
	public static int b;
	public static int c;
	public static int n;
	public static int s;

	public static Buffer buff;

	public static Cliente[] cli;
	public static Servidor[] ser;

	public static void main(String[] args) {
		try (InputStream input = new FileInputStream("./data/cantidad.properties")) {
			Properties prop = new Properties();
			prop.load(input);

			b = Integer.parseInt(prop.getProperty("cantidad.buffer"));
			c = Integer.parseInt(prop.getProperty("cantidad.clientes"));
			s = Integer.parseInt(prop.getProperty("cantidad.servidores"));
			n = Integer.parseInt(prop.getProperty("cantidad.consultas"));
			
			buff = new Buffer(b,c);

			cli = new Cliente[c];
			for (int i = 0; i < c; i++) {
				cli[i] = new Cliente(i+"", n, buff);
				cli[i].start();
			}

			ser = new Servidor[s];
			for (int i = 0; i < s; i++) {
				ser[i] = new Servidor(buff, i+"");
				ser[i].start();
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
