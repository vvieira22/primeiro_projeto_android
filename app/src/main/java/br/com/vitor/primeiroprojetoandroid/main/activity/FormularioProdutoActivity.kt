package br.com.vitor.primeiroprojetoandroid.main.activity

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.com.vitor.primeiroprojetoandroid.R
import br.com.vitor.primeiroprojetoandroid.databinding.ActivityFormularioProdutoBinding
import br.com.vitor.primeiroprojetoandroid.databinding.FormularioImagemBinding
import br.com.vitor.primeiroprojetoandroid.main.dao.ProdutosDao
import br.com.vitor.primeiroprojetoandroid.main.recyclerview.adapter.model.Produto
import coil.Coil
import coil.load
import coil.request.ImageRequest
import coil.request.SuccessResult
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioProdutoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraBotaoSalvar()

        binding.activityProdutoFormularioImagem.setOnClickListener {
            val bindingFormularioImagem = FormularioImagemBinding.inflate(layoutInflater)
            bindingFormularioImagem.botaoCarregar.setOnClickListener {
                val url = bindingFormularioImagem.formularioImagemUrl.text.toString()
                bindingFormularioImagem.formularioImageView.load(url)
            }
            AlertDialog.Builder(this)
                .setView(bindingFormularioImagem.root)
                .setPositiveButton("Adicionar") { _, _ ->
                    val url = bindingFormularioImagem.formularioImagemUrl.text.toString()
                    binding.activityProdutoFormularioImagem.load(url)
                }
                .setNegativeButton("Cancelar") { _, _ ->
                }
                .show()
        }
    }
    private fun configuraBotaoSalvar() {
        val botaoEnviar = findViewById<Button>(R.id.botaoEnviar)

        //lambda, mo paz
        botaoEnviar.setOnClickListener {
            try {
                val novoProduto = criaProduto()
                Log.d("cadastroProduto", "$novoProduto")

                val produtosDao = ProdutosDao()
                produtosDao.adicionarProduto(novoProduto)
                Log.d("cadastroProduto", "${produtosDao.buscarProdutos()}")
            } catch (ex: Exception) {
                Log.e("cadastroProduto", ex.toString())
            }

            finish() //mata activity e volta pra pilha anterior
        }
    }

    private fun criaProduto(): Produto {
        val campoNome = findViewById<EditText>(R.id.activity_forumlario_produto_nome).text.toString()
        val campoDescricao = findViewById<EditText>(R.id.activity_forumlario_produto_descricao).text.toString()
        val campoValor = findViewById<EditText>(R.id.activity_forumlario_produto_valor).text.toString()
        var mensagemErro = ""

        if (campoNome.isNullOrEmpty()) {
            mensagemErro = mensagemErro + "\nerro no campo Nome.\n"
            Log.d("cadastroProduto", campoNome)
        }
        if (campoDescricao.isNullOrEmpty()) {
            mensagemErro = mensagemErro + "erro no campo Descricao.\n"
            Log.d("cadastroProduto", campoDescricao)
        }
        if (campoValor.isNullOrEmpty()) {
            mensagemErro = mensagemErro + "erro no campo Valor.\n"
            Log.d("cadastroProduto", campoValor)
        }
        if (!mensagemErro.isNullOrEmpty())
            throw Exception(mensagemErro)

        return Produto(
            campoNome,
            campoDescricao,
            BigDecimal(campoValor)
        )
    }
}