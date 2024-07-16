package com.example.myfirstappkotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstappkotlin.dao.PessoaDAO

import com.example.myfirstappkotlin.ui.FormularioCadastroPessoaActivity
import com.example.myfirstappkotlin.ui.adapters.ListPessoasAdapter
import com.example.myfirstappkotlin.ui.adapters.ListProductsAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()

        val dao = PessoaDAO()

        //***Usar binding caso nao existe um adapter para conectar com a view

        //var binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        // val viewMain = binding.root
        //setContentView(viewMain)

        //Conecta com o Adapter de Produtos
        val recyclerViewPessoas = findViewById<RecyclerView>(R.id.recyclerViewPessoa)

        //Atualiza recyclerView com os dados do adapter
        recyclerViewPessoas.adapter = ListPessoasAdapter(
            this, dao.buscaTodasPessoas()
        )

        val fabAddPessoa = findViewById<FloatingActionButton>(R.id.fab_add_pessoa)
        fabAddPessoa.setOnClickListener {
            startActivity(Intent(this, FormularioCadastroPessoaActivity::class.java))
        }
    }

    //val recycledViewProdutos = findViewById<RecyclerView>(R.id.recyclerViewProdutos)

//        recycledViewProdutos.adapter = ListProductsAdapter(
//            this, listOf(
//                Product(
//                    title = "Cesta de Bananas",
//                    description = "Banana NANICA da Terra",
//                    valor = 3.50
//                ),
//                Product(
//                    title = "Cesta de Goiabas",
//                    description = "Goiaba deliciosa",
//                    valor = 10.00
//                ),
//                Product(
//                    title = "Melancia",
//                    description = "Olha a Mais doce da cidade",
//                    valor = 7.50
//                ),
//            )
//        )

}