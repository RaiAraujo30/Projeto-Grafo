// // package br.edu.ufape.aedii.grafos;

// // import java.nio.file.*;
// // import java.util.List;
// // import java.io.IOException;

// // public class TesteGrafo {
// //     public static void main(String[] args) throws IOException {
// //         Path arquivo = Paths.get("D:/Programação/Java/Grafos-Igor/grafos/src/br/edu/ufape/aedii/grafos/teste.txt");

// //         List<String> linhas = Files.readAllLines(arquivo);

// //         String primeiraLinha = linhas.get(0);
// //         String[] partes = primeiraLinha.split("/");

// //         int qtdVertices = Integer.parseInt(partes[0]);
// //         // Suponho que partes[1] contém a quantidade de arestas, mas você não está usando-a aqui.

// //         Grafo g = new GrafoMatricial(qtdVertices);

// //         for (int i = 1; i < linhas.size(); i++) {
// //             String linha = linhas.get(i);

// //             if (linha.length() == 1) {
// //                 g.adicionarVertice(linha);
// //             } else {
// //                 String[] u = linha.split("/");
// //                 g.adicionarAresta(u[0], u[1]);
// //             }
// //         }

// //         // BuscaLargura b = new BuscaLargura(g);
// //         // b.execute("D");

// // 		BuscaProfundidade b = new BuscaProfundidade(g);
// // 		b.inicializar();
// // 		g.imprimirMapa();
// // 		// List<List<Integer>> listaAdjacencias = g.listaAdjacente();
// // 		// for (int i = 0; i < listaAdjacencias.size(); i++) {
// // 		// 	System.out.print("Adjacências do vértice " + i + ": ");
// // 		// 	List<Integer> adjacencias = listaAdjacencias.get(i);
			
// // 		// 	// Exibir as adjacências
// // 		// 	for (int j = 0; j < adjacencias.size(); j++) {
// // 		// 		System.out.print(adjacencias.get(j));
// // 		// 		if (j < adjacencias.size() - 1) {
// // 		// 			System.out.print(", ");
// // 		// 		}
// // 		// 	}
// // 		// 	System.out.println();
// // 		// }
// //        // b.imprimir();
		
// //     }
// // }
// package br.edu.ufape.aedii.grafos;

// public class TesteGrafo {
// 	public static void main(String[] args) {
//         // Exemplo de uso
//         GrafoAdjacencia grafo = new GrafoAdjacencia(6);

//         grafo.adicionarVertice("A");
//         grafo.adicionarVertice("B");
//         grafo.adicionarVertice("C");
//         grafo.adicionarVertice("D");
//         grafo.adicionarVertice("E");
//         grafo.adicionarVertice("F");

//         grafo.adicionarAresta("A", "B", 2);
//         grafo.adicionarAresta("A", "C", 4);
//         grafo.adicionarAresta("B", "C", 1);
//         grafo.adicionarAresta("B", "D", 7);
//         grafo.adicionarAresta("C", "E", 3);
//         grafo.adicionarAresta("D", "E", 1);
//         grafo.adicionarAresta("D", "F", 5);
//         grafo.adicionarAresta("E", "D", 2);
//         grafo.adicionarAresta("E", "F", 7);

//         int origem = 0; // Vértice A como origem
//         dijkstra(grafo, origem);
//     }
// }
