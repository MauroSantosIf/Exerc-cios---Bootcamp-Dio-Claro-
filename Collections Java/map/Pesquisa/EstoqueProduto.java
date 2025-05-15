package Pesquisa;
import java.util.Map;
import java.util.HashMap;

public class EstoqueProduto {
    private Map<Long, Produto> estoqueProdutoMap;

    public EstoqueProduto() {
        this.estoqueProdutoMap = new HashMap<>();
    }

    void adicionarProduto(long cod, String nome, double preco, int quantidade){
        estoqueProdutoMap.put(cod,new Produto(nome, preco, quantidade));
    }

    void exibirProdutos(){
        System.out.println("----------Lista Produtos----------");
        for(Map.Entry<Long, Produto> produtos: estoqueProdutoMap.entrySet()){
            System.out.println("Código: " + produtos.getKey() + " => "+produtos.getValue());
        }
    }

    double ValorEstoqueTotal(){
        double valorTotalEstoque = 0;
        if(!estoqueProdutoMap.isEmpty()){
            for(Produto p: estoqueProdutoMap.values()){
                valorTotalEstoque+= p.getPreco() * p.getQuantidade();
            }
        }
        return valorTotalEstoque;
    }

    Produto obterProdutoMaisCaro(){
        Produto produtoMaisCaro = null;

        double maiorPreco = Double.MIN_VALUE;

        for(Produto p: estoqueProdutoMap.values()){
            if(p.getPreco() > maiorPreco){
                produtoMaisCaro = p;
                maiorPreco = p.getPreco();
            }
        }
        return produtoMaisCaro;
    }

    public static void main(String[] args) {
        EstoqueProduto estoque = new EstoqueProduto();

        estoque.adicionarProduto(01L, "Tv", 1500, 1);
        // Adicionando um notebook ao estoque
        estoque.adicionarProduto(02L, "Notebook Dell", 3500.00, 5);

        // Adicionando um smartphone ao estoque
        estoque.adicionarProduto(03L, "iPhone 13", 5999.90, 3);

        // Adicionando um fone de ouvido ao estoque
        estoque.adicionarProduto(04L, "Fone Bluetooth", 199.50, 10);

        // Adicionando um videogame ao estoque
        estoque.adicionarProduto(05L, "PlayStation 5", 4499.99, 2);

        // Adicionando um produto com quantidade zero (fora de estoque)
        estoque.adicionarProduto(06L, "Monitor 4K", 1299.00, 0);

        // Adicionando um produto com valor decimal
        estoque.adicionarProduto(07L, "Mouse Gamer", 157.75, 8);

        // Adicionando um livro ao estoque
        estoque.adicionarProduto(8L, "Dom Casmurro", 29.90, 15);
        estoque.exibirProdutos();

        System.out.printf("Preço total do estoque: R$ %.2f\n",estoque.ValorEstoqueTotal());
        System.out.println("Produto com maior preço: " + estoque.obterProdutoMaisCaro());
    }

}
