package com.iaic.noninformedsearch;

import java.util.Comparator;

import com.iaic.problem.Node;

/**
 * Comparator that is based in the cost function. It has in count
 * the total coast to reach from the root to the node.
 * @author alberto
 */
public class ComparatorGn implements Comparator<Node> {
	
	public int compare(Node one,Node two) {
			return one.getTotalCostD().compareTo(two.getTotalCostD());
	}
}
