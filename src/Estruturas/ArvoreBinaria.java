package estruturas;

public class ArvoreBinaria {
    private NoABB raiz;
    private int operacoes;
    
    class NoABB {
        int valor;
        NoABB esquerda;
        NoABB direita;
        
        public NoABB(int valor) {
            this.valor = valor;
        }
    }
    
    // Inserção - O(h) onde h é a altura
    public void inserir(int valor) {
        operacoes = 0;
        raiz = inserirRecursivo(raiz, valor);
    }
    
    private NoABB inserirRecursivo(NoABB no, int valor) {
        operacoes++;
        if (no == null) {
            return new NoABB(valor);
        }
        
        if (valor < no.valor) {
            no.esquerda = inserirRecursivo(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserirRecursivo(no.direita, valor);
        }
        
        return no;
    }
    
    // Busca - O(h)
    public boolean buscar(int valor) {
        operacoes = 0;
        return buscarRecursivo(raiz, valor);
    }
    
    private boolean buscarRecursivo(NoABB no, int valor) {
        operacoes++;
        if (no == null) return false;
        if (no.valor == valor) return true;
        
        if (valor < no.valor) {
            return buscarRecursivo(no.esquerda, valor);
        } else {
            return buscarRecursivo(no.direita, valor);
        }
    }
    
    public int getOperacoes() { return operacoes; }
    public void limpar() { raiz = null; }
}