package Algoritmos;

public class Transformador {

	public static LinkedList<T> LDaLL(ListaDoble<T> lista){
		LinkedList<T> listaNueva = new LinkedList<T>();
		for(int i = 0; i < lista.size(); i++){
			listaNueva.addFirst(lista.get(i).getDato());
		}
		return listaNueva;
	}
	
	public static ListaDoble<T> LLaLD(LinkedList<T> lista){
		ListaDoble<T> listaNueva = new ListaDoble<T>();
		for(int i = 0; i < lista.size(); i++){
			listaNueva.addFirst(lista.get(i));
		}
		return listaNueva;
	}
}
