import java.util.Comparator;
import java.util.Objects;

public class Produto implements Comparable<Produto>{

    private String nome;
    private long codigo;
    private double preco;
    private int quantidade;
    
    public Produto(String nome, long codigo, double preco, int quantidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }


    @Override
    public int compareTo(Produto produto) {
        // TODO Auto-generated method stub
        return nome.compareToIgnoreCase(produto.getNome());
        // Vamos conseguir fazer a comparação, se o produto que está consultando é maior ou menor com o que está sendo feito a comparação
    }

    @Override
    public String toString(){

        return
        " Nome: "+nome
        +", Código: "+codigo
        +", Preço: R$ "+preco
        +", quantidade: "+quantidade;

    }

    public String getNome() {
        return nome;
    }

    public long getCodigo() {
        return codigo;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
}

class ComparatorPorPreco implements Comparator<Produto>{
    @Override
    public int compare(Produto produto1, Produto produto2){
        return Double.compare(produto1.getPreco(), produto2.getPreco());
    }
}