package br.com.vitor.primeiroprojetoandroid.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.vitor.primeiroprojetoandroid.R
import br.com.vitor.primeiroprojetoandroid.ui.recyclerview.adapter.model.Produto
import org.w3c.dom.Text

class ListaProdutosAdpter(
    private val context: Context,
    private val produtos : List<Produto>

) : RecyclerView.Adapter<ListaProdutosAdpter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(produto: Produto) {

//            itemView é o proprio valor de view ali em baixo declarado.
            val nome = itemView.findViewById<TextView>(R.id.nome)
            nome.text = produto.nome

            val descricao = itemView.findViewById<TextView>(R.id.descricao)
            descricao.text = produto.descricao

            val valor = itemView.findViewById<TextView>(R.id.preco)
            valor.text = produto.preco.toPlainString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //view exclusiva a partir de um layout.
        // = inflar view.
        val inflater = LayoutInflater.from(context)

        //layout que voce quer no caso = produto_item
        val view = inflater.inflate(R.layout.produto_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }

    //funcao que faz o return, forma reduzida
    override fun getItemCount(): Int = produtos.size

}
