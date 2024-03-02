package br.edu.ufape.aedii.grafos;

public class ArestaPonderada {

    private int origem;
    private int destino;
    private int peso;

    public ArestaPonderada(int origem, int destino, int peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    public int getOrigem() {
        return origem;
    }

    public void setOrigem(int origem) {
        this.origem = origem;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "(" + origem + " -> " + destino + ", Peso: " + peso + ")";
    }
}
