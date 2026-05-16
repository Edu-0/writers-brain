package com.projeto.writersbrain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "mundos")
data class Mundo (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var titulo: String,
    var descricao: String,
    var tags: String = "",
    var instrucoesIA: String,
    var dataModif: Date = Date()
) {
    fun atualizarMundo(
        titulo: String? = null,
        descricao: String? = null,
        tags: String? = null,
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

    fun getTagsLista(): MutableList<String> = // Como o banco não permite guardar listas, preciso fazer alguns helpers para lidar com tags
        if (tags.isBlank()) mutableListOf()
        else tags.split(",").map { it.trim() }.toMutableList()

    fun setTagsLista(lista: MutableList<String>) {
        tags = lista.joinToString(",")
    }
}