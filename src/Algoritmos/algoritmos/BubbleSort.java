package algoritmos;

public class BubbleSort {
    private long operacoes;
    
    public void ordenar(int[] arr) {
        operacoes = 0;
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                operacoes++;
                if (arr[j] > arr[j + 1]) {
                    // Troca os elementos
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    operacoes += 3; // Conta as 3 operações de troca
                }
            }
        }
    }
    
    public long getOperacoes() { return operacoes; }
}