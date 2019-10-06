package net.pierre.monrocq.data;

public enum RoumanieE{//Modelisation des villes de la Roumanie
	ARAD(0), ZERIND(1), ORADEA(2), SIBIU(3), TIMISOARA(4), LUGOJ(5), MEHADIA(6),
			DROBETA(7), CRAIOVA(8), PITESTI(9), RIMNICU_VILCEA(10), FAGARAS(11), BUCHAREST(12),
			GIURGIU(13), URZICENI(14), EFORIE(15), VASLUI(16), IASI(17), NEAMT(18), HIRSOVA(19);
	private final int id;
	//TEST
	private RoumanieE(int id) {
		this.id = id;
	}
	
}