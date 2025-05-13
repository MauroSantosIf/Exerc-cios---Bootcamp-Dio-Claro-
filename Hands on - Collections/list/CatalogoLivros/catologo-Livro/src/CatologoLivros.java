import java.util.List;
import java.util.ArrayList;


public class CatologoLivros {

    private List<Livro> listaLivros;

    // Construtor padrão
    public CatologoLivros() {
        this.listaLivros = new ArrayList<>();
    }
    
    // caso ele receba null, ele vai criar uma lista vazia
    // Construtor com lista de livros e validação
    public CatologoLivros(List<Livro> listaLivros) {
        this.listaLivros = listaLivros != null ? listaLivros : new ArrayList<>();
    }

    void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        if (titulo == null || titulo.trim().isEmpty() || autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("Título e autor não podem ser nulos ou vazios");
        }
        listaLivros.add(new Livro(titulo, autor, anoPublicacao));
    }

    // Se não tem nada abaixo ( public ou void), fica por padrão utilizado o public, mesmo sem ele está ali
    List<Livro> pesquisarPorAutor(String autor){
        List<Livro> livrosPorAutor = new ArrayList<>();

        if(autor == null) return livrosPorAutor;
        
        for (Livro livro : listaLivros){
            if(livro.getAutor().equalsIgnoreCase(autor)){
                livrosPorAutor.add(livro);
            }
        }   
        return livrosPorAutor;

    }

    List<Livro> pesquisarPorIntervalosAnos(int anoInicio, int anoFim){

        List<Livro> livrosPorIntervaloAnos = new ArrayList<>();
        if (anoInicio > anoFim) return livrosPorIntervaloAnos;

        for(Livro L: listaLivros){
            if(L.getAnoPublicacao() >= anoInicio && L.getAnoPublicacao() <= anoFim){
                livrosPorIntervaloAnos.add(L);
            }
        }
        return livrosPorIntervaloAnos;

    }


    void removerLivro(String titulo){
        if(titulo == null || titulo.trim().isEmpty()){
            throw new IllegalArgumentException("O título não pode ser nulo ou vazio.");
        }

        for(Livro L: listaLivros){
            if(L.getTitulo().equalsIgnoreCase(titulo)){
                listaLivros.remove(L);
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    Livro pesquisarPorTitulo(String titulo){

        if(titulo == null){
            throw new IllegalArgumentException("O título não pode ser nulo.");
        }

        if(listaLivros == null || listaLivros.isEmpty()){
            System.out.println("Nenhum livro cadastrado.");
            return null;
        }
        
    
        for(Livro L: listaLivros){
            if(L.getTitulo().equalsIgnoreCase(titulo)){
                return L;
            }

        }
        return null;

    }

    @Override
    public String toString() {
        if (listaLivros == null || listaLivros.isEmpty()) {
            return "Catálogo vazio";
        }
        
        StringBuilder sb = new StringBuilder("Catálogo de Livros:\n");
        for (Livro livro : listaLivros) {
            sb.append("- ").append(livro).append("\n"); // Assumindo que Livro também tem toString()
        }
        return sb.toString();
    }

    

    public static void main(String[] args) {
        
        CatologoLivros catalogo = new CatologoLivros();
        catalogo.adicionarLivro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954);
        catalogo.adicionarLivro("1984", "George Orwell", 1949);
        catalogo.adicionarLivro("O Hobbit", "J.R.R. Tolkien", 1937);
        catalogo.adicionarLivro("A Revolução dos Bichos", "George Orwell", 1945);
        catalogo.adicionarLivro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943);

        System.out.println(catalogo);
        System.out.println("--------------------------------------------------------------------");

        catalogo.removerLivro("O Senhor dos Anéis");
        
        for(int i = 0; i < catalogo.pesquisarPorAutor("George Orwell").size();i++){
            System.out.println(catalogo.pesquisarPorAutor("George Orwell"));
        }

        
    }
}
