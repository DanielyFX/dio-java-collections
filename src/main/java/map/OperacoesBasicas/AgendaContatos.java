package main.java.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos(){
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone){
        agendaContatoMap.put(nome, telefone);
    }

    public void removerContato(String nome){
        if(!agendaContatoMap.isEmpty()){
            agendaContatoMap.remove(nome);
        }
    }

    public void exibirContatos(){
        System.out.println(agendaContatoMap);
    }

    public Integer pesquisarPorNome(String nome){
        Integer numeroPorNome = null;
        if(!agendaContatoMap.isEmpty()) {
            numeroPorNome = agendaContatoMap.get(nome);
        }
        return numeroPorNome;
    }

    public static void main(String[] args){
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Dany", 1234);
        agendaContatos.adicionarContato("Dany", 1235);
        agendaContatos.adicionarContato("Dany 2", 1235);
        agendaContatos.adicionarContato("Dany 4", 1236);
        agendaContatos.adicionarContato("Dany 5", 1237);

        agendaContatos.exibirContatos();
        agendaContatos.removerContato("Dany");
        agendaContatos.exibirContatos();

    }
}
