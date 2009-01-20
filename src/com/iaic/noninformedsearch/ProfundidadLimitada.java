/**
 * 
 */
package com.iaic.noninformedsearch;

import java.util.Vector;
import problema.Nodo;
import problema.Problema;
import busqueda.Busqueda;
import estructurasDeDatos.ExpandeNodo;

/**
 * Esta b�squeda es un poco distinta de las dem�s, por eso
 * hereda ExpandeNodo, para poder hacer la b�squeda aqu�
 * directamente.
 * Es como una b�squeda en anchura, pero en vez de ser de
 * 1 nivel, de varios niveles. Primero se hace una
 * b�squeda en profundidad hasta que llegamos al l�mite de
 * profundidad. Entonces, se hace vuelta atr�s y se va
 * repitiendo con los hermanos que nos hemos ido dejando.
 * Como no tenemos una estructura de abiertos adecuada
 * para controlar estos dos factores (habr�a que modificar
 * incluso la estructura del Nodo para guardar toda la
 * informaci�n necesaria) lo implementaremos con
 * recursividad.
 * @author alberto
 *
 */
public class ProfundidadLimitada extends ExpandeNodo implements Busqueda {
	/**
	 * L�mite de profundidad que se podr� alcanzar en la b�squeda.
	 */
	private int limite;
	/**
	 * Un supuesto operador que en realidad no lo es.
	 * Se usar� para caracterizar un tipo especial de 
	 * resultado que obtendremos si llegamos al l�mite 
	 * de profundidad en la b�squeda.
	 * NO PUEDE HABER NING�N OPERADOR QUE SE LLAME IGUAL.
	 */
	private final String FALSO="#####";
	
	public ProfundidadLimitada(int l) {
		limite=l;
	}
	/* (non-Javadoc)
	 * @see busqueda.Busqueda#busqueda(problema.Problema)
	 */
	public Vector<String> busqueda(Problema p) {
		Vector<String> s=busquedalimitada(new Nodo(p.getEstadoInicial()),p);
		if (esFalso(s)) return new Vector<String>();
		return s;
	}
	/**
	 * Funci�n recursiva que eval�a si un nodo es soluci�n
	 * o est� en el l�mite, y despliega sus hijos en caso
	 * contrario. LLeva todo el peso de esta b�squeda.
	 * @param n Nodo candidato.
	 * @param p Problema dado.
	 * @return Lista de operadores aplicados hasta la 
	 * soluci�n, o una soluci�n caracter�stica para saber
	 * que se ha llegado al fondo sin encontrar soluci�n.
	 */
	private Vector<String> busquedalimitada(Nodo n, Problema p) {
		boolean llegadoallimite=false;
		//usaremos un flag para saber si por debajo est�
		//el l�mite
		if (p.esEstadoObjetivo(n.getEstado())) {
			return n.caminoOperadores();
		}
		//evaluamos el nodo que nos entra por si es
		//soluci�n, en cuyo caso hemos terminado
		else if (n.getProfundidad()==limite) {
			return resultadoFalso();
		}
		//si no lo es, miramos si estamos en el l�mite de
		//profundidad, porque entonces no podemos
		//expandirlo, y devolvemos un resultado
		//caracter�stico que nos marcar� que hemos llegado
		//al l�mite
		else { //si no ocurre nada de esto, expandimos
			Vector<Nodo> hijos = expandirNodo(n,p);
			//expandimos el nodo, y recorremos sus hijos
			int numHijos=hijos.size();
			for (int i=0;i<numHijos;i++) {
				Nodo act=hijos.get(i);
				Vector<String> fin=busquedalimitada(act,p);
				//para cada hijo, hacemos una llamada
				//recursiva, porque hasta que lleguemos al
				//l�mite de profundidad, es una b�squeda
				//en profundidad.
				//esta llamada nos puede devolver, bien 
				//un resultado correcto, el resultado que 
				//nos caracteriza que hemos llegado al
				//l�mite sin encontrar nada, o un vector
				//vac�o
				if (esFalso(fin))
					llegadoallimite=true;
				//si hemos llegado al l�mite, lo marcamos
				//para que cuando hayamos terminado de 
				//explorar los hermanos, podamos devolver
				//el resultado falso.
				else if (encontrado(fin))
					return fin;
				//en cambio, si es un resultado v�lido,
				//lo propagamos hacia arriba porque hemos
				//encontrado una soluci�n.
			}
			//por aqu� ya hemos explorado todos los hijos
			//del nodo. Aqu� no se puede llegar si se 
			//hab�a encontrado una soluci�n.
			if (llegadoallimite)
				return resultadoFalso();
			//si hab�amos encontrado el l�mite de
			//profundidad, seguimos propagando esto hacia
			//arriba.
			else
				return new Vector<String>();
			//si no, la �nica opci�n que nos queda es que
			//nos hayamos explorado todos los nodos
			//posibles y no hayamos encontrado soluci�n.
			//esto creo que no deber�a pasar, porque
			//si llegas al fondo del todo, coges el then,
			//pero por si acaso.
		}
	}
	/**
	 * Funci�n para crear un vector falso caracter�stico
	 * que nos servir� en la vuelta atr�s para saber
	 * que se ha llegado al l�mite de profundidad y no se
	 * ha encontrado soluci�n.
	 * @return Vector falso. tiene el elemento FALSO en el
	 * primer y �nico elemento.
	 * 
	 */
	private Vector<String> resultadoFalso() {
		Vector<String> a=new Vector<String>();
		a.add(FALSO);
		return a;
	}
	/**
	 * Eval�a si un supuesto resultado es en realidad
	 * el resultado falso que nos marca que se ha llegado
	 * al l�mite de profundidad.
	 * @param s El candidato a resultado bueno.
	 * @return True si es el resultado falso y False
	 * en caso contrario.
	 */
	private boolean esFalso(Vector<String> s) {
		return s.size()==1 && s.get(0).equals(FALSO);
	}
	/**
	 * Eval�a si un supuesto resultado puede ser v�lido
	 * o no seg�n tenga operadores o est� vac�o. Ojo,
	 * un true de esta funci�n no garantiza que sea una 
	 * soluci�n v�lida, ya que podr�a ser el resultado
	 * falso.
	 * @param s El candidato a evaluar.
	 * @return True si tiene operadores y False en caso
	 * contrario.
	 */
	private boolean encontrado(Vector<String> s) {
		return s.size()>0;
	}
}
