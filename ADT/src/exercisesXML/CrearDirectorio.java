package exercisesXML;

import java.io.File;
import java.io.IOException;

public class CrearDirectorio {

	public static void main(String[] args) {
		String ruta = ".//";
		File dir = new File(ruta + "directorioEJ2");
		if (dir.mkdir() && dir.exists()) {
			System.out.println("Directorio creado correctamente.");

			File f1 = new File(dir, "f1");
			File f2 = new File(dir, "f2");
			File f3 = new File(dir, "f3");
			try {
				f1.createNewFile();
				f2.createNewFile();
				if (f2.renameTo(f3))
					System.out.println("Archivo renombrado correctamente.");
				else
					System.err.println("Error renombrando el archivo");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
			System.err.println("Directorio ya existe.");
	}
}