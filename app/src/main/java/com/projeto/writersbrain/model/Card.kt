package com.projeto.writersbrain.model

data class Card(
    val id: Int = 0,
    var nome: String,
    var tipo: String,
    var sumario: String,
    var notas: String,
    var background: String,
    var descricao: String,
    var tags: MutableList<String> = mutableListOf()
) {
    fun criarCard(infos: Card): Boolean {
        return infos.nome.isNotBlank()
    }

    // Faltando a função atualizarCard, provavelmente parecido com atualizarMundo

    fun deletarCard(id: Int): Boolean {
        return this.id == id
    }
}