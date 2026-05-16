package com.projeto.writersbrain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "capitulos",
    foreignKeys = [ForeignKey(
        entity = Mundo::class,
        parentColumns = ["id"],
        childColumns = ["mundoId"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index("mundoId")]
    )
data class Capitulo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var mundoId: Int, // Chave estrangeira que indica de qual mundo o Capitulo pertence
    var numCap: Int,
    var tituloCap: String,
    var conteudo: String = "",
    var readMode: Boolean = false
) {
    val wordCount: Int
        get() = conteudo
            .trim()
            .split("\\s+".toRegex())
            .filter { it.isNotBlank() }
            .size
    
    fun atualizarTitulo(titulo: String): Boolean {
        tituloCap = titulo
        return true
    }
}