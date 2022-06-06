public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada listaDE = new ListaDuplamenteEncadeada();

        listaDE.adicionaFim(1);
        listaDE.adicionaFim(2);
        listaDE.adicionaFim(3);
        listaDE.adicionaFim(4);
        listaDE.adicionaFim(5);
        listaDE.toString();
        listaDE.adicionaIndice(2,2);
        listaDE.toString();
        listaDE.removeIndex(2);
        listaDE.toString();
        listaDE.removeIndex(4);
        listaDE.toString();
        listaDE.getSize();




    }
}
