package com.projeto.writersbrain.banco

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.projeto.writersbrain.model.Card

@Dao
interface CardDao {
    @Insert
    suspend fun inserir(card: Card): Long

    @Update
    suspend fun atualizar(card: Card)

    @Delete
    suspend fun deletar(card: Card)

    @Query("SELECT * FROM cards WHERE mundoId = :mundoId") // Busca por cards de um mundo, para aparecer na página de cards quando for implementar
    suspend fun listarPorMundo(mundoId: Int): List<Card>

    @Query("SELECT * FROM cards WHERE mundoId = :mundoId AND tipo = :tipo") // Filtro por tipo de card
    suspend fun listarPorTipo(mundoId: Int, tipo: String): List<Card>

    @Query("SELECT * FROM cards WHERE id = :id")
    suspend fun buscarPorId(id: Int): Card?

    @Query("SELECT * FROM cards WHERE tags LIKE '%' || :tag || '%'")
    suspend fun buscarPorTag(tag: String): List<Card>
}