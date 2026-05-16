package com.projeto.writersbrain.banco

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.projeto.writersbrain.model.Capitulo
import com.projeto.writersbrain.model.Card
import com.projeto.writersbrain.model.Mundo

@Database(entities = [Mundo::class, Card::class, Capitulo::class], version = 1, exportSchema = false) // Trazendo todos os dados do banco para o app.
@TypeConverters(Converters::class) // Convertendo dados próprios para que o Room entenda
abstract class AppBanco : RoomDatabase() {

    // Interfaces de acesso ao banco
    abstract fun mundoDao(): MundoDao
    abstract fun cardDao(): CardDao
    abstract fun capituloDao(): CapituloDao

    companion object {
        @Volatile
        private var instance: AppBanco? = null

        fun getInstance(context: Context): AppBanco{ // Instancia o banco de dados
            return instance ?: synchronized(this){ // Apenas um banco sendo criado em uma thread
                Room.databaseBuilder(
                    context.applicationContext,
                    AppBanco::class.java,
                    "writersbrain_db", // Nome do banco
                ).build().also { instance = it } // Aqui constrói e salva a instância criada
            }
        }
    }
}