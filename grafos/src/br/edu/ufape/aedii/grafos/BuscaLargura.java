package br.edu.ufape.aedii.grafos;

import java.util.List;
import java.util.PriorityQueue;

public class BuscaLargura {
	private Grafo g;
	private Cor[] cores;
	private int[] distancia;
	private int[] pai;
	
	public BuscaLargura(Grafo g) {
		this.g = g;
		this.cores = new Cor[g.getNumeroVertices()];
		this.distancia = new int[g.getNumeroVertices()];
		this.pai = new int[g.getNumeroVertices()];
	}
	
	public void inicializar() {
		for(int i=0; i < g.getNumeroVertices(); i++) {
			this.cores[i] = Cor.BRANCO;
			this.distancia[i] = -1;
			this.pai[i] = -1;
		}
	}
	
	public void execute(String s) {
		int indS = g.getIndiceVertice(s);
		inicializar();
		PriorityQueue<Integer> fila = new PriorityQueue<Integer>();
		this.cores[indS] = Cor.CINZA;
		this.distancia[indS] = 0;
		fila.add(indS);
		
		while(fila.size() > 0) {
			int v = fila.poll();
			List<Integer> adjacenciaV = g.listarAdjacencias(v);
			for(int u: adjacenciaV) {
				if(this.cores[u] == Cor.BRANCO) {
					this.pai[u] = v;
					this.distancia[u] = this.distancia[v] + 1;
					this.cores[u] = Cor.CINZA;
					fila.add(u);
				}
			}
			this.cores[v] = Cor.PRETO;
		}
	}
	
	public void imprimir() {
		System.out.println("Cores");
		for(Cor c : this.cores)
			System.out.print(c + " ");
		System.out.println("\nPai");
		for(int p : this.pai)
			System.out.print(p + " ");
		System.out.println("\nDistancia");
		for(int d : this.distancia)
			System.out.print(d + " ");
		System.out.println("");
	}

}
