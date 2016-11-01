package Pruebas;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import Restaurante.Calificacion;
import Restaurante.Restaurante;

public class PruebaRestauranteCalificaciones {

	public static void main(String[] args) throws FileNotFoundException{
		Restaurante restaurante = new Restaurante();
		Calificacion calificacion = new Calificacion();
		Calificacion calificacion2 = new Calificacion();
		Calificacion calificacion3 = new Calificacion();
		
		calificacion.setCalificacion(5);
		calificacion2.setCalificacion(6);
		calificacion3.setCalificacion(9);
		
		restaurante.addCalificacion(calificacion);
		restaurante.addCalificacion(calificacion2);
		restaurante.addCalificacion(calificacion3);
		
		XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream("PruebaRestauranteCalificaciones.xml"));
		xmlEncoder.writeObject(restaurante);
		xmlEncoder.close();
		
		
	}
}
