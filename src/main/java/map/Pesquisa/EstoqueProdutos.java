package main.java.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProdutos(){
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco){
        estoqueProdutosMap.put(cod, new Produto(nome, preco, quantidade));
    }

    public void exibirProdutos(){
        System.out.println(estoqueProdutosMap);
    }

    public double calcularValorTotalEstoque(){
        double valorTotalEstoque = 0d;
        if(!estoqueProdutosMap.isEmpty()){
            for(Produto p: estoqueProdutosMap.values()){
                valorTotalEstoque += p.getQuantidade() * p.getPreco();
            }

        }
        return valorTotalEstoque;
    }

    public Produto obterProdutoMaisCaroEstoque(){
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        for(Produto p: estoqueProdutosMap.values()){
            if(p.getPreco() > maiorPreco){
                produtoMaisCaro = p;
            }
        }
        return produtoMaisCaro;
    }

    public static void main(String[] args){
        EstoqueProdutos estoque = new EstoqueProdutos();
        estoque.exibirProdutos();

        estoque.adicionarProduto(1L, "Leite", 5, 10.00);
        estoque.adicionarProduto(2L, "Margarina", 10, 15.00);
        estoque.adicionarProduto(3L, "Achocolatado", 3, 20.00);
        estoque.adicionarProduto(4L, "Barra de chocolate", 100, 5.00);
        estoque.adicionarProduto(1L, "Leite", 5, 10.00);
        estoque.adicionarProduto(1L, "Leite", 5, 10.00);

        estoque.exibirProdutos();

        System.out.println("Valor total do estoque: "+ estoque.calcularValorTotalEstoque());
        System.out.println(estoque.obterProdutoMaisCaroEstoque());
    }
}
