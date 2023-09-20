package br.com.vitor.primeiroprojetoandroid.main.activity

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.vitor.primeiroprojetoandroid.R
import br.com.vitor.primeiroprojetoandroid.databinding.ActivityFormularioProdutoBinding
import br.com.vitor.primeiroprojetoandroid.main.dao.ProdutosDao
import br.com.vitor.primeiroprojetoandroid.main.recyclerview.adapter.model.Produto
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        configuraBotaoSalvar()
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
        //modo tryhard
//        botaoEnviar.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(p0: View?) {
//                val campoNome = findViewById<EditText>(R.id.campoNome)
//                Log.d("cadastro", campoNome.text.toString())
//            }
//        })
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