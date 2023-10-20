package exercisesXML;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Clase utilizada para leer un archivo XML e imprimirlo por pantalla. En esta clase
 * utilizamos un XML del cual ya sabiamos la estructura, lo que lo hace fácil de recorrer
 * pero inutiliza la clase en el momento que modificamos la estructura del XML.
 * 
 * @author Abel Alonso - ZTL55769@educastur.es
 */
public class LeerEmpleado2XML {

	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			// Creamos el documento y lo cargamos en el parse.
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File(".\\ficheros\\Empleados.xml"));
			
			// Eliminamos los nodos vacios en caso que los haya
			document.getDocumentElement().normalize();
			
			//  Imprimimos la informacion del nodo
			System.out.printf("Elemento raiz: %s %n", document.getDocumentElement().getNodeName());
			
			// Sacamos una lista de los nodos "empleado" del documento, e imprimimos los datos de dicha lista.
			NodeList empleados = document.getElementsByTagName("empleado");
			System.out.printf("Nodos empleado a recorrer: %d %n", empleados.getLength());
			
			// Recorremos la lista de empleados imprimiendo los elementos.
			for(int i = 0 ; i < empleados.getLength(); i++) {
				Node emple = empleados.item(i);
				if(emple.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) emple;
					System.out.printf("ID = %s %n", elemento.getAttribute("id"));
					System.out.printf(" * Apellido = %s %n", elemento.getElementsByTagName("apellido").item(0).getTextContent());
					System.out.printf(" * Departamento = %s %n", elemento.getElementsByTagName("dep").item(0).getTextContent());
					System.out.printf(" * Salario = %s %n", elemento.getElementsByTagName("salario").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
