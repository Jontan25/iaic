
package com.iaic.datastructures;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * This class represents a graph of elements of type E.
 * It's going to be used to represent the graph of planets
 * in the planets problem.
 * @author jose, mario
 *
 */
public class Graph<E> {
	/**
	 * Max number of nodes that will have the graph.
	 */
	private final int MAX_NODES=256;
	
	/**
	 * An ArrayList of linked lists represents the adjacents nodes.
	 * Inside of the node (GraphNode) is the element, of type E and
	 * the distance of this element to the 1 node.
	 */
	private ArrayList<LinkedList<AdjacencyNode<E>>> lists;
	/**
	 * A list of the elements.
	 */
	private ArrayList<E> elements;
	/**
	 * Number of elements on the graph.
	 */
	private int numElements;
	/**
	 * Max number of elements. 
	 */
	private int maxElements;
	
	public Graph() {
		lists=null;numElements=0;elements=null;maxElements=MAX_NODES;
	}
	/**
	 * This constructor initializes the ArrayList for i elements. It doen's
	 * have any linked list.
	 * @param i
	 */
	public Graph(int i) {
		lists= new ArrayList<LinkedList<AdjacencyNode<E>>>(i);
		elements=new ArrayList<E>(i);
		numElements=0;maxElements=numElements;
	}
	/**
	 * This method adds a new element to the graph. First, it checks if the
	 * graph has capacity for one more element and if it's not in the graph.
	 * Then, it adds to the element list and creates a new linked list empty.
	 * 
	 * @param elem If it has been added, False if there was no space or it 
	 * exists in the graph.
	 * 

	 */
	public boolean addElement(E elem) {
		if ((numElements==maxElements) || (elements.contains(elem))) 
			return false;
		elements.add(elem);
		lists.add(new LinkedList<AdjacencyNode<E>>());
		numElements++;
		return true;		
	}
	/**
	 * @param v1 Vertex 1.
	 * @param v2 Vertex 2.
	 * @param d The distance, the length of the edge.
	 * @return True If the edge can be added.
	 */
	public boolean addVertex(E v1, E v2, int d) {
		if (!elements.contains(v1) || !elements.contains(v2))
			return false;
		//we add the edge v1,v2
		AdjacencyNode<E> first=new AdjacencyNode<E>(v2,d);
		int index=elements.indexOf(v1);
		lists.get(index).add(first);
		//then we add the edge v2,v1
		AdjacencyNode<E> second=new AdjacencyNode<E>(v1,d);
		index=elements.indexOf(v2);
		lists.get(index).add(second);
		return true;
	}
	/**
	 * Returns the list of the adjacent elements to v
	 * @param v The vertex of the adjacents.
	 * @return The list.
	 */
	public LinkedList<AdjacencyNode<E>> adjacents(E v) {
		int index=elements.indexOf(v);
		if (index==-1) return null;
		if (lists.get(index).isEmpty()) return null;
		return lists.get(index);
	}
	
}
