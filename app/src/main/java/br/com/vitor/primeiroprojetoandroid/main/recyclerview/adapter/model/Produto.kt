package br.com.vitor.primeiroprojetoandroid.main.recyclerview.adapter.model

import java.math.BigDecimal

class Produto (
    val nome : String,
    val descricao : String,
    val valor : BigDecimal
)
{
    override fun toString(): String {
        return "Produto\nNome:$nome" +
                "\nDescricao:$descricao" +
                "\nValor: $valor".filter { !it.isWhitespace() }
    }
}