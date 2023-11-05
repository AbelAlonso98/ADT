package ficherosBinarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscribirFichData {

	
	public static void main(String[] args) throws IOException {
		File f = new File(".\\src\\ficherosPrueba\\FichData.dat");
		// Datos que queremos escribir
		String[] nombres = { "Nombre1", "Nombre2", "Nombre3", "Nombre4" };
		int[] edades = { 1, 2, 3, 4 };
		
		// Los escribimos
		DataOutputStream out = new DataOutputStream(new FileOutputStream(f));
		for(int i = 0 ; i < nombres.length; i++) {
			out.writeUTF(nombres[i]);
			out.writeInt(edades[i]);
		}
		out.close();
		
		// Los leemos
		String nom;
		int ed;
		DataInputStream in = new DataInputStream(new FileInputStream(f));
		try {
			while(true) {
				nom = in.readUTF();
				ed = in.readInt();
				System.out.println("Nombre: " + nom + ", edad: " + ed);
			}
		} catch (EOFException e) {
			
		}
		in.close();
	}

}
