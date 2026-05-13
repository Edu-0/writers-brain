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

    val wordCount: Int
        get() = capitulos.sumOf { capitulo ->
            capitulo.conteudo
                .trim()
                .split("\\s+".toRegex())
                .filter { it.isNotBlank() }
                .size
        }

    val numCapitulos: Int
        get() = capitulos.size // Creio que precisará dar um get para atualizar a cada adição de capítulo

    fun criarMundo(infos: Mundo): Mundo {
        return infos
    }

    fun atualizarMundo(
        titulo: String? = null,
        descricao: String? = null,
        tags: MutableList<String>? = null,
        instrucoesIA: String? = null
    ): Boolean {

        titulo?.let {
            this.titulo = it // It é o nome do padrão do parâmetro dentro do let
        }
        descricao?.let {
            this.descricao = it
        }
        tags?.let {
            this.tags = it
        }
        instrucoesIA?.let {
            this.instrucoesIA = it
        }

        dataModif = Date()

        return true
    }

    fun deletarMundo(id: Int): Boolean {
        capitulos.clear() // Limpando memória
        return this.id == id
    }
}