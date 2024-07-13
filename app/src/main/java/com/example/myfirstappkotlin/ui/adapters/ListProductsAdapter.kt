package com.example.myfirstappkotlin.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstappkotlin.R
import com.example.myfirstappkotlin.model.Product

class ListProductsAdapter(
    val context: Context,
    private val products: List<Product>
) : RecyclerView.Adapter<ListProductsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindView(product: Product) {
            val title_product = itemView.findViewById<TextView>(R.id.title_product)
            val description_product = itemView.findViewById<TextView>(R.id.description_product)
            val value_product = itemView.findViewById<TextView>(R.id.value_product)

            title_product.text = product.title
            description_product.text = product.description
            value_product.text = product.valor.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Necessario inflar o Layout para a recyclerView
        val view = LayoutInflater.from(context).inflate(R.layout.produto_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Realizamos o bind dos Itens da View
        val product = products[position]
        holder.bindView(product)

    }

}
