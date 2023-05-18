package br.com.vitor.primeiroprojetoandroid.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.vitor.primeiroprojetoandroid.R
import br.com.vitor.primeiroprojetoandroid.ui.recyclerview.adapter.ListaProdutosAdpter
import br.com.vitor.primeiroprojetoandroid.ui.recyclerview.adapter.model.Produto
import java.math.BigDecimal

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val frutas : TextView = findViewById<TextView>(R.id.frutas)
//        frutas.text = "banana, maça, beterraba";
//        val preco = findViewById<TextView>(R.id.preco)
//        preco.text = "9,99R$";
//        val nome = findViewById<TextView>(R.id.nome)
//        nome.text = "Salada de Frutas";

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewlista)
        recyclerView.adapter = ListaProdutosAdpter(
            context = this, produtos = listOf(
                Produto(
                    nome = "teste",
                    descricao = "descricao",
                    preco = BigDecimal("19.99")
                ), Produto(
                    nome = "teste2",
                    descricao = "descricao2",
                    preco = BigDecimal("19.992")
                ), Produto(
                    nome = "teste3",
                    descricao = "descricao3",
                    preco = BigDecimal("1")
                ), Produto(
                    nome = "teste4",
                    descricao = "descricao4",
                    preco = BigDecimal("2")
                )
            )
        )
//        recyclerView.layoutManager = LinearLayoutManager(this)
    }

}