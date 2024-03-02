package br.edu.ufape.aedii.grafos;

import java.util.List;


public class BuscaProfundidade {
    
    private Grafo g;
	private Cor[] cores;
	private int[] pai;
    private int[] d;
    private int[] f;
    private int tempo;


    public BuscaProfundidade(Grafo g){
        this.g = g;
        this.cores = new Cor[g.getNumeroVertices()];
		this.pai = new int[g.getNumeroVertices()];
        this.d =  new int[g.getNumeroVertices()];
        this.f =  new int[g.getNumeroVertices()];
    }

    public void inicializar() {
        for(int i = 0; i < g.getNumeroVertices(); i++){
            this.cores[i] = Cor.BRANCO;
            this.pai[i] = -1;
        }
        tempo = 0;
        for(int i = 0; i< g.getNumeroVertices(); i++){
            if(this.cores[i] == Cor.BRANCO){
                execute(i);
            }
        }
    }

    public void execute(int u){
        tempo++;
        this.d[u] = tempo;
        this.cores[u] = Cor.CINZA;
        List<Integer> adjacenciaV = g.listarAdjacencias(u);
        for(int v: adjacenciaV) {
            if(this.cores[v] == Cor.BRANCO) {
                this.pai[v] = u;
                execute(v);
            }
        }
        this.cores[u] = Cor.PRETO;
        tempo++;
        this.f[u] = tempo;
    }

    public void imprimir() {
        System.out.println("Cores:");
        for (Cor cor : this.cores) {
            System.out.print(cor + " ");
        }

        System.out.println("\nPai:");
        for (int p : this.pai) {
            System.out.print(p + " ");
        }

        System.out.println("\nTempo de Descoberta (d):");
        for (int tempoD : this.d) {
            System.out.print(tempoD + " ");
        }

        System.out.println("\nTempo de Finalização (f):");
        for (int tempoF : this.f) {
            System.out.print(tempoF + " ");
        }
        System.out.println();
    }

}

// DFS(G)
//     for cada vértice u ∈ V[G]
//         u.cor = BRANCO;
//         u.pai = -1;
//     tempo = 0;
//     for cada vértice ∈ V[G]
//         if u.cor == BRANCO  
//             DFS-Visit(G,u)

// DFS-Visit(G,u)
//     tempo++;
//     u.d = tempo;
//     u.cor = CINZA;
//     for cada v ∈ G.adj[u]
//         if v.cor == BRANCO
//             v.pai = u;
//             DFS-Visit(G,v)
//     u.cor = PRETO;
//     tempo++;
//     u.f = tempo;