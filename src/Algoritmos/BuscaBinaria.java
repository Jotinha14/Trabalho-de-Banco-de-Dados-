package Algoritmos;

public class BuscaBinaria {
    private long operacoes;
    
    public boolean buscar(int[] arr, int elemento) {
        operacoes = 0;
        int esquerda = 0;
        int direita = arr.length - 1;
        
        while (esquerda <= direita) {
            operacoes++;
            int meio = esquerda + (direita - esquerda) / 2;
            
            if (arr[meio] == elemento) {
                return true;
            } else if (arr[meio] < elemento) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        return false;
    }
    
    public long getOperacoes() { return operacoes; }
}