public class ListaDuplamenteEncadeada<T> {
    private Node<T> base = null;
    private Node<T> top = null;
    private int size;

    public void adicionaFim(T valor) {
        var node = new Node<T>(valor);
        if(!estaVazio()) {
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
        if (index < 0 || index > size) { throw new IndexOutOfBoundsException("Não há essa posição :(");}

        Node<T> noAtual = base;
        for (int i = 0; i < index; i++) {
            if(i == index) {
                removeNode(noAtual);
                return noAtual.dado;
            }
            noAtual = noAtual.proximo;
        }
        return null;
    }

    private T removeNode(Node<T> node){
        T dado = node.dado;
        var proximo = node.proximo;
        var anterior = node.anterior;

        if(node == base) {
            base = base.proximo;
            if(base != null) {
                base = null;
            }
        } else if (node.proximo == null) {
            node.anterior = null;
        } else {
            node.proximo = anterior;
            node.anterior = proximo;
        }

        node.anterior = null;
        node.proximo = null;
        return dado;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Não há essa posição :(");
        }
        int meioLista = size / 2;
        if (meioLista >= index) {
            Node<T> noAtual = top;
            for (int i = 0; i < index; i++) {
                noAtual = noAtual.anterior;
            }
        }
        Node<T> noAtual = noAtual = base;
        for (int i = 0; i < index; i++) {
            noAtual = noAtual.proximo;
        }
        return noAtual;
    }

    public boolean estaVazio(){
        return this.base == null && this.top == null; //se base e top apontam para null a lista está vazia
    }

    public boolean estaCheio() {
        return false; //sempre conseguimos adicionar um elemento
    }

    public int getSize() {
        return getSize();
    }

    public void set(int posicao, T valor) {
        getNode(posicao).dado = valor;
    }

    public T get(int posicao) {
        return getNode(posicao).dado;
    }


    @Override
    public String toString() {
        String string = "Lista: ";

        for(Node<T> node = top; node != null; node = node.proximo) {
            string += node.dado + " ";
        }
        return string;
    }
}
