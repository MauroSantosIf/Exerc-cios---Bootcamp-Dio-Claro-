import java.util.Set;
import java.util.HashSet;

public class AgendaContato {

    private Set<Contato> setContatos;

    public AgendaContato() {

        this.setContatos = new HashSet<>();

    }

    void adicionarContato(String nome, int numero){
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        if (numero <= 0) {
            throw new IllegalArgumentException("Número inválido.");
        }
        setContatos.add(new Contato(nome, numero));
    }

    void exibirContatos(){

        StringBuilder sb = new StringBuilder("Contatos:\n");

        setContatos.forEach(c -> sb.append(c).append("\n"));
        System.out.println(sb);
    }

    Set<Contato> pesquisarPorNome(String nome){

        Set<Contato> contatosEncontrados = new HashSet<>();

        for(Contato c: setContatos){
            if (c.getNome().startsWith(nome)) {
                contatosEncontrados.add(c);
            }
        }
        return contatosEncontrados;
    }

    Contato atualizarNumeroContato(String nome, int novoNumero){
        for(Contato c: setContatos){
            if(c.getNome().equalsIgnoreCase(nome)){
                c.setNumero(novoNumero);
                return c;
            }
        }
        throw new ContatoNaoEncontradoException("Contato "+ nome+" não encontrado");
    }


    public static void main(String[] args) {
    AgendaContato contatos = new AgendaContato();

    contatos.adicionarContato("João", 123456789);
    contatos.adicionarContato("Maria", 987654321);
    contatos.adicionarContato("Maria Fernandes", 55555555);
    contatos.adicionarContato("Ana", 88889999);
    contatos.adicionarContato("Fernando", 77778888);
    contatos.adicionarContato("Carolina", 55555555);

    // Exibindo os contatos na agenda
    contatos.exibirContatos();

    // Pesquisando contatos pelo nome
    System.out.println(contatos.pesquisarPorNome("Maria"));

    // Atualizando o número de um contato
    Contato contatoAtualizado = contatos.atualizarNumeroContato("Carolina", 44443333);
    System.out.println("Contato atualizado: " + contatoAtualizado);

    // Exibindo os contatos atualizados na agenda
    System.out.println("Contatos na agenda após atualização:");
    contatos.exibirContatos();

    }
    
}
