package exercisesXML.SAX;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GestionContenido2 extends DefaultHandler {

	public GestionContenido2() {
		super();
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Comienzo del documento XML");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Final del documento XML");
	}

	@Override
	public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
		System.out.printf("\t Principio elemento: %s %n", qName);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.printf("\t Fin elemento: %s %n", localName);
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String car = new String(ch, start, length);
		car = car.replaceAll("[\\t\\n]", "");
		if (car.length() > 0)
			System.out.printf("\t\t Caracteres: %s %n", car);
	}

}
