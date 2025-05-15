package OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


public class AgendaContatos{
    private Map<String,String>agendaContatoMap;

    public AgendaContatos() {
        this.agendaContatoMap = new HashMap<>();
    }

     private boolean validarNumero(String numero) {
        // Regex: 55 seguido de 2 dígitos (DDD), depois 9 e mais 8 dígitos
        String expressasoRegular = "^55\\d{2}9\\d{8}$";
        return Pattern.matches(expressasoRegular, numero);
    }

    private String formatarNumero(String numero){
        return String.format("+%s (%s) %s %s-%s",
          numero.substring(0, 2),   // Código do país (55)
            numero.substring(2, 4),   // DDD (82)
            numero.substring(4, 5),   // Dígito 9
            numero.substring(5, 9),   // Restante dos 8 numeros
            numero.substring(9));
    }

    // Converte String válida para Long (ou null se inválido)
    /* 
    private Long converterParaLong(String numeroStr) {
        try {
            return Long.parseLong(numeroStr);
        } catch (NumberFormatException e) {
            return null;
        }
    } Caso precisasse de operação matemática com o número do contato*/

    void adicionarContato(String nome, String numero){
        if (validarNumero(numero)) {
            agendaContatoMap.put(nome, numero);
            System.out.println("Contato '" + nome + "' adicionado com sucesso!");
        } else {
            System.out.println("Número inválido para '" + nome + "'. Formato esperado: 55DDD9XXXXXXXX (ex:5582998765432)");
        }
    }

    void removerContato(String nome){
        if (!agendaContatoMap.isEmpty()) {
            agendaContatoMap.remove(nome);
        }
        /*Não precisa de um for para percorrer porque a key do map é único.
        Então a key que foi encontrada para ser removida, é única.
         */
    } 

    void exibirContatos(){
        System.out.println("\n--- Lista de Contatos ---");
        for(Map.Entry<String,String> c : agendaContatoMap.entrySet()){
            System.out.println(c.getKey() + " ==> " + formatarNumero(c.getValue()));
        }
    }

    String pesquisarPorNome(String nome){
        return agendaContatoMap.get(nome);
    }
    public static void main(String[] args) {

        AgendaContatos contatos = new AgendaContatos();

        // Válidos (padrão 55 + DDD + 9 + 8 dígitos)
        contatos.adicionarContato("Mauro", "5582994102151");   // Válido (DDD 82)
        contatos.adicionarContato("Carlos", "5511987654321");  // Válido (DDD 11)

        // Inválidos (geram mensagem de erro)
        contatos.adicionarContato("Ana", "5582987654321");     // Falta o 9
        contatos.adicionarContato("Maria", "55829912345678");  // Tem 9 dígitos após o 9
        
        contatos.exibirContatos();
       

    }
}