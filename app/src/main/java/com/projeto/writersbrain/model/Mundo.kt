package com.projeto.writersbrain.model

import java.util.Date

data class Mundo (
    val id: Int = 0,
    var titulo: String,
    var descricao: String,
    var tags: MutableList<String> = mutableListOf(),
    var instrucoesIA: String,
    var dataModif: Date = Date(),
    var capitulos: MutableList<Capitulo> = mutableListOf()
) {
    val numCapitulos: Int
        get() = capitulos.size // Creio que precisará dar um get para atualizar a cada adição de capítulo

    fun criarMundo(infos: Mundo): Mundo {
        return infos
    }

    // Preciso fazer a função atualizarMundo como no diagrama, parte mais complicadinha

    fun deletarMundo(id: Int): Boolean {
        capitulos.clear() // Limpando memória
        return this.id == id
    }
}