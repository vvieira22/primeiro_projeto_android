package br.com.vitor.primeiroprojetoandroid.main.dao

import br.com.vitor.primeiroprojetoandroid.main.recyclerview.adapter.model.Produto
import java.math.BigDecimal

class ProdutosDao {

    fun adicionarProduto(produto: Produto)
    {
        Companion.produtos.add(produto)
    }

    fun buscarProdutos() : List<Produto>
    {
        return Companion.produtos.toList() //toList para nao ocorrer manipulacao no dado original
    }

    companion object {
        private val produtos = mutableListOf<Produto>(Produto("Teste","descricao", BigDecimal("2.99")))
    }

}