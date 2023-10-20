package exercisesXML.ej6;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class ErroresXML {

	public static void main(String[] args) throws ParserConfigurationException {
		String ruta = "";
		if(args.length != 1) {
			System.err.println("Debe pasar un fichero como parámetro.");
		}
		String fichero = ruta + args[0];
		System.out.println("Analizado: " + fichero + "\n");
		try {
			SAXParserFactory sFactory = SAXParserFactory.newInstance();
			SAXParser parser = sFactory.newSAXParser();
			
			XMLReader xmlParser = parser.getXMLReader();
			xmlParser.parse(new InputSource(fichero));
			System.out.println("Fin del analisis.");
		} catch (IOException e) {
			// TODO: handle exception
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
