public class Node<T>{
    Node<T> anterior;
    T dado;
    Node<T> proximo;

    public Node(T valor) {
        this.dado = valor;
    }
}
