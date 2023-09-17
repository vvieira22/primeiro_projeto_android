package br.com.vitor.primeiroprojetoandroid.main.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.vitor.primeiroprojetoandroid.R
import br.com.vitor.primeiroprojetoandroid.main.dao.ProdutosDao
import br.com.vitor.primeiroprojetoandroid.main.recyclerview.adapter.ListaProdutosAdpter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import br.com.vitor.primeiroprojetoandroid.databinding.ActivityListaProdutosBinding

class listaProdutosActivity : AppCompatActivity() {

    private val dao = ProdutosDao()
//    private val adapter = ListaProdutosAdpter(context = this, produtos = dao.buscarProdutos())

    private val adapter by lazy {
        ListaProdutosAdpter(this, produtos = dao.buscarProdutos())
    }

    private val binding by lazy {
        ActivityListaProdutosBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView = binding.recyclerViewlista
        recyclerView.adapter = adapter

        configuraFloatingActionButton()
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscarProdutos())
    }

    private fun configuraFloatingActionButton() {
        //Chamar outra view baseada no botão + em idle
        val fab = binding.floatingActionButton
        fab.setOnClickListener{
            Intent(this,FormularioProdutoActivity::class.java)
                .run{
                    startActivity(this)
                }
        }
    }

    private fun configuraRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewlista)
        recyclerView.adapter = adapter
    }
}