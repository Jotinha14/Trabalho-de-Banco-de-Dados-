package estruturas;

public class ArvoreAVL {
    private NoAVL raiz;
    private int operacoes;
    
    class NoAVL {
        int valor, altura;
        NoAVL esquerda, direita;
        
        public NoAVL(int valor) {
            this.valor = valor;
            this.altura = 1;
        }
    }
    
    // Inserção com balanceamento - O(log n)
    public void inserir(int valor) {
        operacoes = 0;
        raiz = inserirRecursivo(raiz, valor);
    }
    
    private NoAVL inserirRecursivo(NoAVL no, int valor) {
        operacoes++;
        if (no == null) return new NoAVL(valor);
        
        if (valor < no.valor) {
            no.esquerda = inserirRecursivo(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserirRecursivo(no.direita, valor);
        } else {
            return no; // Valores duplicados não permitidos
        }
        
        // Atualizar altura e balancear
        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        return balancear(no);
    }
    
    private NoAVL balancear(NoAVL no) {
        int balanceamento = getBalanceamento(no);
        
        // Caso Esquerda-Esquerda
        if (balanceamento > 1 && getBalanceamento(no.esquerda) >= 0) {
            return rotacaoDireita(no);
        }
        
        // Caso Direita-Direita
        if (balanceamento < -1 && getBalanceamento(no.direita) <= 0) {
            return rotacaoEsquerda(no);
        }
        
        // Caso Esquerda-Direita
        if (balanceamento > 1 && getBalanceamento(no.esquerda) < 0) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }
        
        // Caso Direita-Esquerda
        if (balanceamento < -1 && getBalanceamento(no.direita) > 0) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }
        
        return no;
    }
    
    // Rotações AVL
    private NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.esquerda;
        NoAVL T2 = x.direita;
        
        x.direita = y;
        y.esquerda = T2;
        
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        
        return x;
    }
    
    private NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.direita;
        NoAVL T2 = y.esquerda;
        
        y.esquerda = x;
        x.direita = T2;
        
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        
        return y;
    }
    
    // Métodos auxiliares
    private int altura(NoAVL no) {
        return no == null ? 0 : no.altura;
    }
    
    private int getBalanceamento(NoAVL no) {
        return no == null ? 0 : altura(no.esquerda) - altura(no.direita);
    }
    
    // Busca - O(log n)
    public boolean buscar(int valor) {
        operacoes = 0;
        return buscarRecursivo(raiz, valor);
    }
    
    private boolean buscarRecursivo(NoAVL no, int valor) {
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