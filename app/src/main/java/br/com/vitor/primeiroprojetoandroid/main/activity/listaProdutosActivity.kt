package br.com.vitor.primeiroprojetoandroid.main.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.vitor.primeiroprojetoandroid.R
import br.com.vitor.primeiroprojetoandroid.main.dao.ProdutosDao
import br.com.vitor.primeiroprojetoandroid.main.recyclerview.adapter.ListaProdutosAdpter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class listaProdutosActivity : AppCompatActivity(R.layout.activity_lista_produtos) {

    private val dao = ProdutosDao()
    private val adapter = ListaProdutosAdpter(context = this, produtos = dao.buscarProdutos())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraRecyclerView()
        configuraFloatingActionButton()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscarProdutos())
    }

    private fun configuraFloatingActionButton() {
        //Chamar outra view baseada no botão + em idle
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            vaiParaFormularioDeProduto()
        }
    }

    private fun vaiParaFormularioDeProduto() {
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewlista)
        recyclerView.adapter = adapter
    }
}