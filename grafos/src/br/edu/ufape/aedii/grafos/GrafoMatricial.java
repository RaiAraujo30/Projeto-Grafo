// package br.edu.ufape.aedii.grafos;

// import java.util.ArrayList;
// import java.util.List;

// public class GrafoMatricial implements Grafo {
// 	private boolean[][] matriz;
// 	private List<String> mapa;
// 	private int numeroVertices;
	
// 	public GrafoMatricial(int numeroVertices) {
// 		this.numeroVertices = numeroVertices;
// 		this.mapa = new ArrayList<String>(numeroVertices);
// 		this.matriz = new boolean[numeroVertices][numeroVertices];
// 		for(int i=0; i<numeroVertices; i++) {
// 			this.matriz[i][i] = true;
// 		}
// 	}
	
// 	@Override
// 	public void adicionarVertice(String v) {
// 		this.mapa.add(v);
// 	}
	
// 	@Override
// 	public int getIndiceVertice(String v) {
// 		return this.mapa.indexOf(v);
// 	}
	
// 	@Override
// 	public void adicionarAresta(String v1, String v2) {
// 		this.adicionarAresta(getIndiceVertice(v1), getIndiceVertice(v2));
// 	}
	
// 	@Override
// 	public void adicionarAresta(int v1, int v2) {
// 		this.matriz[v1][v2] = true;
// 		this.matriz[v2][v1] = true;
// 	}
	
// 	@Override
// 	public void imprimirMapa() {
// 		for(String v: this.mapa)
// 			System.out.println(getIndiceVertice(v) + " - " + v);
// 	}
	
// 	@Override
// 	public List<Integer> listarAdjacencias(int v) {
// 		List<Integer> adjacentes = new ArrayList<Integer>(this.numeroVertices);
// 		for(int j=0; j<this.numeroVertices;j++)
// 			if(this.matriz[v][j] && v!=j) {
// 				adjacentes.add(j);
// 			}
// 		return adjacentes;
// 	}

// 	// @Override
// 	// public List<List<Integer>> listaAdjacente() {
// 	// 	List<List<Integer>> listaAdjacencias = new ArrayList<>(this.numeroVertices);

// 	// 	for (int i = 0; i < this.numeroVertices; i++) {
// 	// 		List<Integer> adjacentesDoVertice = new ArrayList<>();
// 	// 		for (int j = 0; j < this.numeroVertices; j++) {
// 	// 			if (this.matriz[i][j] && i != j) {
// 	// 				adjacentesDoVertice.add(j);
// 	// 			}
// 	// 		}
// 	// 		listaAdjacencias.add(adjacentesDoVertice);
// 	// 	}

// 	// 	return listaAdjacencias;
// 	// }

	

// 	@Override
// 	public void imprimir() {
// 		for(int i=0; i < this.numeroVertices; i++ ) {
// 			for(int j=0; j < this.numeroVertices; j++) {
// 				System.out.print(this.matriz[i][j] + "\t");
// 			}
// 			System.out.println("");
// 		}
// 		System.out.println("");
// 	}
	
	
// 	public boolean[][] getMatriz() {
// 		return matriz;
// 	}

// 	public void setMatriz(boolean[][] matriz) {
// 		this.matriz = matriz;
// 	}

// 	public List<String> getMapa() {
// 		return mapa;
// 	}

// 	public void setMapa(List<String> mapa) {
// 		this.mapa = mapa;
// 	}

// 	@Override
// 	public int getNumeroVertices() {
// 		return numeroVertices;
// 	}

// 	public void setNumeroVertices(int numeroVertices) {
// 		this.numeroVertices = numeroVertices;
// 	}
	
	
// }
