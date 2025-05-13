import java.util.List;
import java.util.ArrayList;

public class ListaTarefas {
    // atributo listaTarefas
    private List<Tarefa> listaTarefas;

    public ListaTarefas() {
        this.listaTarefas = new ArrayList<>();
        // Sempre que criar um objeto do tipo lista de tarefas, sempre terá uma lista vazia inicialmente
    }

    public void adicionarTarefa(String descricao) {
        listaTarefas.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        // Forma otimizada de remover a tarefa da lista de tarefas
        listaTarefas.removeIf(t -> t.getDescricao().equalsIgnoreCase(descricao));

        /* 
         Remover a tarefa da lista de tarefas de forma convencional
        List<Tarefa> tarefasRemovidas = new ArrayList<>();
        for (Tarefa t : listaTarefas) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                tarefasRemovidas.add(t);
            }
        }
        listaTarefas.removeAll(tarefasRemovidas);*/
    }

    public int ObterNumeroTarefas() {
        return listaTarefas.size();
    }

    public void ObterDescricaoTarefas() {
        for (Tarefa t : listaTarefas) {
            System.out.println(t.getDescricao());
        }
    }

    public static void main(String[] args) {
        
        ListaTarefas lista = new ListaTarefas();

        System.out.println("Número de tarefas: " + lista.ObterNumeroTarefas());

        lista.adicionarTarefa("Estudar");
        lista.adicionarTarefa("Estudar");

        lista.adicionarTarefa("Trabalhar");

        System.out.println("Número de tarefas: " + lista.ObterNumeroTarefas());

        lista.removerTarefa("Estudar"); // Como existe mais de uma tarefa com o mesmo nome, remove todas as tarefas com o mesmo nome

        System.out.println("Número de tarefas: " + lista.ObterNumeroTarefas());

        System.out.println("Descrição das tarefas: ");
        lista.ObterDescricaoTarefas();

    }
}   
