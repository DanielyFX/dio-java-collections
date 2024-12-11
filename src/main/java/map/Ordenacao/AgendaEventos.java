package main.java.map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventosMap;
    public AgendaEventos(){
        this.eventosMap = new HashMap<>();
    }

    public void obterProximoEvento(){
        //Set<LocalDate> dataset = eventosMap.keySet();
        //Collection<Evento> values = eventosMap.values();
        //eventosMap.get();

        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        for(Map.Entry<LocalDate, Evento> entry: eventosMap.entrySet()){
            if(entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)){
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                System.out.println("O próximo evento: " + proximoEvento + " acontecerá na data " + proximaData);
                break;
            }
        }

    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        Evento evento = new Evento(nome, atracao);
        eventosMap.put(data, evento);
    }

    public void exibirAgenda(){
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        System.out.println(eventosTreeMap);
    }

    public static void main(String[] args){
        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Paralamas do sucesso", "Show");
        agendaEventos.adicionarEvento(LocalDate.of(2022, 7, 1), "Metallica", "Show");
        agendaEventos.adicionarEvento(LocalDate.of(2022, 1, 3), "Iron mainden", "Show");
        agendaEventos.adicionarEvento(LocalDate.of(2022, 12, 29), "Twent One pilot", "Show");
        agendaEventos.adicionarEvento(LocalDate.of(2025, 1, 29), "Twent One pilot", "Show");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 12, 12), "Twent One pilot", "Show");

        agendaEventos.exibirAgenda();

        agendaEventos.obterProximoEvento();
    }
}
