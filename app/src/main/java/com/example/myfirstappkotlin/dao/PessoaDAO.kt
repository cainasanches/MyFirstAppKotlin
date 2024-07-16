package com.example.myfirstappkotlin.dao

import com.example.myfirstappkotlin.model.Pessoa

class PessoaDAO {

    fun adicionaPessoa(pessoaDAO: Pessoa){ pessoasList.add(pessoaDAO) }

    fun buscaTodasPessoas() : MutableList<Pessoa> { return pessoasList
    }

    companion object {
        val pessoasList = mutableListOf<Pessoa>()
    }
}