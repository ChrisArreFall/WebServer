package Pruebas;



import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Contenedores.Contenedor;
import Ingredientes.Carnes;
import Ingredientes.Frutas;
import Ingredientes.Granos;
import Ingredientes.IngredienteSolo;
import Ingredientes.Lacteos;
import Ingredientes.Vegetales;
import Main.MainCliente;
import Menu.Orden;
import Menu.Pasos;
import Menu.Platillo;
import Menu.Receta;
import Restaurante.Calificacion;
import Restaurante.Restaurante;
import Usuario.Cheff;
import Usuario.Cliente;

public class PruebaUno {

	public static void main(String[] args) throws IOException {
		Contenedor contenedor = new Contenedor();
		

		Calificacion calificacion = new Calificacion();
		Cliente cliente = new Cliente();
		
		cliente.setNombre("Ricardo");
		cliente.setContrasena("12345678");
		cliente.mesa = 3;
		cliente.setCategoria(0);
	
		Cheff cheff = new Cheff();
		cheff.setContrasena("123456");
		cheff.setUsuario("Pedro");
		
		
		calificacion.setCalificacion(5);
		Receta receta = new Receta();
		Pasos paso = new Pasos();
		Pasos paso2 = new Pasos();
		Pasos paso3 = new Pasos();
	
		IngredienteSolo ingrediente = new IngredienteSolo();
		IngredienteSolo ingrediente2 = new IngredienteSolo();
		IngredienteSolo ingrediente3 = new IngredienteSolo();
		
		Carnes carne = new Carnes();
		Frutas fruta = new Frutas();
		Granos grano = new Granos();
		Lacteos lacteo = new Lacteos();
		Vegetales vegetal = new Vegetales();
		Platillo platillo = new Platillo();
		Orden orden = new Orden();
		
		Carnes carne2 = new Carnes();
		Frutas fruta2 = new Frutas();
		Granos grano2 = new Granos();
		Lacteos lacteo2 = new Lacteos();
		Vegetales vegetal2 = new Vegetales();
		
		Carnes carne3 = new Carnes();
		Frutas fruta3 = new Frutas();
		Granos grano3= new Granos();
		Lacteos lacteo3 = new Lacteos();
		Vegetales vegetal3 = new Vegetales();
		
		Carnes carne4 = new Carnes();
		Frutas fruta4 = new Frutas();
		Granos grano4 = new Granos();
		Lacteos lacteo4 = new Lacteos();
		Vegetales vegetal4 = new Vegetales();
		
		carne.setName("pollo");
		carne2.setName("pescado");
		carne3.setName("cerdo");
		carne4.setName("atun");
		
		fruta.setName("guanabana");
		fruta2.setName("banano");
		fruta3.setName("manzana");
		fruta4.setName("melon");
		
		grano.setName("arroz");
		grano2.setName("frijol");
		grano3.setName("garbanzos");
		grano4.setName("ajonjoli");
		
		lacteo.setName("leche");
		lacteo2.setName("yogurt");
		lacteo3.setName("queso");
		lacteo4.setName("natilla");
		
		vegetal.setName("pepino");
		vegetal2.setName("lechuga");
		vegetal3.setName("zanaoria");
		vegetal4.setName("apio");
		
		paso.setPaso("iniciar");
		paso2.setPaso("medio");
		paso3.setPaso("final");
		
		receta.addPaso(paso);
		receta.addPaso(paso2);
		receta.addPaso(paso3);
		
		ingrediente.setCarne(carne2);
		ingrediente2.setFruta(fruta3);
		ingrediente3.setLacteo(lacteo2);
		
		platillo.setCantidadDeIngredientes(5);
		platillo.setDatoExtra("prueba");
		platillo.setInformacionNutricional("muy nutritivo");
		platillo.setPrecio(5000);
		platillo.setReceta(receta);
		platillo.addIngrediente(ingrediente);
		platillo.addIngrediente(ingrediente2);
		platillo.addIngrediente(ingrediente3);
		
		orden.setCliente(cliente);
		orden.setListaPasos(platillo.getReceta().getListaPasos());
		orden.setPlatillo(platillo);
		
		Restaurante restaurante = new Restaurante();
		restaurante.addCalificacion(calificacion);
		restaurante.getColaOrdenes().agregarACola(orden);
		
		
		contenedor.addCarnes(carne);
		contenedor.addCarnes(carne2);
		contenedor.addCarnes(carne3);
		contenedor.addCarnes(carne4);
		contenedor.addFrutas(fruta);
		contenedor.addFrutas(fruta2);
		contenedor.addFrutas(fruta3);
		contenedor.addFrutas(fruta4);
		contenedor.addGranos(grano);
		contenedor.addGranos(grano2);
		contenedor.addGranos(grano3);
		contenedor.addGranos(grano4);
		contenedor.addLacteos(lacteo);
		contenedor.addLacteos(lacteo2);
		contenedor.addLacteos(lacteo3);
		contenedor.addLacteos(lacteo4);
		contenedor.addVegetales(vegetal);
		contenedor.addVegetales(vegetal2);
		contenedor.addVegetales(vegetal3);
		contenedor.addVegetales(vegetal4);
		contenedor.addPlatillos(platillo);
		//contenedor.addCalificacion(calificacion);
		//contenedor.getRestaurante().getColaOrdenes().agregarACola(orden);
		contenedor.addCliente(cliente);
		contenedor.addCheff(cheff);
		
		
		
		
		
		
		

		
		XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Contenedor.xml")));
		xmlEncoder.writeObject(contenedor);
		xmlEncoder.close();
		
		
		LinkedList<String> Lista = new LinkedList<String>();
		String paso1;
		String orden1;
		
		
		
		FileWriter file = new FileWriter("JSON.txt");
		
		GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String string = gson.toJson(contenedor);
        //System.out.println(string);
        
        //cliente
        GsonBuilder builder1 = new GsonBuilder();
        Gson gson1 = builder1.create();
        String string1 = gson1.toJson(ingrediente);
       
        
        
        
		file.write(string1);
		file.flush();
		file.close();
		
		
		System.out.println("llego");

	}

}
