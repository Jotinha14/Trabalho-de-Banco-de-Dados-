package Algoritmos;

public class BuscaSequencial {
    private long operacoes;
    
    public boolean buscar(int[] arr, int elemento) {
        operacoes = 0;
        for (int i = 0; i < arr.length; i++) {
            operacoes++;
            if (arr[i] == elemento) {
                return true;
            }
        }
        return false;
    }
    
    public long getOperacoes() { return operacoes; }
}