package br.edu.ufape.aedii.grafos;

import java.util.*;

public class Dijkstra {

    // Função para encontrar o caminho mínimo entre a origem e o destino em um grafo ponderado
    public static List<Integer> caminhoMinimo(GrafoAdjacencia grafo, int origem, int destino) {
        int numeroVertices = grafo.getNumeroVertices();
        int[] distancia = new int[numeroVertices]; // Array para armazenar as distâncias mínimas
        boolean[] visitado = new boolean[numeroVertices]; // Array para rastrear os vértices visitados
        int[] pai = new int[numeroVertices]; // Array para rastrear o pai de cada vértice no caminho mínimo

        // Inicialização
        Arrays.fill(distancia, Integer.MAX_VALUE);
        distancia[origem] = 0;

        // Fila de prioridade para processar os vértices com menor distância primeiro
        PriorityQueue<VerticeDistancia> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(VerticeDistancia::getDistancia));
        filaPrioridade.add(new VerticeDistancia(origem, 0));

        while (!filaPrioridade.isEmpty()) {
            int u = filaPrioridade.poll().getVertice();

            if (!visitado[u]) {
                visitado[u] = true;

                // Iterar sobre as arestas do vértice atual
                for (ArestaPonderada aresta : grafo.getListaAdjacencias().get(u)) {
                    int v = aresta.getDestino();
                    int pesoUV = aresta.getPeso();

                    // Relaxamento da aresta
                    if (!visitado[v] && distancia[u] != Integer.MAX_VALUE && distancia[u] + pesoUV < distancia[v]) {
                        distancia[v] = distancia[u] + pesoUV;
                        pai[v] = u;  // Atualiza o pai para reconstruir o caminho mínimo
                        filaPrioridade.add(new VerticeDistancia(v, distancia[v]));
                    }
                }
            }
        }

        // Reconstruir o caminho mínimo
        List<Integer> caminho = new ArrayList<>();
        int atual = destino;
        while (atual != origem) {
            caminho.add(atual);
            atual = pai[atual];
        }
        caminho.add(origem);
        Collections.reverse(caminho);

        // Imprimir vértices no caminho mínimo
        System.out.println("Caminho mínimo de " + grafo.getMapa().get(origem) + " para " + grafo.getMapa().get(destino) + ":");
        for (int vertice : caminho) {
            System.out.print(grafo.getMapa().get(vertice) + " ");
        }
        System.out.println("\nDistância mínima: " + distancia[destino] + " metros");

        return caminho;
    }
}
