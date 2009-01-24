package com.iaic.search.nonInformed;

import com.iaic.search.Search;
import com.iaic.problem.Problem;
import java.util.Vector;
import com.iaic.problem.Node;
import com.iaic.datastructures.ExpandNode;

public class LimitedDepth extends ExpandNode implements Search {
	
	private int limit;
	
	private final String FALSO="#####";
	
	public LimitedDepth (int l) {
		limit=l;
	}

	public Vector<String> search(Problem p) {
		Vector<String> s=limitedSearch(new Node(p.getInitialState()),p);
		if (isFalse(s)) return new Vector<String>();
		return s;
	}
	
	private Vector<String> limitedSearch(Node n, Problem p) {
		boolean llegadoallimite=false;
		
		if (p.isAimState(n.getState())) {
			return n.wayOperators();
		}
		
		else if (n.getDepth() == limit) {
			return resultadoFalso();
		}

		else { //si no ocurre nada de esto, expandimos
			Vector<Node> children = expandNode(n,p);
			
			int numChildren = children.size();
			for (int i=0;i<numChildren;i++) {
				Node act=children.get(i);
				Vector<String> fin=limitedSearch	(act,p);
				
				if (isFalse(fin))
					llegadoallimite=true;
				//si hemos llegado al l�mite, lo marcamos
				//para que cuando hayamos terminado de 
				//explorar los hermanos, podamos devolver
				//el resultado falso.
				else if (found(fin))
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
			else
				return new Vector<String>();
			
		}
	}

	
	private Vector<String> resultadoFalso() {
		Vector<String> a=new Vector<String>();
		a.add(FALSO);
		return a;
	}
	
	private boolean isFalse(Vector<String> s) {
		return s.size()==1 && s.get(0).equals(FALSO);
	}
	
	private boolean found(Vector<String> s) {
		return s.size()>0;
	}
}
