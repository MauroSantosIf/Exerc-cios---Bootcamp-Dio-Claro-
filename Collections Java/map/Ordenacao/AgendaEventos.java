package Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEventos {

    private Map<LocalDate,Evento> eventos;

    public AgendaEventos(){this.eventos = new HashMap<>();}

    void adicionarEvento(LocalDate data, String nomeEvento, String nomeAtracao){
        //Evento evento = new Evento(nomeEvento, nomeAtracao);
        eventos.put(data, new Evento(nomeEvento, nomeAtracao));
    }

    void exibirAgendaOrdenada(){
        Map<LocalDate,Evento> eventosMap = new TreeMap<>(eventos);
        for(Map.Entry<LocalDate,Evento> e: eventosMap.entrySet()){
            System.out.println("Data: "+ e.getKey() + " => " + e.getValue());
        }
    }

    void obterProximoEvento(){

        /*Set<LocalDate> dataSet = eventos.keySet();
        Collection<Evento> values = eventos.values();*/
        //eventos.get(eventos) receberia a chave e devolveria o evento

        LocalDate dataAtual = LocalDate.now(); // retorna data atual
        Map<LocalDate,Evento> eventosMap = new TreeMap<>(eventos); // Aqui, igualmente acima, já tenho uma map ordenado
        
        LocalDate proximaData = null;
        Evento proximoEvento = null;

        for(Map.Entry<LocalDate,Evento> entry : eventosMap.entrySet()){
            // no lugar desse pedaço de código ((Map.Entry<LocalDate,Evento>)) poderia só utilizar o var não obrigando a passar o tipo da variável
            proximaData = entry.getKey();
            proximoEvento = entry.getValue();
            if(proximaData.isEqual(dataAtual) || proximaData.isAfter(dataAtual)){
                System.out.println("O próximo evento é " + proximoEvento + " acontecerá na data " +proximaData);
                break;
            }
        }
    }

    public static void main(String[] args) {

        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Conferência de Tecnologia", "Palestrante renomado");
        agendaEventos.adicionarEvento(LocalDate.of(2022, 7, 9), "Workshop de Programação", "Aula prática de desenvolvimento");
        agendaEventos.adicionarEvento(LocalDate.of(2000, 1, 10), "Lançamento de Software", "Demonstração da nova versão");
        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.AUGUST, 28), "Hackathon de Inovação", "Competição de soluções criativas");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 9, 20), "Seminário de Inteligência Artificial", "Discussão sobre IA avançada");
        agendaEventos.adicionarEvento(LocalDate.of(2025, Month.MAY, 31), "Aniversário do pai", "Comemoração de aniversário do Manoel Messias da Paz");

        agendaEventos.exibirAgendaOrdenada();
        System.out.println("----------------------------------------------------------------------");
        agendaEventos.obterProximoEvento();


    }

}
