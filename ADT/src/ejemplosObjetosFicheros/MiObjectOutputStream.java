package ejemplosObjetosFicheros;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Redefinicion de la clase ObjectOutputStream, con la intencion de redifinir su 
 * metodo writeStreamHeader y quitar la cabecera.
 * @author Abel Alonso Jiménez
 */
public class MiObjectOutputStream extends ObjectOutputStream {

	
	public MiObjectOutputStream(OutputStream out) throws IOException {
		super(out);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void writeStreamHeader() throws IOException {

	}

}
