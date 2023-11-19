package com.example.myfirstappkotlin

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstappkotlin.databinding.ActivityMainBinding
import com.example.myfirstappkotlin.model.Product
import com.example.myfirstappkotlin.ui.adapters.ListProductsAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var clear: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val viewMain = binding.root
        setContentView(viewMain)

        val title_product = findViewById<TextView>(R.id.title_product)
        val description_product = findViewById<TextView>(R.id.description_product)
        val value_product = findViewById<TextView>(R.id.value_product)

        val recycledView = findViewById<RecyclerView>(R.id.recyclerView)
       //recycledView.adapter = ListProductsAdapter()



        binding.button1.setOnClickListener{

            if (!clear){
                Toast.makeText(this,"Teste Botão NOVO",Toast.LENGTH_LONG).show()
                binding.button1.text = "CLEAR"
                binding.button1.setBackgroundColor(getColor(R.color.white))
                binding.button1.setTextColor(getColor(R.color.black))

                title_product.text = "Cesta de Frutas"
                description_product.text = "Escolha uma Fruta"
                value_product.text = "R$ 1.500"

                clear = true
            }
            else{
                binding.button1.text = "INICIAR"
                binding.button1.setBackgroundColor(getColor(R.color.black))
                binding.button1.setTextColor(getColor(R.color.white))

                title_product.text = "Informe um Titulo"
                description_product.text = "Informe uma Descricao"
                value_product.text = "Informe um valor"

                clear = false
            }
        }
    }
}