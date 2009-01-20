/**
 * 
 */
package com.iaic.informedsearch;
import java.util.Vector;

import com.iaic.problem.Node;
import com.iaic.problem.Problem;

import busqueda.Busqueda;
import estructurasDeDatos.ExpandeNodo;

/**
 * Algoritmo de b�squeda local. No es completo ni �ptimo
 * porque es de escalada y ning�n algoritmo de escalada 
 * lo es. Puede localizar �ptimos locales. Su
 * funcionamiento es el siguiente: para cada nodo se 
 * generan sus hijos, y seleccionamos el mejor de ellos.
 * Si es mejor que el padre, nos movemos a �l y volvemos
 * a empezar. Si no es mejor que el padre, el padre es un
 * �ptimo local y se ha terminado. No tiene por qu� ser
 * soluci�n.
 * @author alberto
 *
 */
public class EscaladaMaximaPendiente extends ExpandNode implements Busqueda {
	/**
	 * Si se ha encontrado soluci�n o no.
	 */
	private boolean solucion;
	/**
	 * �ltimo estado visitado.
	 */
	private Object ultimoEstado;
	
	/* Para cada nodo, busca entre sus sucesores si hay soluci�n, o si mejora
	 * la estimaci�n. Cuando entre los sucesores ninguno mejora la estimaci�n,
	 * se devuelve como soluci�n local el actual.
	 * (non-Javadoc)
	 * @see busqueda.Busqueda#busqueda(problema.Problema)
	 */
	public Vector<String> busqueda(Problem p) {
		ultimoEstado=null;
		Node actual=new Node(p.getEstadoInicial()),
		     sucesor=null;
		
		while (true) {
			sucesor=hijoDeMaxValor(expandirNodo(actual,p),p);
			if (sucesor==null || valorEscalada(p,sucesor)<valorEscalada(p,actual)) {
				if (p.esEstadoObjetivo(actual.getEstado())) {
					solucion=true;
				}
				ultimoEstado=actual.getEstado();	
				return actual.caminoOperadores();
			}
			actual=sucesor;
		}
	}
	
	/**
	 * Dada una lista de nodos, que se suponen hijos, eval�a cada uno en busca
	 * del mejor seg�n el criterio definido en la funci�n valorEscalada.
	 * @param l Lista de nodos a evaluar.
	 * @param p Problema.
	 * @return El nodo con la mejor evaluaci�n.
	 */
	private Node hijoDeMaxValor(Vector<Node> l,Problem p) {
		double maximo=Double.NEGATIVE_INFINITY;
		Node nodoMaximo=null;
		int total=l.size();
		for (int i=0;i<total;i++) {
			Node a=l.get(i);
			double valorEval=valorEscalada(p,a);
			if (valorEval>maximo) {
				maximo=valorEval;
				nodoMaximo=a;
			}
		}
		return nodoMaximo;
	}
	/**
	 * El valor en el que nos basaremos para elegir si
	 * el nodo es mejor que el que tenemos. Como vamos
	 * a quedarnos con el m�ximo valor, pero estamos
	 * usando la heur�stica, y cuanto menor sea, mejor es
	 * el nodo, lo hacemos negativo.
	 * @param p El problema, donde encontraremos la
	 * funci�n heur�stica.
	 * @param n El nodo a evaluar.
	 * @return El valor de la evaluaci�n.
	 */
	private double valorEscalada(Problem p,Node n) {
		return -1*p.getFunHeuristica().valorHeuristico(n.getEstado());
	}
	/**
	 * 
	 * @return True si se ha encontrado una soluci�n v�lida.
	 * False en caso contrario.
	 */
	public boolean tieneSolucion() {
		return solucion;
	}
	/**
	 * 
	 * @return El estado �ltimo en el que hemos tenido un 
	 * maximo local.
	 */
	public Object ultimoEstado() {
		return ultimoEstado;
	}
	
}
