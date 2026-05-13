package com.projeto.writersbrain

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.projeto.writersbrain.model.Mundo

class NovoProjetoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_novo_projeto)

        val buttonCriar = findViewById<FloatingActionButton>(R.id.fabCriar)

        val titulo = findViewById<TextView>(R.id.etTitulo)
        val descricao = findViewById<TextView>(R.id.etDescricao)
        val tags = findViewById<TextView>(R.id.etTags)
        val instrucoes = findViewById<TextView>(R.id.etInstrucoes)

        buttonCriar.setOnClickListener {
            finish()
        }

    }
}