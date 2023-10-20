package ejemplosObjetosFicheros;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Clase para leer archivos binarios que contienen objetos de la clase persona.
 * @author Abel Alonso Jiménez
 */
public class LeerFichObjeto {

	public static void main(String[] args) {
		String ruta = ".\\src\\ficherosPrueba\\";
		File file = new File(ruta + "FichPersona.dat");

		try {
			// Creo los streams
			FileInputStream filein = new FileInputStream(file);
			ObjectInputStream objectOs = new ObjectInputStream(filein);
			
			// Creo una lista de personas para almacenar los datos que lea
			ArrayList<Persona> personas = new ArrayList<Persona>();
			Persona aux;

			// Recorro el archivo y añado a la lista.
			aux = (Persona) objectOs.readObject();
			while (aux != null) {
				personas.add(aux);
				System.out.println(aux);
				aux = (Persona) objectOs.readObject();
			}
			objectOs.close();
			
			// Saco los datos de la lista por pantalla
			personas.forEach(p -> System.out.println(p));

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (EOFException e) {
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
