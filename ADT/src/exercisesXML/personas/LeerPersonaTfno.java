package exercisesXML.personas;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class LeerPersonaTfno {

	public static void main(String[] args) {
		String rutaFichXML = ".\\src\\ficherosPrueba\\PersonasTfno.xml";
		
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			PersonaTfnoHandler handler = new PersonaTfnoHandler();
			parser.parse(rutaFichXML, handler);
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.err.println(e.getMessage());
		}

	}

}
