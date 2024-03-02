// package br.edu.ufape.aedii.grafos;

// import java.nio.file.*;
// import java.util.List;
// import java.io.IOException;

// public class TesteGrafo {
//     public static void main(String[] args) throws IOException {
//         Path arquivo = Paths.get("D:/Programação/Java/Grafos-Igor/grafos/src/br/edu/ufape/aedii/grafos/teste.txt");

//         List<String> linhas = Files.readAllLines(arquivo);

//         String primeiraLinha = linhas.get(0);
//         String[] partes = primeiraLinha.split("/");

//         int qtdVertices = Integer.parseInt(partes[0]);
//         // Suponho que partes[1] contém a quantidade de arestas, mas você não está usando-a aqui.

//         Grafo g = new GrafoMatricial(qtdVertices);

//         for (int i = 1; i < linhas.size(); i++) {
//             String linha = linhas.get(i);

//             if (linha.length() == 1) {
//                 g.adicionarVertice(linha);
//             } else {
//                 String[] u = linha.split("/");
//                 g.adicionarAresta(u[0], u[1]);
//             }
//         }

//         // BuscaLargura b = new BuscaLargura(g);
//         // b.execute("D");

// 		BuscaProfundidade b = new BuscaProfundidade(g);
// 		b.inicializar();
// 		g.imprimirMapa();
// 		// List<List<Integer>> listaAdjacencias = g.listaAdjacente();
// 		// for (int i = 0; i < listaAdjacencias.size(); i++) {
// 		// 	System.out.print("Adjacências do vértice " + i + ": ");
// 		// 	List<Integer> adjacencias = listaAdjacencias.get(i);
			
// 		// 	// Exibir as adjacências
// 		// 	for (int j = 0; j < adjacencias.size(); j++) {
// 		// 		System.out.print(adjacencias.get(j));
// 		// 		if (j < adjacencias.size() - 1) {
// 		// 			System.out.print(", ");
// 		// 		}
// 		// 	}
// 		// 	System.out.println();
// 		// }
//        // b.imprimir();
		
//     }
// }
package br.edu.ufape.aedii.grafos;

public class TesteGrafo {
	public static void main(String[] args) {
		Grafo g = new GrafoAdjacencia(0);
		
		
		g.adicionarVertice("A");
		g.adicionarVertice("B");
		g.adicionarVertice("C");
		g.adicionarVertice("D");

		g.adicionarAresta("A", "C");
		g.adicionarAresta("A", "D");
		g.adicionarAresta("D", "B");

		
		// //BuscaLargura b = new BuscaLargura(g);
         BuscaProfundidade b = new BuscaProfundidade(g);
		 b.inicializar();
		
		 b.imprimir(); 
		

	}
}