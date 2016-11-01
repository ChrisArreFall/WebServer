package Main;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import EstructurasDeDatos.*;
import Menu.Orden;
import Restaurante.Calificacion;
import Usuario.*;

@Path("/MainCliente")
public class MainCliente {


	@POST
	@Path("/addClienteCuenta")
	@Consumes(MediaType.TEXT_PLAIN)
	public static String addClienteCuenta(String cuenta){
		Cliente usuarioTemporal = new Cliente();

		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		usuarioTemporal = gson.fromJson(cuenta, Cliente.class);
		
		MainCheff.contenedor.addCliente(usuarioTemporal);
		System.out.println(usuarioTemporal.getNombre().toString() + " se ha agregado");
		System.out.println(MainCheff.contenedor.getListaClientes().get(0).getNombre().toString());
		return "<html>" + "<title>" + "Hello, World!" + "</title>" + "<body><h1>" + "Hello, World!" + "</body></h1>" + "</html>";
		
		
	}

	@POST
	@Path("/searchClienteCuenta")
	@Consumes(MediaType.TEXT_PLAIN)
	public String searchClienteCuenta(String cuenta){
		/*
		UsuarioTemporal usuarioTemporal = new UsuarioTemporal();
		boolean respuesta;
		// si falla es esto

		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		usuarioTemporal = gson.fromJson(cuenta, UsuarioTemporal.class);



		respuesta = MainCheff.contenedor.getRestaurante().validarCheff(usuarioTemporal.getUsuario(), usuarioTemporal.getContrasena());

		if(respuesta==true){
			return "true";
		}
		else {
			return "false";
		}
		*/
		return "true";
	}

	/**
	 * Navegar por el menú. Se debe mostrar para cada platillo: los ingredientes, valor nutricional, tiempo de preparación, precio, entre otros.
	 */

	@GET
	@Path("/getMenu")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMenu(){
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String string = gson.toJson(MainCheff.contenedor);
		return string;
	}

	/**
	 * Progreso de las órdenes
	 */
	@GET
	@Path("/getProgresoOrdenes")
	@Produces(MediaType.TEXT_PLAIN)
	public String getProgresoOrdenes(){
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String string = gson.toJson(MainCheff.contenedor);
		return string;
	}

	/**
	 * Pagar la cuenta: El app permite a los clientes dividir la factura y enviar el pago. Para esto se debe
	 * crear un botón que simula el pago una vez que se ha dividido la cuenta, no deben incluirse datos de tarjetas por ejemplo. Una vez que se realiza el pago se debe enviar un recibo como comprobante del pago.
	 */

	@POST
	@Path("/setPagoCuenta")
	@Consumes(MediaType.TEXT_PLAIN)
	public void setPagar(String lista){
		//String orden, String monto
		LinkedList<String> Lista = new LinkedList<String>();

		String orden;
		String monto;
		// si falla es esto
		java.lang.reflect.Type listType = new TypeToken<LinkedList<String>>(){

		}.getType();
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		Lista = gson.fromJson(lista, listType);

		orden = Lista.get(0);
		monto = Lista.get(1);





		Integer Monto;
		GsonBuilder builder1 = new GsonBuilder();
		Gson gson1 = builder1.create();
		Monto = gson1.fromJson(monto, Integer.class);

		Orden Orden = new Orden();
		GsonBuilder builder2 = new GsonBuilder();
		Gson gson2 = builder2.create();
		Orden = gson2.fromJson(orden, Orden.class);


		MainCheff.contenedor.getRestaurante().getColaOrdenes().buscarOrden(Orden).getDato().Pagar(Monto);
	}

	/**
	 * Selección de platillos por voz.
	 */
	@POST
	@Path("/addOrden")
	@Consumes(MediaType.TEXT_PLAIN)
	public void addOrden(String orden){
		Orden Orden = new Orden();
		GsonBuilder builder2 = new GsonBuilder();
		Gson gson2 = builder2.create();
		Orden = gson2.fromJson(orden, Orden.class);
		MainCheff.contenedor.getRestaurante().getColaOrdenes().agregarACola(Orden);
	}

	/**
	 * Calificar el restaurante y comentar sobre las órdenes
	 */

	@POST
	@Path("/setCalificarRestaurante")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String setCalificarRestaurante(Calificacion calificacion){
		MainCheff.contenedor.getRestaurante().addCalificacion(calificacion);
		return "<html>" + "<title>" + "Hello, World!" + "</title>" + "<body><h1>" + "Hello, World!" + "</body></h1>" + "</html>";

	}
	
	
	
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_HTML)
	public String helloHtml(){
		return "<html>" + "<title>" + "Hello, World!" + "</title>" + "<body><h1>" + "Hello, World!" + "</body></h1>" + "</html>";
	}

}
