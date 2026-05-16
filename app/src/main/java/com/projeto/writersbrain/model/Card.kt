package com.projeto.writersbrain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "cards",
    foreignKeys = [ForeignKey(
        entity = Mundo::class,
        parentColumns = ["id"],
        childColumns = ["mundoId"],
        onDelete = ForeignKey.CASCADE
    )], indices = [Index("mundoId")])
data class Card(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var mundoId: Int,
    var nome: String,
    var tipo: String,
    var sumario: String,
    var notas: String,
    var background: String,
    var descricao: String,
    var tags: String = ""
) {
    fun getTagsLista(): MutableList<String> =
        if (tags.isBlank()) mutableListOf()
        else tags.split(",").map { it.trim() }.toMutableList()

    fun atualizarCard(
        nome: String? = null,
        tipo: String? = null,
        sumario: String? = null,
        notas: String? = null,
        background: String? = null,
        descricao: String? = null,
        tags: String? = null
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
}