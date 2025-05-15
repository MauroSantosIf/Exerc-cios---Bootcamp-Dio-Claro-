import java.util.List;
import java.util.ArrayList;

public class CarrinhoCompras{

    private List<Item> CarrinhoCompras;

    public CarrinhoCompras() {
        this.CarrinhoCompras = new ArrayList<>();
    }    

    void adicionarItem(String nome, double preco, int quantidade) {
        CarrinhoCompras.add(new Item(nome, preco, quantidade));
    }

    void removerItem(String nome){
        CarrinhoCompras.removeIf(item -> item.getNome().equalsIgnoreCase(nome));
    }

    public float calcularValorTotal(){
        float total = 0;
        for (Item I : CarrinhoCompras){
            total += I.getPreco() * I.getQuantidade();
        }

        return total;
    }

    void exibirItens(){
        System.out.println("Itens no carrinho:");
        int ordinal = 1;
        for (Item I : CarrinhoCompras){
            System.out.printf(ordinal+"° item: " +I.getNome() + " - R$ " + "%.2f" + " - " + I.getQuantidade()+ " UN(s)" +"\n",I.getPreco());
            ordinal++;
        }
    }

    public static void main(String[] args) {

        CarrinhoCompras carrinhos = new CarrinhoCompras();

        carrinhos.adicionarItem("Tv", 1500.50, 1);

        carrinhos.adicionarItem("Celular", 2000.00, 2);

        System.out.printf("Valor total: R$ %.2f\n", carrinhos.calcularValorTotal());

        carrinhos.exibirItens();

    }

}