import java.util.Set;
import java.util.HashSet;

public class ConjuntoConvidado {

    private Set<Convidado> setConvidados;

    public ConjuntoConvidado() {
        this.setConvidados = new HashSet<>();
    }

    @Override
    public String toString(){
        return "setConvidados: "+ setConvidados;
    }
    
    public void adicionarConvidado(String nome, int codigoConvite){
        setConvidados.add(new Convidado(nome,codigoConvite));
    }

    void removerConvidado(int codigoConvite){

        setConvidados.removeIf(c -> c.getCodigoConvite() == codigoConvite);
    }

    int contadorConvidados(){
        return setConvidados.size();
    }

    void exiibirConvidados(){
        System.out.printf("Convidados: %d\n", contadorConvidados());
        int ordinal = 1;
        for(Convidado c:setConvidados){
            System.out.println(ordinal+"° " +c);
            ordinal++;
        }
        System.out.println("-----------------------------------------------------------------------");

    }




    public static void main(String[] args) {
        ConjuntoConvidado setConvidados = new ConjuntoConvidado();
        
        setConvidados.adicionarConvidado("Mauro Santos", 1236);
        setConvidados.adicionarConvidado("Ana Silva", 2245);
        setConvidados.adicionarConvidado("Carlos Oliveira", 332);
        setConvidados.adicionarConvidado("Maria Souza", 45);
        setConvidados.adicionarConvidado("João Pereira", 22);
        setConvidados.adicionarConvidado("João Pereira", 22);


        System.out.println("Existe "+setConvidados.contadorConvidados()+ " convidado(s)");
        setConvidados.exiibirConvidados();


        setConvidados.removerConvidado(1236);

        setConvidados.exiibirConvidados();
         
    }

}
