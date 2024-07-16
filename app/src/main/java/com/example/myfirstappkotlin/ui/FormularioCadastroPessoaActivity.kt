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
        setContentView(R.layout.activity_form_cadastro_pessoa)

        val btn_salvar =  findViewById<Button>(R.id.button_salvar)

        btn_salvar.setOnClickListener {
            val nome = findViewById<EditText>(R.id.editTextNome).text.toString()
            val email = findViewById<EditText>(R.id.editTextEmail).text.toString()
            val telefone = findViewById<EditText>(R.id.editTextPhone).text.toString()
            val descricao = findViewById<EditText>(R.id.editTextDescricao).text.toString()

            val nova_pessoa = Pessoa(nome = nome, email = email, telefone = telefone, descricao = descricao)

            Log.i("FormularioCadastroPessoa", "$nova_pessoa")

            PessoaDAO().adicionaPessoa(nova_pessoa)

            Log.i("FormularioCadastroPessoa", "onCreate: Pessoa cadastrada com sucesso")

            finish()
        }
    }
}