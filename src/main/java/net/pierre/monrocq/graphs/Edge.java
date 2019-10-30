package net.pierre.monrocq.graphs;

import java.io.Serializable;

public class Edge implements Serializable {

	private static final long serialVersionUID = 1L;
	private String src;
	private String dest;
	private int cost;
	
	public Edge(String source, String dest, int cost) {
		this.setSrc(source);
		this.setDest(dest);
		this.cost = cost;
	}
	
	public <E extends Enum<E>> Edge(E source, E dest, int cost) {
		this.setSrc(source.name());
		this.setDest(dest.name());
		this.cost = cost;
	}

	public int getCost() {
		return cost;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}
	
	@Override
	public String toString() {
		return src + " -> " + dest + " :" + cost;
	}
}
