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
 * Algoritmo de búsqueda local. No es completo ni óptimo
 * porque es de escalada y ningún algoritmo de escalada 
 * lo es. Puede localizar óptimos locales. Su
 * funcionamiento es el siguiente: para cada nodo se 
 * generan sus hijos, y seleccionamos el mejor de ellos.
 * Si es mejor que el padre, nos movemos a él y volvemos
 * a empezar. Si no es mejor que el padre, el padre es un
 * óptimo local y se ha terminado. No tiene por qué ser
 * solución.
 * @author alberto
 *
 */
public class EscaladaMaximaPendiente extends ExpandNode implements Busqueda {
	/**
	 * Si se ha encontrado solución o no.
	 */
	private boolean solucion;
	/**
	 * Último estado visitado.
	 */
	private Object ultimoEstado;
	
	/* Para cada nodo, busca entre sus sucesores si hay solución, o si mejora
	 * la estimación. Cuando entre los sucesores ninguno mejora la estimación,
	 * se devuelve como solución local el actual.
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
	 * Dada una lista de nodos, que se suponen hijos, evalúa cada uno en busca
	 * del mejor según el criterio definido en la función valorEscalada.
	 * @param l Lista de nodos a evaluar.
	 * @param p Problema.
	 * @return El nodo con la mejor evaluación.
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
	 * a quedarnos con el máximo valor, pero estamos
	 * usando la heurística, y cuanto menor sea, mejor es
	 * el nodo, lo hacemos negativo.
	 * @param p El problema, donde encontraremos la
	 * función heurística.
	 * @param n El nodo a evaluar.
	 * @return El valor de la evaluación.
	 */
	private double valorEscalada(Problem p,Node n) {
		return -1*p.getFunHeuristica().valorHeuristico(n.getEstado());
	}
	/**
	 * 
	 * @return True si se ha encontrado una solución válida.
	 * False en caso contrario.
	 */
	public boolean tieneSolucion() {
		return solucion;
	}
	/**
	 * 
	 * @return El estado último en el que hemos tenido un 
	 * maximo local.
	 */
	public Object ultimoEstado() {
		return ultimoEstado;
	}
	
}
