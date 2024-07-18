package com.example.myfirstappkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstappkotlin.dao.PessoaDAO

import com.example.myfirstappkotlin.ui.FormularioCadastroPessoaActivity
import com.example.myfirstappkotlin.ui.adapters.ListPessoasAdapter
import com.example.myfirstappkotlin.ui.adapters.ListProductsAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        //Festa de boas-vindas: Criacao da Activity, recomenda Iniciar variaveis, objetos e listener no onCreate
        super.onCreate(savedInstanceState)

        Log.i("Ciclo.MainActivity", "onCreate: Festa de boas-vindas")
    }

    override fun onStart() {
        //Hora do show: Chamado quando a Activity se torna visível para o usuário
        // Iniciar animações, carregar dados e preparar tudo para a interação com o usuário
        super.onStart()

        Log.i("Ciclo.MainActivity", "onStart:Hora do show - Activity Visivel")
    }

    override fun onResume() {
        //Aplausos : Activity totalmente interativa para o usuário
        // Activity responde aos toques, clicks e outros eventos do usuário
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

        Log.i("Ciclo.MainActivity", "onResume: Aplausos - Activity totalmente interativa ")
    }

    override fun onPause() {
        //Luzes piscando:  Activity perde o foco do usuário, mas ainda está visível na tela
        //Deve pausar animações, salvar o estado da Activity e liberar recursos
        super.onPause()

        Log.i("Ciclo.MainActivity", "onPause: Luzes piscando - Activity sem foco")
    }

    override fun onStop() {
        // Fechando as cortinas: Activity se torna totalmente invisível para o usuário
        // Liberar todos os recursos utilizados pela Activity, como conexões com bancos de dados
        super.onStop()

        Log.i("Ciclo.MainActivity", "onStop: Fechando as cortinas - Activity Invisivel")
    }

    override fun onRestart() {
        //Bis!:Activity volta a ter foco depois de estar em segundo plano
        //Restaurar o estado da Activity e reiniciar as tarefas que foram pausadas no método onPause().
        super.onRestart()

        Log.i("Ciclo.MainActivity", "onRestart: Bis - Activity Volta o Foco")
    }

    override fun onDestroy() {
        // Adeus! Activity é completamente destruída e removida da memória
        // Liberar todos os recursos restantes da Activity e realizar as últimas tarefas de limpeza.
        super.onDestroy()
        Log.i("Ciclo.MainActivity", "onDestroy: Adeus - Activity Destruida")
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