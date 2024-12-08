package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> carrinho;

    public CarrinhoDeCompras(){
        this.carrinho = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        carrinho.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        List<Item> itensRemover = new ArrayList<>();
        for (Item i: carrinho){
            if(i.getNome().equalsIgnoreCase(nome)){
                itensRemover.add(i);
            }
        }
        carrinho.removeAll(itensRemover);
    }

    public double calcularValorTotal(){
        double total = 0.00;
        for (Item i: carrinho){
            total += i.getPreco();
        }
        return total;
    }

    public void exibirItens(){
        System.out.println(carrinho);
    }

    public static void main(String[] args){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.exibirItens();
        carrinho.adicionarItem("Detergente", 7.50, 10);
        carrinho.adicionarItem("Pelúcia", 30.00, 50);
        carrinho.exibirItens();
        carrinho.adicionarItem("CD", 2.00, 10);
        carrinho.removerItem("CD");
        carrinho.exibirItens();
        carrinho.exibirItens();
        carrinho.adicionarItem("CD", 2.00, 20);
        carrinho.adicionarItem("CD", 2.00, 5);
        carrinho.exibirItens();
        carrinho.removerItem("CD");
        carrinho.exibirItens();

    }

}
