package net.pierre.monrocq.graphs;

public class Vertex {
	
	private int label;//this is the id, maybe later consider adding a "real" label
	private int cost;
	
	public Vertex(int label) {
		this.label = label;
		this.cost = -1;
	}
	
	@Override //make 2 object with same label equal
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Vertex)) return false;
		if(obj == this) return true;
		return this.getLabel() == ((Vertex) obj).getLabel();
	}

	@Override //make 2 objects with same label have the same hashcode
	public int hashCode() {
		return label;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getCost() {
		return cost;
	}
	
	public int getLabel() {
		return label;
	}
	
	@Override
	public String toString() {
		return this.cost == -1 ? String.valueOf(label) : String.valueOf(label) + " cost: " + String.valueOf(cost);
	}
	
	
}
