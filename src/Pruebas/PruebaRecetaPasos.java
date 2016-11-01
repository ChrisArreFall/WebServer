package Pruebas;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import Menu.Pasos;
import Menu.Receta;

public class PruebaRecetaPasos {

	public static void main(String[] args) throws FileNotFoundException {
		Receta receta = new Receta();
		Pasos paso = new Pasos();
		Pasos paso2 = new Pasos();
		Pasos paso3 = new Pasos();
		
		paso.setPaso("paso 1");
		paso2.setPaso("paso 2");
		paso3.setPaso("paso 3");
		
		receta.addPaso(paso);
		receta.addPaso(paso2);
		receta.addPaso(paso3);
		
		
		XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream("pruebaRecetaPasos.xml"));
		xmlEncoder.writeObject(receta);
		xmlEncoder.close();
	}

}
