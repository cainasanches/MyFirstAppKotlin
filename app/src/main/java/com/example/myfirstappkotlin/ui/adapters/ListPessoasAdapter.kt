package com.example.myfirstappkotlin.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstappkotlin.R
import com.example.myfirstappkotlin.model.Pessoa

class ListPessoasAdapter(
    val context: Context,
    private val pessoas: List<Pessoa>
) : RecyclerView.Adapter<ListPessoasAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindView(pessoa: Pessoa) {
            val nomePessoa = itemView.findViewById<TextView>(R.id.name_text)
            val emailPessoa = itemView.findViewById<TextView>(R.id.emailAddress_editText)
            val telefonePessoa = itemView.findViewById<TextView>(R.id.phone_editText)
            val descricao = itemView.findViewById<TextView>(R.id.descricao)

            nomePessoa.text = pessoa.nome
            emailPessoa.text = pessoa.email
            telefonePessoa.text = pessoa.telefone
            descricao.text = pessoa.descricao
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Necessario inflar o Layout para a recyclerView
        val view = LayoutInflater.from(context).inflate(R.layout.pessoa_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = pessoas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Realizamos o bind dos Itens da View
        val pessoa = pessoas[position]
        holder.bindView(pessoa)
    }

}