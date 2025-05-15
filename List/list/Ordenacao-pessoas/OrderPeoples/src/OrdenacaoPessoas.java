import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {

    private List <Pessoas> listaPessoas;

    public OrdenacaoPessoas() {
        this.listaPessoas = new ArrayList<>();
    }

    void adicionarPessoa(String nome, int idade, double altura){
        listaPessoas.add(new Pessoas(nome, idade, altura));
    }
    
    List<Pessoas> ordenadorPorIdade(){

        List<Pessoas> pessoasPorIdade = new ArrayList<>(listaPessoas);
        if(!listaPessoas.isEmpty()){
            Collections.sort(pessoasPorIdade); // Compareble passado na class Pessoas
            return pessoasPorIdade;
        }else{
            throw new RuntimeException("A lista está vazia");
        }
    }

    List<Pessoas> ordenadorPorAltura(){

        List<Pessoas> pessoasPorAltura = new ArrayList<>(listaPessoas); // Duplicando a pessoa list
        if(!listaPessoas.isEmpty()){
            Collections.sort(pessoasPorAltura,new compartorPorAltura()); // Quando não é passado essa instancia como segundo parâmetro ele compara pelo comparable, como estamos instanciando
            // essa class que criamos no outro arquivo e passando como parâmetro ele utiliza o compareto
            return pessoasPorAltura;
        }else{
            throw new RuntimeException("A lista está vazia");
        }

    }

    public static void main(String[] args) {

        OrdenacaoPessoas ordenadorPessoas = new OrdenacaoPessoas();

         // Adicionando pessoas à lista
        // Adicionando pessoas com dados variados
        ordenadorPessoas.adicionarPessoa("Mauro", 21, 1.90);
        ordenadorPessoas.adicionarPessoa("Ana", 32, 1.68);
        ordenadorPessoas.adicionarPessoa("Carlos", 45, 1.75);
        ordenadorPessoas.adicionarPessoa("Beatriz", 19, 1.62);
        ordenadorPessoas.adicionarPessoa("João", 28, 1.82);
        ordenadorPessoas.adicionarPessoa("Mariana", 24, 1.71);
        ordenadorPessoas.adicionarPessoa("Pedro", 60, 1.78);
        ordenadorPessoas.adicionarPessoa("Luísa", 17, 1.65);
        ordenadorPessoas.adicionarPessoa("Ricardo", 40, 1.88);
        ordenadorPessoas.adicionarPessoa("Sofia", 22, 1.73);
        ordenadorPessoas.adicionarPessoa("Antônio", 55, 1.76);
        ordenadorPessoas.adicionarPessoa("Fernanda", 30, 1.69);
        ordenadorPessoas.adicionarPessoa("Gustavo", 26, 1.81);
        ordenadorPessoas.adicionarPessoa("Isabela", 15, 1.60);
        ordenadorPessoas.adicionarPessoa("Rafael", 33, 1.85);
        ordenadorPessoas.adicionarPessoa("Patrícia", 29, 1.67);
        ordenadorPessoas.adicionarPessoa("Lucas", 20, 1.79);
        ordenadorPessoas.adicionarPessoa("Camila", 38, 1.72);
        ordenadorPessoas.adicionarPessoa("Eduardo", 50, 1.83);
        ordenadorPessoas.adicionarPessoa("Juliana", 23, 1.70);

        // Exibindo a lista de pessoas adicionadas
        System.out.println("Lista de Pessoas");
        for(Pessoas p: ordenadorPessoas.listaPessoas){
            System.out.println(p);

        }

        System.out.println("---------------------------------------------------------------");

        // Ordenando e exibindo por idade
        System.out.println("Lista de ordenada pela idade");

        for(Pessoas p: ordenadorPessoas.ordenadorPorIdade()){
            System.out.println(p);

        }

        System.out.println("---------------------------------------------------------------");

        System.out.println("Lista ordenada por altura");

        // Ordenando e exibindo por altura
        for(Pessoas p: ordenadorPessoas.ordenadorPorAltura()){
            System.out.println(p);

        }

    }
    
}
