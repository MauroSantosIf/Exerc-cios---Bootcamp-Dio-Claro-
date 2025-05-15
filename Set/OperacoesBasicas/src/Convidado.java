public class Convidado {

    private String nome;
    private int codigoConvite;
    
    public Convidado(String nome, Integer codigoConvite) {
        this.nome = nome;
        this.codigoConvite = codigoConvite;
    
    }
    @Override
    public String toString(){
        return "Nome: "+
        nome+ " | Código de convite: " + codigoConvite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Convidado convidado = (Convidado) o;
        return codigoConvite == convidado.codigoConvite;
    }

    @Override
    public int hashCode() {
        return codigoConvite; // Usa apenas o código para determinar unicidade
    }

    public String getNome() {
        return nome;
    }

    public Integer getCodigoConvite() {
        return codigoConvite;
    }


}
