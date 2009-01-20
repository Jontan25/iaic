
package com.iaic.datastructures;

/**
 * This class is for the linked lists that will represent the adjacent nodes
 * of the Graph class.
 * @author jose, mario
 *
 */
public class AdjacencyNode<T> {
	/**
	 * The element of the graph
	 */
	private T element;
	/**
	 * The distance
	 */
	private int distance;
	/**
	 * Constructor by default, null node.
	 */
	public AdjacencyNode() {
		element=null;distance=0;
	}
	/**
	 * Initializes the node with an element and a 0 distance.
	 * @param elem The element.
	 */
	public AdjacencyNode(T elem) {
		element=elem;distance=0;
	}
	/**
	 * Initializes the node with an element and a default distance.
	 * @param elem Element to initialize node.
	 * @param d Distance of the element.
	 */
	public AdjacencyNode(T elem, int d) {
		element=elem;distance=d;
	}
	/**
	 * Returns a reference to the contained element.
	 * @return Element of node.
	 */
	public T getElement() {
		return element;
	}
	/**
	 * Puts a new element on the node.
	 * @param e New element.
	 */
	public void setElement(T e) {
		element=e;
	}
	/**
	 * Returns the distance of the element, contained in the node.
	 * @return Distance of the element.
	 */
	public int getDistance() {
		return distance;
	}
	/**
	 * Changes the distance in the node.
	 * @param d New distance.
	 */
	public void setDistance(int d) {
		distance=d;
	}
}
