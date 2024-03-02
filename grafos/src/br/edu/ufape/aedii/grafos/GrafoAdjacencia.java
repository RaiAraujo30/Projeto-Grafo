package br.edu.ufape.aedii.grafos;

import java.util.ArrayList;
import java.util.List;

public class GrafoAdjacencia implements Grafo{
    
    private List<List<Integer>> listaAdjacencias;
    private List<String> mapa;
	private int numeroVertices;

    public GrafoAdjacencia(int numeroVertices){
        this.numeroVertices = numeroVertices;
		this.mapa = new ArrayList<String>(numeroVertices);
        this.listaAdjacencias = new ArrayList<>(numeroVertices);

        for (int i = 0; i < numeroVertices; i++) {
            this.mapa.add(""); 
            this.listaAdjacencias.add(new ArrayList<>());
        }

    }

    @Override
	public void adicionarVertice(String v) {
		this.mapa.add(v);
        this.listaAdjacencias.add(new ArrayList<>());
        this.numeroVertices++;
	}
	
	@Override
	public int getIndiceVertice(String v) {
		return this.mapa.indexOf(v);
	}
	
	@Override
	public void adicionarAresta(String v1, String v2) {
		this.adicionarAresta(getIndiceVertice(v1), getIndiceVertice(v2));
	}
	
	@Override
	public void adicionarAresta(int v1, int v2) {
		this.listaAdjacencias.get(v1).add(v2);
		this.listaAdjacencias.get(v2).add(v1);
	}
	
	@Override
	public void imprimirMapa() {
		for(String v: this.mapa)
			System.out.println(getIndiceVertice(v) + " - " + v);
	}

    @Override
    public List<Integer> listarAdjacencias(int v) {
        return this.listaAdjacencias.get(v);
    }

    

    @Override
    public void imprimir() {
        for (int i = 0; i < this.numeroVertices; i++) {
            System.out.print("Adjacências do vértice " + i + ": ");
            List<Integer> adjacentes = this.listaAdjacencias.get(i);

            for (int j = 0; j < adjacentes.size(); j++) {
                System.out.print(adjacentes.get(j));
                if (j < adjacentes.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
	

	@Override
	public int getNumeroVertices() {
		return numeroVertices;
	}

    public List<List<Integer>> getListaAdjacencias() {
        return listaAdjacencias;
    }

    public void setListaAdjacencias(List<List<Integer>> listaAdjacencias) {
        this.listaAdjacencias = listaAdjacencias;
    }

    public List<String> getMapa() {
        return mapa;
    }

    public void setMapa(List<String> mapa) {
        this.mapa = mapa;
    }

    public void setNumeroVertices(int numeroVertices) {
        this.numeroVertices = numeroVertices;
    }

	
	
}


