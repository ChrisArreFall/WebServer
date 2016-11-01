package Menu;

import EstructurasDeDatos.*;
import java.util.LinkedList;

//import EstructurasDeDatos.LinkedList;

@SuppressWarnings("unused")
public class Receta {
	LinkedList<Pasos> listaPasos = new LinkedList<Pasos>();
	
	

	public Receta(){
		super();
	}



	public LinkedList<Pasos> getListaPasos() {
		return listaPasos;
	}



	public void setListaPasos(LinkedList<Pasos> listaPasos) {
		this.listaPasos = listaPasos;
	}
	
	public void addPaso(Pasos paso) {
		listaPasos.add(paso);
	}

}
