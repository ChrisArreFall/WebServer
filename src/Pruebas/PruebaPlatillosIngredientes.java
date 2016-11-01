package Pruebas;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedList;

import Ingredientes.Carnes;
import Ingredientes.Granos;
import Ingredientes.IngredienteSolo;
import Ingredientes.Vegetales;
import Menu.Pasos;
import Menu.Platillo;
import Menu.Receta;

public class PruebaPlatillosIngredientes {

	public static void main(String[] args) throws FileNotFoundException {
		Carnes carne = new Carnes();
		carne.setName("pollo");
		Vegetales vegetal = new Vegetales();
		vegetal.setName("lechuga");
		Granos grano = new Granos();
		grano.setName("frijoles");
		
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
		
		Platillo platillo = new Platillo();
		platillo.setDatoExtra("SIRVE PLATILLO");
		platillo.setInformacionNutricional("Muy nutritivo");
		platillo.setPrecio(50);
		platillo.setTiempoDePreparacion(2);
		platillo.setReceta(receta);
		platillo.setNombre("Pizza");
		
		LinkedList<IngredienteSolo> listaIngredientes = new LinkedList<IngredienteSolo>();
		IngredienteSolo ingredienteSolo = new IngredienteSolo();
		IngredienteSolo ingredienteSolo2 = new IngredienteSolo();
		IngredienteSolo ingredienteSolo3 = new IngredienteSolo();
		
		ingredienteSolo.setCarne(carne);
		ingredienteSolo2.setGrano(grano);
		ingredienteSolo3.setVegetal(vegetal);
		
		listaIngredientes.add(ingredienteSolo3);
		listaIngredientes.add(ingredienteSolo2);
		listaIngredientes.add(ingredienteSolo);
		
		platillo.addIngrediente(ingredienteSolo);
		platillo.addIngrediente(ingredienteSolo2);
		platillo.addIngrediente(ingredienteSolo3);
		
		XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream("PruebaPlatillosIngredientes.xml"));
		xmlEncoder.writeObject(platillo);
		xmlEncoder.close();

	}

}
