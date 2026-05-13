package com.projeto.writersbrain.model

data class Capitulo(
    val id: Int = 0,
    var numCap: Int,
    var tituloCap: String,
    var conteudo: String = "",
    var readMode: Boolean = false,
    var cards: MutableList<Card> = mutableListOf()
) {
    fun criarCapitulo(titulo: String): Boolean {
        tituloCap = titulo
        return true
    }

    fun atualizarTitulo(titulo: String): Boolean {
        tituloCap = titulo
        return true
    }

    fun deletarCapitulo(id: Int): Boolean {
        return this.id == id
    }
}