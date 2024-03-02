package br.edu.ufape.aedii.grafos;

import java.util.List;

public interface Grafo {

	void adicionarVertice(String v);

	int getIndiceVertice(String v);

	void adicionarAresta(String v1, String v2);

	void adicionarAresta(int v1, int v2);

	void imprimirMapa();

	List<Integer> listarAdjacencias(int v);

	void imprimir();

	int getNumeroVertices();

	

}