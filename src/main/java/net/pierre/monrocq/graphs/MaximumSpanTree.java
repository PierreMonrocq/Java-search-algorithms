package net.pierre.monrocq.graphs;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class MaximumSpanTree {

	private ArrayList<Node> n1;
	private ArrayList<Node> n2;
	
	public MaximumSpanTree(Map<Node, Node> parents) {
		n1 = new ArrayList<Node>();
		n2 = new ArrayList<Node>();
		for (Map.Entry<Node, Node> entry : parents.entrySet()) {
            Node k = entry.getKey();
            Node v = entry.getValue();
            n1.add(k);
            n2.add(v);
        }
	}
	
}
