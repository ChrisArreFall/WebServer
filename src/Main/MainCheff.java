package Main;

import javax.ws.rs.Produces;

import java.io.FileNotFoundException;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.LinkedList;
import Contenedores.Contenedor;
//import EstructurasDeDatos.*;
import Ingredientes.IngredienteSolo;
import Menu.Orden;
import Menu.Pasos;
import Menu.Platillo;
import Menu.Receta;
import TiposDeDatos.XML;
import Usuario.Cheff;


@Path("/MainCheff")
public class MainCheff {
	public static Contenedor contenedor = new Contenedor();
	//crear cheff
	
	
	@POST
	@Path("/addCheffCuenta")
	@Consumes(MediaType.TEXT_PLAIN)
	public void addCheffCuenta(String cuenta){
		LinkedList<String> Lista = new LinkedList<String>();

		String Usuario;
		String Contrasena;
		// si falla es esto
		Type listType = new TypeToken<LinkedList<String>>(){

		}.getType();
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		Lista = gson.fromJson(cuenta, listType);
        
		Usuario = Lista.get(0);
		Contrasena = Lista.get(1);
		
		Cheff cheff = new Cheff();
		cheff.setContrasena(Contrasena);
		cheff.setUsuario(Usuario);
		
		contenedor.addCheff(cheff);
		
		
	}
	
	
	@POST
	@Path("/searchCheffCuenta")
	@Consumes(MediaType.TEXT_PLAIN)
	public String searchCheffCuenta(String cuenta){
		LinkedList<String> Lista = new LinkedList<String>();

		String Usuario;
		String Contrasena;
		boolean respuesta;
		// si falla es esto
		Type listType = new TypeToken<LinkedList<String>>(){

		}.getType();
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		Lista = gson.fromJson(cuenta, listType);
        
		Usuario = Lista.get(0);
		Contrasena = Lista.get(1);
		
		
		respuesta = contenedor.getRestaurante().validarCheff(Usuario, Contrasena);
		
		if(respuesta==true){
			return "true";
		}
		else {
			return "false";
		}
	}
	
	/**
	 * Registrar el inventario de ingredientes. Se debe permitir registrar ingredientes para las 
	 * categorías más importantes (frutas, granos, vegetales, lácteos, carnes). Los ingredientes 
	 * se guardan sin ningún orden en particular.
	 * @return 
	 */
	@POST
	@Path("/setIngredientes")
	@Consumes(MediaType.TEXT_PLAIN)//ya
	public void setIngredientes(String ingredientes){
		GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        IngredienteSolo ingrediente = new IngredienteSolo();
        ingrediente = gson.fromJson(ingredientes, IngredienteSolo.class);
        
        
        
		if(!ingrediente.getCarne().equals(null)){
			contenedor.getListaCarnes().addFirst(ingrediente.getCarne());
		}
		else if(!ingrediente.getFruta().equals(null)){
			contenedor.getListaFrutas().addFirst(ingrediente.getFruta());
		}
		else if(!ingrediente.getGrano().equals(null)){
			contenedor.getListaGranos().addFirst(ingrediente.getGrano());
		}
		else if(!ingrediente.getLacteo().equals(null)){
			contenedor.getListaLacteos().addFirst(ingrediente.getLacteo());
		}
		else if(!ingrediente.getVegetal().equals(null)){
			contenedor.getListaVegetales().addFirst(ingrediente.getVegetal());
		}
		
	}
	
	
	/**
	 * Permite registrar el menú del restaurante. Para cada platillo se registran los ingredientes que lo
	 * componen (incluye la cantidad), información nutricional, precio, tiempo de preparación, recetas
	 * y cualquier otro dato necesario
	 */
	
	@POST
	@Path("/addPlatilloMenu")
	@Consumes(MediaType.TEXT_PLAIN)//ya 
	public void addPlatilloMenu(String platillo){
		Platillo platillos = new Platillo();
		GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        platillos = gson.fromJson(platillo, Platillo.class);
		contenedor.getListaPlatillos().addFirst(platillos);
		
	}
	
	
	/**
	 * Cuando una orden es registrada, se ingresa en una cola de prioridad según la categoría del
	 * cliente (bronce, oro, platino). Cuando una orden está lista para ser atendida, los chefs reciben
	 * una notificación.
	 */
	
