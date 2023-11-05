package ficherosAleatorios;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EscribirFichAleatorioUnReg {

	public static void main(String[] args) throws IOException {
		File f = new File(".\\src\\ficherosPrueba\\AleatorioEmple.dat");
		RandomAccessFile file = new RandomAccessFile(f, "rw");
		StringBuffer buffer;
		String apellido = "GONZALEZ";
		Double salario = 1230.87;
		int dep = 10;

		// INSERTAR AL FINAL
		/*
		 * long posicion = file.length(); file.seek(posicion); int id = (int)
		 * ((posiciojn + 36) / 36);
		 */
		int id = 20;
		long posicion = (id - 1) * 36;
		file.seek(posicion);

		file.writeInt(id);
		buffer = new StringBuffer(apellido);
		buffer.setLength(10);
		file.writeChars(buffer.toString());
		file.writeInt(dep);
		file.writeDouble(salario);
		file.close();

	}

}
