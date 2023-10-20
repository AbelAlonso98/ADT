package exercisesXML;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class BorrarDirectorio {

	public static void main(String[] args) {
		String ruta = ".//";
		File dir = new File(ruta + "directorioEJ2");
		// Comprobamos que el directorio existe y que no es un fichero
		if (dir.exists()) {
			// Si el directorio esta lleno, no borramos y preguntamos al usuario si quiere
			// borrar o no.
			if (dir.list().length > 0) {		
				System.out.println("El directorio tiene los siguientes archivos dentro, ¿quieres borrarlo? Y/N");
				List.of(dir.listFiles()).forEach(t -> System.out.println(t.getName()));
				// Creamos un scanner para leer por consola
				Scanner sc = new Scanner(System.in);
				String command = sc.nextLine();
				// Si el usuario escribe Y borra, si N, no.
				switch (command) {
				case "Y": {
					List.of(dir.listFiles()).forEach(f -> f.delete());
					if (dir.delete())
						System.out.println("Directorio eliminado correctamente.");
					else {
						System.err.println("Error borrando.");
					}
					break;
				}
				case "N":{
					System.out.println("No se ha borrado el directorio");
					break;
				}
				default:
					System.err.println("Comando no valido");
					break;
				}
				sc.close();
			} else { // En este caso el directorio esta vacio, asi que lo borramos directamente.
				dir.delete();
				System.out.println("Directorio eliminado correctamente.");
			}
		} else // Si no existe, damos error por consola.
			System.err.println("El directorio no existe.");

	}

}
