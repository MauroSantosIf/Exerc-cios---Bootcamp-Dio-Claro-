import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

public class CadastroProdutos {

    private Set<Produto> setProdutos;

    public CadastroProdutos() {
        this.setProdutos = new HashSet<>();
    }

    void adicionarProduto(long cod, String nome, double preco, int quantidade){
        setProdutos.add(new Produto(nome, cod, preco, quantidade));
    }

    void exibirProdutos(){
        System.out.println("Lista de produtos: ");
        int numeral = 1;
        for(Produto p: setProdutos){
            System.out.println(numeral+" - "+p);
            numeral++;
        }

        System.out.println("_________________________________________________________________");
    }

    Set<Produto> exibirProdutoPorNome(){

        Set<Produto> setOrdenadoPorNome = new TreeSet<>(setProdutos);
        // Não foi criado com HashSet porque ele não permiti organizar
        return setOrdenadoPorNome;

    }

    Set<Produto> exibirPorPreco(){
        Set<Produto> setOrdenadoPorPreco = new TreeSet<>(new ComparatorPorPreco());
        if (!setProdutos.isEmpty()) {
            setOrdenadoPorPreco.addAll(setProdutos);
            return setOrdenadoPorPreco;
        }else{
            throw new RuntimeException("O conjunto está vazio");
        }

    }

    public static void main(String[] args){

        CadastroProdutos produtos = new CadastroProdutos();

        produtos.adicionarProduto(123L, "Tv", 1500, 1);
        produtos.adicionarProduto(124L, "Notebook", 3500, 2);
        produtos.adicionarProduto(125L, "Smartphone", 2200, 5);
        produtos.adicionarProduto(126L, "Tablet", 1300, 3);
        produtos.adicionarProduto(127L, "Monitor", 900, 4);
        produtos.adicionarProduto(128L, "Teclado", 150, 10);
        produtos.adicionarProduto(129L, "Mouse", 100, 12);
        produtos.adicionarProduto(130L, "Impressora", 800, 2);
        produtos.adicionarProduto(131L, "Caixa de Som", 250, 6);
        produtos.adicionarProduto(132L, "Webcam", 300, 3);
        produtos.adicionarProduto(133L, "HD Externo", 400, 5);
        produtos.adicionarProduto(134L, "Pen Drive", 80, 15);
        produtos.adicionarProduto(135L, "Roteador", 200, 4);

        
        int numeral = 1;
        System.out.println("Ordenado por nome");
        for(Produto p:produtos.exibirProdutoPorNome()){
            System.out.println(numeral+"-"+p);
            numeral++;
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("Ordenado por preço");
        for(Produto pre:produtos.exibirPorPreco()){
            System.out.println(numeral+"-"+pre);
            
        }


    }

}
