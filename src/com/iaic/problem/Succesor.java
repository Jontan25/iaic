package com.iaic.problem;
/**
 * No es un nodo. Es algo previo. Es un sucesor que se crea al
 * desplegar un nodo extraído de la estructura de abiertos.
 * Solo contiene el estado y el operador aplicado.
 * @author alberto
 *
 */
public class Succesor {
	/**
	 * El estado del problema si generásemos el nodo.
	 * OJO: no representa un nodo que estemos visitando ni que
	 * vayamos a visitar; solo es una estructura intermedia entre
	 * estado y nodo "oficial". 
	 */
	private Object estado;
	/**
	 * El operador que tenemos que aplicar para llegar a este estado.
	 */
	private String operador;
	
	public Succesor(Object e,String o) {
		estado=e;operador=o;
	}
	public Succesor() {
		this(null,"");
	}
	/**
	 * 
	 * @return El estado que representa.
	 */
	public Object getEstado() {
		return estado;
	}
	/**
	 * 
	 * @return El operador que hay que tomar para obtener el estado.
	 */
	public String getOperador() {
		return operador;
	}
}
