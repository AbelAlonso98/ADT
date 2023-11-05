package ficherosAleatorios;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerFichAleatorio {

	public static void main(String[] args) throws IOException {
		File f = new File(".\\src\\ficherosPrueba\\AleatorioEmple.dat");
		RandomAccessFile file = new RandomAccessFile(f, "r");
		int id, dep, posicion;
		Double salario;
		char[] apellido = new char[10];
		boolean finArchivo = false;

		posicion = 0;

		do {
			try {
				file.seek(posicion);
				id = file.readInt();

				for (int i = 0; i < apellido.length; i++) {
					apellido[i] = file.readChar();

				}
				String apellidos = new String(apellido);
				dep = file.readInt();
				salario = file.readDouble();

				if (id > 0)
					System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n", id, apellidos.trim(),
							dep, salario);
				posicion += 36;

			} catch (EOFException e) {
				finArchivo = true;
				file.close();
			}
		} while (!finArchivo);

	}

}
