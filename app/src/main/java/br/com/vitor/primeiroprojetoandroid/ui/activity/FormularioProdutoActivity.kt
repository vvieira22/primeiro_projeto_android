package br.com.vitor.primeiroprojetoandroid.ui.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import br.com.vitor.primeiroprojetoandroid.R

class FormularioProdutoActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_produto)


        val botaoEnviar = findViewById<Button>(R.id.botaoEnviar)

        //lambda, mo paz
        botaoEnviar.setOnClickListener {
            val campoNome = findViewById<EditText>(R.id.campoNome)
            Log.d("cadastro", campoNome.text.toString())
        }

        //modo tryhard
//        botaoEnviar.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(p0: View?) {
//                val campoNome = findViewById<EditText>(R.id.campoNome)
//                Log.d("cadastro", campoNome.text.toString())
//            }
//        })
    }


}