/**
 * 
 */
package com.iaic.problem;
import java.util.Vector;

/**
 * El nodo es la estructura que representa un nodo del árbol de
 * búsqueda. Ojo, del árbol de búsqueda, no el de estados. Esto
 * significa que puede haber nodos distintos con el mismo estado.
 * Esto ya dependerá de la búsqueda, y de los métodos de control
 * de repeticiones, ciclos etc.
 * Esta estructura solo contiene un estado asociado, una referencia
 * al nodo padre, y los datos sobre costes y operador necesarios.
 * @author alberto
 *
 */
public class Node {
	/**
	 * El estado del espacio de estados que representa el nodo.
	 */
	private Object estado;
	/**
	 * Una referencia al nodo padre para los nodos desplegados.
	 * Puede ser útil para la vuelta atrás o para resolver el
	 * camino de la raiz a una solución.
	 */
	private Node padre;
	/**
	 * El nombre del operador por el que se ha llegado a este
	 * estado. Nos puede servir tanto para saber el orden de
	 * operadores aplicados como para evitar ciclos.
	 */
	private String operador;
	/**
	 * El coste del camino hasta este nodo. g(n).
	 */
	private Double costeCamino;
	/**
	 * Coste total de la raiz al nodo.
	 */
	private Double costeTotal;
	/**
	 * La profundidad del nodo en el árbol de búsqueda.
	 */
	private Integer profundidad;
	
	
	public Node(Object e,Node p,String o,double c,double ct,int pr) {
		estado=e;padre=p;operador=o;
		costeCamino=new Double(c);
		costeTotal=new Double(ct);
		profundidad=new Integer(pr);
	}
	
	public Node(Object e,Node p,String o,double c,double ct) {
		this(e,p,o,c,ct,0);
	}
	
	public Node(Object e,Node p,String o,double c) {
		this(e,p,o,c,0,0);
	}
	
	public Node(Object e,Node p,String o) {
		this(e,p,o,0.0,0,0);
	}
	
	public Node(Object e,Node p) {
		this(e,p,"",0.0,0,0);
	}
	
	public Node(Object e) {
		this(e,null,"",0.0,0,0);
	}
	public Node() { 
		this(null,null,"",0.0,0,0);
	}
	
	/**
	 * Devuelve un Vector con la lista de nodos desde la
	 * raiz hasta el nodo actual, ambos incluidos, ordenada
	 * por profundidad.
	 * @return Vector con lista de nodos desde la raiz.
	 */
	public Vector<Node> camino() {
		Vector<Node> nodos=new Vector<Node>();
		nodos.clear();
		Node actual=this;
		while (actual.getProfundidad()!=0) {
			nodos.insertElementAt(actual,0);
			actual=actual.getPadre();
		}
		nodos.insertElementAt(actual,0);
		return nodos;
		
	}
	
	public Vector<String> caminoOperadores() {
		Vector<String> opers=new Vector<String>();
		opers.clear();
		Node actual=this;
		while (actual.getProfundidad()!=0) {
			opers.insertElementAt(actual.getOperador(),0);
			actual=actual.getPadre();
		}
		return opers;
	}
	
	/**
	 * 
	 * @return El valor de la profundidad del nodo en el 
	 * árbol de búsqueda como entero.
	 */
	public int getProfundidad() {
		return profundidad.intValue();
	}
	/**
	 * 
	 * @return El valor del coste del camino hasta este
	 * nodo como flotante.g(n)
	 */
	public double getCosteCamino() {
		return costeCamino.doubleValue();
	}
	/**
	 * 
	 * @return El valor del coste de la raiz al nodo,
	 * en número flotante.
	 */
	public double getCosteTotal() {
		return costeTotal.doubleValue();
	}
	/**
	 * 
	 * @return El valor del coste desde la raiz hasta el nodo,
	 * en Double.
	 */
	public Double getCosteTotalD() {
		return costeTotal;
	}
	/**
	 * 
	 * @return Una referencia al nodo padre.
	 */
	public Node getPadre() {
		return padre;
	}
	/**
	 *
	 * @return el nombre del operador por el que se ha llegado
	 * al nodo. 
	 */
	public String getOperador() {
		return operador;
	}
	/**
	 * 
	 * @return El estado que almacena este nodo.
	 */
	public Object getEstado() {
		return estado;
	}
	
	public String toString() {
		return estado.toString();
	}
	/*
	public int compare(Nodo a,Nodo b) {
		
	}*/
}
