package exercisesXML.personas;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Clase que extiende a DefaultHandler pensada para el archivo PersonasTfno.XML
 * 
 * @author Abel Alonso Jiménez - ZTL55769@educastur.es
 * @see DefaultHandler
 */
public class PersonaTfnoHandler extends DefaultHandler {

	private StringBuilder value;

	public PersonaTfnoHandler() {
		super();
		this.value = new StringBuilder();
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Comienzo de PersonasTfno.XML\n");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Final PersonasTfno.XML");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		this.value.setLength(0);
		// Si no tiene atributos, el bucle no itera puesto que attributes.getLength() ya
		// es 0.
		for (int i = 0; i < attributes.getLength(); i++)
			System.out.println(attributes.getQName(i) + ": " + attributes.getValue(i));

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		this.value.append(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
		case "persona": {
			System.out.println("");
			break;
		}
		case "nombre":
			System.out.println("Nombre: " + this.value.toString());
			break;
		case "edad":
			System.out.println("Edad: " + this.value.toString());
			break;
		}
	}
}
