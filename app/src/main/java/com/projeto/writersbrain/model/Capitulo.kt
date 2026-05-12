package com.projeto.writersbrain.model

data class Capitulo(
    val id: Int = 0,
    var numCap: Int,
    var tituloCap: String,
    var readMode: Boolean = false,
    var cards: MutableList<Card> = mutableListOf()
) {
    // val wordCount: Int get()... Depois tenho que ver como faço para pegar o número de caracteres no capítulo, mas isso para mais tarde

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