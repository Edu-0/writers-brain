package com.projeto.writersbrain.banco

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.projeto.writersbrain.model.Capitulo

@Dao
interface CapituloDao {
    @Insert
    suspend fun inserir(capitulo: Capitulo): Long

    @Update
    suspend fun atualizar(capitulo: Capitulo)

    @Delete
    suspend fun deletar(capitulo: Capitulo)

    @Query("SELECT * FROM capitulos WHERE mundoId = :mundoId ORDER BY numCap ASC") // Busca só os capítulos de um mundo específico, para aparecer na barra lateral posteriormente
    suspend fun listarPorMundo(mundoId: Int): List<Capitulo>

    @Query("SELECT * FROM capitulos WHERE id = :id")
    suspend fun buscarPorId(id: Int): Capitulo?
}