package ejemplosObjetosFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Clase para escribir objetos personas en archivos binarios.
 * @author Abel Alonso Jiménez
 */
public class EscribirFichObjeto {

	public static void main(String[] args) {
		Persona persona;
		String ruta = ".\\src\\ficherosPrueba\\";
		File file = new File(ruta + "FichPersona.dat");

		try {
			// Creo los streams para leer
			FileOutputStream fileout;
			ObjectOutputStream objectOS;
			
			// Distingo si el archivo existe o no, para sobreescribirlo usando mi propio
			// stream.
			if (!file.exists()) {
				fileout = new FileOutputStream(file);
				objectOS = new ObjectOutputStream(fileout);
			} else {
				fileout = new FileOutputStream(file, true);
				objectOS = new MiObjectOutputStream(fileout);
			}
			
			// Datos de las personas a meter.
			String[] nombres = { "Ana", "Luis Miguel", "Alicia", "Pedro", "Manuel", "Andres", "Julio", "Antonio",
					"Maria Jesus" };

			int[] edades = { 14, 15, 13, 15, 16, 12, 16, 14, 13 };
			System.out.println("GRABO LOS DATOS DE PERSONA");

			// Creo las personas y las escribo en el archivo.
			for (int i = 0; i < edades.length; i++) {
				persona = new Persona(nombres[i], edades[i]);
				objectOS.writeObject(persona);
				System.out.println("GRABO LOS DATOS DE PERSONA");
			}
			
			// Vacio el stream y lo cierro.
			objectOS.reset();
			objectOS.close();
			
			// Tratamiento de excepciones.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
