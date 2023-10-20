package exercisesXML.SAX;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class EjemploSAXEmpleados {

	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
		String ruta = ".\\src\\ficherosPrueba\\Empleados.xml";
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		parserFactory.setNamespaceAware(true);
		SAXParser parser = parserFactory.newSAXParser();
		XMLReader procesadorXML = parser.getXMLReader();
		GestionContenido2 gestor = new GestionContenido2();
		procesadorXML.setContentHandler(gestor);
		InputSource fileXML = new InputSource(ruta);
		procesadorXML.parse(fileXML);

	}
}
