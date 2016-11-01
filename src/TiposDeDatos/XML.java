package TiposDeDatos;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import Contenedores.Contenedor;

//datos a xml y guarda
public class XML{

	public static void write(Contenedor contenedor, String file) throws FileNotFoundException{
		XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(file));
		xmlEncoder.writeObject(contenedor);
		xmlEncoder.close();
	}


	public static Contenedor read(String filename) throws FileNotFoundException{
		XMLDecoder decoder =new XMLDecoder(new FileInputStream(filename));
		Contenedor contenedor = (Contenedor)decoder.readObject();
		decoder.close();
		return contenedor;

		
	}



}
