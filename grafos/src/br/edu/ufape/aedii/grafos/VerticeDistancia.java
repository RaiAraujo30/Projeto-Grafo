package br.edu.ufape.aedii.grafos;

public class VerticeDistancia {
    
    private int vertice;
    private int distancia;

    public VerticeDistancia(int vertice, int distancia) {
        this.vertice = vertice;
        this.distancia = distancia;
    }

    public int getVertice() {
        return vertice;
    }

    public int getDistancia() {
        return distancia;
    }
}
