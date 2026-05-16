package com.projeto.writersbrain.banco
import androidx.room.*
import com.projeto.writersbrain.model.Mundo

@Dao
interface MundoDao {
    @Insert
    suspend fun inserir(mundo: Mundo): Long

    @Update
    suspend fun atualizar(mundo: Mundo)

    @Delete
    suspend fun deletar(mundo: Mundo)

    @Query("SELECT * FROM mundos") // Não está otimizado, mas funciona por agora.
    suspend fun listarTodos(): List<Mundo>

    @Query("SELECT * FROM mundos WHERE id = :id")
    suspend fun buscarPorId(id: Int): Mundo?
}