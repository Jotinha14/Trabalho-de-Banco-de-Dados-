package Estruturas;

public class Vetor {
    private int[] elementos;
    private int tamanho;
    private int capacidade;
    
    public Vetor(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new int[capacidade];
        this.tamanho = 0;
    }
    
    // Inserção no final - O(1) amortizado
    public void inserir(int elemento) {
        if (tamanho == capacidade) {
            redimensionar();
        }
        elementos[tamanho] = elemento;
        tamanho++;
    }
    
    // Busca sequencial - O(n)
    public boolean buscaSequencial(int elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i] == elemento) {
                return true;
            }
        }
        return false;
    }
    
    // Busca binária - O(log n) - requer vetor ordenado
    public boolean buscaBinaria(int elemento) {
        int esquerda = 0;
        int direita = tamanho - 1;
        
        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;
            
            if (elementos[meio] == elemento) {
                return true;
            } else if (elementos[meio] < elemento) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        return false;
    }
    
    private void redimensionar() {
        capacidade *= 2;
        int[] novoArray = new int[capacidade];
        System.arraycopy(elementos, 0, novoArray, 0, tamanho);
        elementos = novoArray;
    }
    
    // Getters
    public int[] getElementos() { return elementos; }
    public int getTamanho() { return tamanho; }
    public void setElementos(int[] elementos) { this.elementos = elementos; }
}