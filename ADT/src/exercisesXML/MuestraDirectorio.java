package exercisesXML;

import java.io.File;
import java.io.IOException;

public class MuestraDirectorio {

	public static void main(String[] args) throws IOException {
		String ruta = ".";
		// Compruebo que me han pasado una ruta por argumentos
		if (args.length >= 1)
			ruta = args[0];
		else if (args.length == 0)
			System.err.println("Hay que introducir un directorio.");

		// Miro si ese fichero existe, si no, saco error por consola.
		File fichero = new File(ruta);
		if (!fichero.exists()) {
			System.err.println("No existe el fichero o directorio en: " + ruta);
		} else {
			// Una vez comprobado que existe, trabajo con él, diferenciando si es un fichero
			// o un directorio
			if (fichero.isDirectory()) {
				System.out.println(ruta + " es un directorio con contenidos: ");
				File[] ficheros = fichero.listFiles();
				for (File f : ficheros) {
					String textoDescr = f.isDirectory() ? "/" : f.isFile() ? "_" : "?"; // Ternaria que si es un fichero
																						// pone un / si es un archivo
																						// pone _
					System.out.println(textoDescr + "	" + f.getName());
				}
			} else {
				System.out.println(fichero.getName() + " es un fichero.");
			}
		}
	}

}
