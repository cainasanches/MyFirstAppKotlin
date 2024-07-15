package com.example.myfirstappkotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstappkotlin.databinding.ActivityMainBinding
import com.example.myfirstappkotlin.model.Pessoa
import com.example.myfirstappkotlin.model.Product
import com.example.myfirstappkotlin.ui.FormularioCadastroPessoaActivity
import com.example.myfirstappkotlin.ui.adapters.ListPessoasAdapter
import com.example.myfirstappkotlin.ui.adapters.ListProductsAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val viewMain = binding.root
        setContentView(viewMain)

        //Conecta com o Adapter de Produtos
        val recycledViewProdutos = findViewById<RecyclerView>(R.id.recyclerViewProdutos)
        val recyclerViewPessoas = findViewById<RecyclerView>(R.id.recyclerViewPessoa)

        recycledViewProdutos.adapter = ListProductsAdapter(
            this, listOf(
                Product(
                    title = "Cesta de Bananas",
                    description = "Banana NANICA da Terra",
                    valor = 3.50
                ),
                Product(
                    title = "Cesta de Goiabas",
                    description = "Goiaba deliciosa",
                    valor = 10.00
                ),
                Product(
                    title = "Melancia",
                    description = "Olha a Mais doce da cidade",
                    valor = 7.50
                ),
            )
        )

        recyclerViewPessoas.adapter = ListPessoasAdapter(
            this,
            listOf(
                Pessoa("CAINA_TESTE1", "caina.sanches@teste.123", "1235468798", "30 Anos"),
                Pessoa("JULIA_TESTE2", "ste.123", "54", "54 Anos"),
                Pessoa("CYNTIA_TESTE1", "cinthia.3", "558", "15 Anos")
            )
        )

        val fabAddPessoa = findViewById<FloatingActionButton>(R.id.fab_add_pessoa)
        fabAddPessoa.setOnClickListener {
            startActivity(Intent(this, FormularioCadastroPessoaActivity::class.java))
        }
    }
}