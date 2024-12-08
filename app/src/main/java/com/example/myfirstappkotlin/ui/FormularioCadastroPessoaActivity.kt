package com.example.myfirstappkotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.myfirstappkotlin.R
import com.example.myfirstappkotlin.dao.PessoaDAO
import com.example.myfirstappkotlin.model.Pessoa


class FormularioCadastroPessoaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("CicloDeVida.MainActivity", "onCreate: Festa de boas-vindas")

        setContentView(R.layout.activity_form_cadastro_pessoa)
        configBtnSalvar()

        Log.i("FormularioCadastroPessoa", "onCreate: Pessoa cadastrada com sucesso")
    }

    private fun configBtnSalvar() {

        val btn_salvar =  findViewById<Button>(R.id.activity_form_cadastro_pessoa_nome_btnSalvar)
        val dao = PessoaDAO()

        btn_salvar.setOnClickListener {
           val novaPessoa =  criarNovaPessoa()
            dao.adicionaPessoa(novaPessoa)
            finish()
        }
    }

    private fun criarNovaPessoa(): Pessoa {

        val nome = findViewById<EditText>(R.id.activity_form_cadastro_pessoa_nome).text.toString()
        val email = findViewById<EditText>(R.id.activity_form_cadastro_pessoa_email).text.toString()
        val telefone = findViewById<EditText>(R.id.activity_form_cadastro_pessoa_telefone).text.toString()
        val descricao = findViewById<EditText>(R.id.activity_form_cadastro_pessoa_descricao).text.toString()

        Log.i("FormularioCadastroPessoa", "Pessoa Criada")

        return Pessoa(nome = nome, email = email, telefone = telefone, descricao = descricao)
    }

    override fun onStart() {
        super.onStart()
        Log.i("Ciclo.FormularioCadastroPessoaActivity", "onStart:Hora do show - Activity Visivel")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Ciclo.FormularioCadastroPessoaActivity", "onResume: Aplausos - Activity totalmente interativa ")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Ciclo.FormularioCadastroPessoaActivity", "onPause: Luzes piscando - Activity sem foco")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Ciclo.FormularioCadastroPessoaActivity", "onStop: Fechando as cortinas - Activity Invisivel")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Ciclo.FormularioCadastroPessoaActivity", "onRestart: Bis - Activity Volta o Foco")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Ciclo.FormularioCadastroPessoaActivity", "onDestroy: Adeus - Activity Destruida")
    }
}