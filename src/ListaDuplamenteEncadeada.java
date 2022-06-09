public class ListaDuplamenteEncadeada<T> {
    private Node<T> base = null;
    private Node<T> top = null;
    private int size;

    public void adicionaFim(T valor) {
        var node = new Node(valor);
        node.dado = valor;
        if (estaVazio()) {
            base = node;
        } else {
            node.anterior = top;
            top.proximo = node;
        }
        top = node;
        size++;
    }

    public void adicionaIndice(int index, T valor) {
        if (index == getSize()) {
            adicionaFim(valor);
        }
        var node = new Node<T>(valor);
        var proximo = getNode(index);
        var anterior = proximo.anterior;

        node.proximo = proximo;
        node.anterior = anterior;

        if (anterior != null) {
            anterior.proximo = node;
        } else {
            base = node;
        }

        proximo.anterior = node;
        size++;
    }


    public T removeIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Não há essa posição :(");
        }

        var node = getNode(index);
        removeNode(node);

        return node.dado;
    }

    private T removeNode(Node<T> node) {
        T dado = node.dado;
        var proximo = node.proximo;
        var anterior = node.anterior;

        if (node == base) {
            base = base.proximo;
            if (base != null) {
                base = null;
            }
        } else if (node.proximo == null) {
            anterior.proximo = null;
        } else {
            proximo.anterior = anterior;
            anterior.proximo = proximo;
        }

        node.anterior = null;
        node.proximo = null;
        size--;
        return dado;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Não há essa posição :(");
        }
        int meioLista = size / 2;

        if (meioLista >= index) {
            Node<T> noAtual = top;
            for (int i = size - 1; i != index; i--) {
                noAtual = noAtual.anterior;
            }
            return noAtual;
        }
        Node<T> noAtual = base;
        for (int i = 0; i < index; i++) {
            noAtual = noAtual.proximo;
        }
        return noAtual;
    }

    public boolean estaVazio() {
        return this.base == null && this.top == null; //se base e top apontam para null a lista está vazia
    }

    public boolean estaCheio() {
        return false; //sempre conseguimos adicionar um elemento
    }

    public int getSize() {
        System.out.println("O tamanho da lista é: ");
        return size;
    }

    public void set(int posicao, T valor) {
        getNode(posicao).dado = valor;
    }

    public T get(int posicao) {
        return getNode(posicao).dado;
    }


    public void display() {
        //Começa pela base
        Node current = base;
        if (base == null) {
            System.out.println("Lista vazia");
            return;
        }
        System.out.println("Nos da lista encadeada: ");
        System.out.print(current.dado + " ");
        while (current.proximo != null) {
            System.out.print(current.proximo.dado + " ");
            current = current.proximo;
        }
        System.out.println(" ");

    }
}
