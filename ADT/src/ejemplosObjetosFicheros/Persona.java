package ejemplosObjetosFicheros;

import java.io.Serializable;

/**
 * Clase persona utilizada para la lectura de ficheros de objetos.
 * @author Abel Alonso Jiménez
 */
public class Persona implements Serializable {

	private static final long serialVersionUID = 31101998L;

	@Override
	public String toString() {
		return "Nombre: " + nombre + ", edad: " + edad;
	}

	private String nombre;
	private int edad;
	
	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
}
