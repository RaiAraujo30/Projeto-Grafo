package br.edu.ufape.aedii.grafos;

import java.util.ArrayList;
import java.util.List;

public class GrafoAdjacencia implements Grafo{
    
    private List<List<ArestaPonderada>> listaAdjacencias;
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
    public void adicionarAresta(String v1, String v2, int peso) {
        this.adicionarAresta(getIndiceVertice(v1), getIndiceVertice(v2), peso);
    }
	
	@Override
	public void adicionarAresta(int v1, int v2, int peso) {
		this.listaAdjacencias.get(v1).add(new ArestaPonderada(v1, v2, peso));
		this.listaAdjacencias.get(v2).add(new ArestaPonderada(v2, v1, peso));
	}
	
	@Override
	public void imprimirMapa() {
		for(String v: this.mapa)
			System.out.println(getIndiceVertice(v) + " - " + v);
	}

    @Override
    public List<Integer> listarAdjacencias(int v) {
        List<Integer> adjacentes = new ArrayList<>();
        for (ArestaPonderada aresta : this.listaAdjacencias.get(v)) {
            adjacentes.add(aresta.getDestino());
        }
        return adjacentes;
    }

    

    @Override
    public void imprimir() {
        for (int i = 0; i < this.numeroVertices; i++) {
            System.out.print("Adjacências do vértice " + i + ": ");
            List<ArestaPonderada> arestas = this.listaAdjacencias.get(i);

            for (int j = 0; j < arestas.size(); j++) {
                ArestaPonderada aresta = arestas.get(j);
                System.out.print("(" + aresta.getDestino() + ", Peso: " + aresta.getPeso() + ")");
                if (j < arestas.size() - 1) {
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

    public List<List<ArestaPonderada>> getListaAdjacencias() {
        return listaAdjacencias;
    }

    public void setListaAdjacencias(List<List<ArestaPonderada>> listaAdjacencias) {
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


