package br.edu.ufape.aedii.grafos;

import java.util.*;

public class Dijkstra {

    public static List<Integer> caminhoMinimo(GrafoAdjacencia grafo, int origem, int destino) {
        int numeroVertices = grafo.getNumeroVertices();
        int[] distancia = new int[numeroVertices];
        boolean[] visitado = new boolean[numeroVertices];
        int[] pai = new int[numeroVertices];

        // Inicialização
        Arrays.fill(distancia, Integer.MAX_VALUE);
        distancia[origem] = 0;

        PriorityQueue<VerticeDistancia> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(VerticeDistancia::getDistancia));
        filaPrioridade.add(new VerticeDistancia(origem, 0));

        while (!filaPrioridade.isEmpty()) {
            int u = filaPrioridade.poll().getVertice();

            if (!visitado[u]) {
                visitado[u] = true;

                for (ArestaPonderada aresta : grafo.getListaAdjacencias().get(u)) {
                    int v = aresta.getDestino();
                    int pesoUV = aresta.getPeso();

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
        System.out.println("\nDistância mínima: " + distancia[destino]);

        return caminho;
    }

    public static void main(String[] args) {
        // Exemplo de uso
        GrafoAdjacencia grafo = new GrafoAdjacencia(0);

        grafo.adicionarVertice("A");
        grafo.adicionarVertice("B");
        grafo.adicionarVertice("C");
        grafo.adicionarVertice("D");
        grafo.adicionarVertice("E");
        grafo.adicionarVertice("F");

        grafo.adicionarAresta("A", "B", 2);
        grafo.adicionarAresta("A", "C", 4);
        grafo.adicionarAresta("B", "C", 1);
        grafo.adicionarAresta("B", "D", 7);
        grafo.adicionarAresta("C", "E", 3);
        grafo.adicionarAresta("D", "E", 1);
        grafo.adicionarAresta("D", "F", 5);
        grafo.adicionarAresta("E", "F", 7);

        int origem = 0; // Vértice A como origem
        int destino = 5; // Vértice F como destino

        caminhoMinimo(grafo, origem, destino);
    }
}
