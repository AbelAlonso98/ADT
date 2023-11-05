package ficherosBinarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscribirFichBytes {

	public static void main(String[] args) throws IOException {
		File f = new File(".\\src\\ficherosPrueba\\FichBytes.dat");

		// Escribimos datos
		FileOutputStream out = new FileOutputStream(f, true); // Si es true, escribe al final, si es false, sobreescribe
		for (int i = 0; i < 100; i++)
			out.write(i);
		out.close();

		// Leemos datos
		FileInputStream in = new FileInputStream(f);
		int aux;
		while ((aux = in.read()) != -1)
			System.out.println(aux);
		in.close();
	}

}
