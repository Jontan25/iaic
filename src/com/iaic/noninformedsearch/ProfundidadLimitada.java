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
 * Esta búsqueda es un poco distinta de las demás, por eso
 * hereda ExpandeNodo, para poder hacer la búsqueda aquí
 * directamente.
 * Es como una búsqueda en anchura, pero en vez de ser de
 * 1 nivel, de varios niveles. Primero se hace una
 * búsqueda en profundidad hasta que llegamos al límite de
 * profundidad. Entonces, se hace vuelta atrás y se va
 * repitiendo con los hermanos que nos hemos ido dejando.
 * Como no tenemos una estructura de abiertos adecuada
 * para controlar estos dos factores (habría que modificar
 * incluso la estructura del Nodo para guardar toda la
 * información necesaria) lo implementaremos con
 * recursividad.
 * @author alberto
 *
 */
public class ProfundidadLimitada extends ExpandeNodo implements Busqueda {
	/**
	 * Límite de profundidad que se podrá alcanzar en la búsqueda.
	 */
	private int limite;
	/**
	 * Un supuesto operador que en realidad no lo es.
	 * Se usará para caracterizar un tipo especial de 
	 * resultado que obtendremos si llegamos al límite 
	 * de profundidad en la búsqueda.
	 * NO PUEDE HABER NINGÚN OPERADOR QUE SE LLAME IGUAL.
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
	 * Función recursiva que evalúa si un nodo es solución
	 * o está en el límite, y despliega sus hijos en caso
	 * contrario. LLeva todo el peso de esta búsqueda.
	 * @param n Nodo candidato.
	 * @param p Problema dado.
	 * @return Lista de operadores aplicados hasta la 
	 * solución, o una solución característica para saber
	 * que se ha llegado al fondo sin encontrar solución.
	 */
	private Vector<String> busquedalimitada(Nodo n, Problema p) {
		boolean llegadoallimite=false;
		//usaremos un flag para saber si por debajo está
		//el límite
		if (p.esEstadoObjetivo(n.getEstado())) {
			return n.caminoOperadores();
		}
		//evaluamos el nodo que nos entra por si es
		//solución, en cuyo caso hemos terminado
		else if (n.getProfundidad()==limite) {
			return resultadoFalso();
		}
		//si no lo es, miramos si estamos en el límite de
		//profundidad, porque entonces no podemos
		//expandirlo, y devolvemos un resultado
		//característico que nos marcará que hemos llegado
		//al límite
		else { //si no ocurre nada de esto, expandimos
			Vector<Nodo> hijos = expandirNodo(n,p);
			//expandimos el nodo, y recorremos sus hijos
			int numHijos=hijos.size();
			for (int i=0;i<numHijos;i++) {
				Nodo act=hijos.get(i);
				Vector<String> fin=busquedalimitada(act,p);
				//para cada hijo, hacemos una llamada
				//recursiva, porque hasta que lleguemos al
				//límite de profundidad, es una búsqueda
				//en profundidad.
				//esta llamada nos puede devolver, bien 
				//un resultado correcto, el resultado que 
				//nos caracteriza que hemos llegado al
				//límite sin encontrar nada, o un vector
				//vacío
				if (esFalso(fin))
					llegadoallimite=true;
				//si hemos llegado al límite, lo marcamos
				//para que cuando hayamos terminado de 
				//explorar los hermanos, podamos devolver
				//el resultado falso.
				else if (encontrado(fin))
					return fin;
				//en cambio, si es un resultado válido,
				//lo propagamos hacia arriba porque hemos
				//encontrado una solución.
			}
			//por aquí ya hemos explorado todos los hijos
			//del nodo. Aquí no se puede llegar si se 
			//había encontrado una solución.
			if (llegadoallimite)
				return resultadoFalso();
			//si habíamos encontrado el límite de
			//profundidad, seguimos propagando esto hacia
			//arriba.
			else
				return new Vector<String>();
			//si no, la única opción que nos queda es que
			//nos hayamos explorado todos los nodos
			//posibles y no hayamos encontrado solución.
			//esto creo que no debería pasar, porque
			//si llegas al fondo del todo, coges el then,
			//pero por si acaso.
		}
	}
	/**
	 * Función para crear un vector falso característico
	 * que nos servirá en la vuelta atrás para saber
	 * que se ha llegado al límite de profundidad y no se
	 * ha encontrado solución.
	 * @return Vector falso. tiene el elemento FALSO en el
	 * primer y único elemento.
	 * 
	 */
	private Vector<String> resultadoFalso() {
		Vector<String> a=new Vector<String>();
		a.add(FALSO);
		return a;
	}
	/**
	 * Evalúa si un supuesto resultado es en realidad
	 * el resultado falso que nos marca que se ha llegado
	 * al límite de profundidad.
	 * @param s El candidato a resultado bueno.
	 * @return True si es el resultado falso y False
	 * en caso contrario.
	 */
	private boolean esFalso(Vector<String> s) {
		return s.size()==1 && s.get(0).equals(FALSO);
	}
	/**
	 * Evalúa si un supuesto resultado puede ser válido
	 * o no según tenga operadores o esté vacío. Ojo,
	 * un true de esta función no garantiza que sea una 
	 * solución válida, ya que podría ser el resultado
	 * falso.
	 * @param s El candidato a evaluar.
	 * @return True si tiene operadores y False en caso
	 * contrario.
	 */
	private boolean encontrado(Vector<String> s) {
		return s.size()>0;
	}
}
