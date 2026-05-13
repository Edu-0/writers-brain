package com.projeto.writersbrain.model

data class Card(
    val id: Int = 0,
    var nome: String,
    var tipo: String,
    var sumario: String,
    var notas: String,
    var background: String,
    var descricao: String,
    var tags: MutableList<String> = mutableListOf()
) {
    fun criarCard(infos: Card): Boolean {
        return infos.nome.isNotBlank()
    }

    fun atualizarCard(
        nome: String? = null,
        tipo: String? = null,
        sumario: String? = null,
        notas: String? = null,
        background: String? = null,
        descricao: String? = null,
        tags: MutableList<String>? = null
    ): Boolean {

        nome?.let {
            this.nome = it
        }
        tipo?.let {
            this.tipo = it
        }
        sumario?.let {
            this.sumario = it
        }
        notas?.let {
            this.notas = it
        }
        background?.let {
            this.background = it
        }
        descricao?.let {
            this.descricao = it
        }
        tags?.let {
            this.tags = it
        }

        return true
    }

    fun deletarCard(id: Int): Boolean {
        return this.id == id
    }
}