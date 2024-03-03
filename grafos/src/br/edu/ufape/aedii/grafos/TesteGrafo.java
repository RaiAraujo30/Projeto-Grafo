package br.edu.ufape.aedii.grafos;

import java.nio.file.*;
import java.util.List;
import java.io.IOException;

public class TesteGrafo {
    public static void main(String[] args) {
        try {
            Path arquivo = Paths.get("D:/Programação/Java/Grafos-Igor/grafos/src/br/edu/ufape/aedii/grafos/Dados.txt");

            List<String> linhas = Files.readAllLines(arquivo);

            String primeiraLinha = linhas.get(0);
            String[] partes = primeiraLinha.split("/");

            // Pegando a quantidade de vértices
            int qtdVertices = Integer.parseInt(partes[0]);

            // Pode dar erro na quantidade de vértices, se der, trocar por 0
            GrafoAdjacencia g = new GrafoAdjacencia(0);

            for (int i = 1; i < linhas.size(); i++) {
                String linha = linhas.get(i);
                String[] divisoes = linha.split("/");
                int quantidade = divisoes.length;

                if (quantidade <= 1) {
                    g.adicionarVertice(linha);
                } else if (quantidade >= 3) {
                    int peso = 0; // Peso padrão se não for fornecido
                    try {
                        peso = Integer.parseInt(divisoes[2]);
                    } catch (NumberFormatException e) {
                        System.out.println("Erro ao ler o peso. Usando peso padrão (0).");
                    }

                    // Verificar se os índices são válidos antes de adicionar a aresta
                    int v1 = g.getIndiceVertice(divisoes[0]);
                    int v2 = g.getIndiceVertice(divisoes[1]);

                    if (v1 >= 0 && v2 >= 0) {
                        g.adicionarAresta(v1, v2, peso);
                    } else {
                        System.out.println("Índices inválidos para adicionar a aresta.");
                    }
                }
            }
            g.imprimir();
            int origem = g.getIndiceVertice("A");; // Vértice A como origem
            int destino = g.getIndiceVertice("CASA"); // Vértice F como destino

            Dijkstra.caminhoMinimo(g, origem, destino);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
        }
    }
}