	@GET
	@Path("/getOrden")
	@Produces(MediaType.TEXT_PLAIN)//ya
	public String getOrden(){
		GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String string = gson.toJson(contenedor);
		return string.toString();
		
	}
	
	
	
	/**
	 * Cuando la orden va a ser preparada, el sistema buscará la receta de la orden y cada uno de los
	 * ingredientes, utilizando Binary Search (asumimos que los ingredientes no se acaban del
	 * inventario).
	 */
	@POST
	@Path("/getReceta")
	//@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String getReceta(String orden){
        Orden orden1 = new Orden();
        GsonBuilder builder2 = new GsonBuilder();
        Gson gson2 = builder2.create();
        orden1 = gson2.fromJson(orden, Orden.class);
        
        
        Receta receta = new Receta();
        receta = orden1.getPlatillo().getReceta();
        
        
        
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String string = gson.toJson(receta);
        
        
		return string;
	}
	
	
	
	
	/**
	 * Cada chef marca el paso asignado cuando lo termine y el sistema registra el tiempo real de cada
	 * paso.
	 * @throws InterruptedException 
	 */
	
	@POST
	@Path("/borrarPasosOrden")
	@Consumes(MediaType.TEXT_PLAIN)
	public void borrarPasosOrden(String lista) throws InterruptedException{
		
		//String paso,String orden
		LinkedList<String> Lista = new LinkedList<String>();
		
		String paso;
		String orden;
		// si falla es esto
		Type listType = new TypeToken<LinkedList<String>>(){
			
		}.getType();
		GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Lista = gson.fromJson(lista, listType);
        
        paso = Lista.get(0);
        orden = Lista.get(1);
		
		
		Pasos Paso = new Pasos();
		GsonBuilder builder1 = new GsonBuilder();
        Gson gson1 = builder1.create();
        Paso = gson1.fromJson(paso, Pasos.class);
		
        Orden Orden = new Orden();
		GsonBuilder builder2 = new GsonBuilder();
        Gson gson2 = builder2.create();
        Orden = gson2.fromJson(orden, Orden.class);
		
		
        Orden.getListaPasos().remove(Paso);
        
        if(contenedor.getRestaurante().getColaOrdenes().buscarOrden(Orden).getDato().getListaPasos().size() == 1){
        	contenedor.getRestaurante().getColaOrdenes().buscarOrden(Orden).getDato().getListaPasos().remove(Paso);
        	contenedor.getRestaurante().getColaOrdenes().sacarDeCola();
        	
        }
        else{
        	contenedor.getRestaurante().getColaOrdenes().buscarOrden(Orden).getDato().getListaPasos().remove(Paso);
        }
        
        
        
        
	}
	
	
	
	
	/**
	 * Cuando la receta se completa, se envía una notificación al cliente. El cliente en cualquier
	 * momento puede ver el estado de la orden
	 */
	/*
	@POST
	@Path("/setCompletarOrden")
	@Consumes(MediaType.TEXT_PLAIN)
	public void setCompletarOrden(String orden){
		Orden Orden = new Orden();
		GsonBuilder builder2 = new GsonBuilder();
        Gson gson2 = builder2.create();
        Orden = gson2.fromJson(orden, Orden.class);
		//aqui tengo que enviar la notifivacion al cliente
        
		contenedor.getListaOrdenes().remove(Orden);
	}
	*/
	@GET
	@Path("/setTerminarDia")
	@Produces(MediaType.TEXT_HTML)
	public String setTerminarDia() throws FileNotFoundException{
		XML.write(contenedor, "/Users/chrisarrefall/Documents/Contenedor.xml");
		return "<html>" + "<title>" + "Termino Dia!" + "</title>" + "<body><h1>" + "Termino Dia!" + "</body></h1>" + "</html>";
	}
	@GET
	@Path("/getIniciarDia")
	@Produces(MediaType.TEXT_HTML)
	public String getIniciarDia() throws FileNotFoundException{
		contenedor = XML.read("/Users/chrisarrefall/Documents/Contenedor.xml");
		return "<html>" + "<title>" + "Inicio Dia!" + "</title>" + "<body><h1>" + "Inicio Dia!" + "</body></h1>" + "</html>";
	}
	
	
	
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_HTML)
	public String helloHtml(){
		return "<html>" + "<title>" + "Hello, World!" + "</title>" + "<body><h1>" + "Hello, World!" + "</body></h1>" + "</html>";
	}
	

}
