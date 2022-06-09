public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada listaDE = new ListaDuplamenteEncadeada();
        listaDE.adicionaFim(1);
        listaDE.adicionaFim(2);
        listaDE.display();
        listaDE.adicionaFim(3);
        listaDE.adicionaFim(4);
        listaDE.adicionaFim(5);
        listaDE.display();
        listaDE.adicionaIndice(2,2);
        listaDE.display();
        listaDE.removeIndex(2);
        listaDE.removeIndex(4);
        listaDE.display();
        listaDE.getSize();
    }
}
