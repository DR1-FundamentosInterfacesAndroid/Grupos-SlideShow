package com.example.exemplotelas

class Grupo(val nome: String) {
    var frases: MutableList<String> = mutableListOf<String>()
    fun addFrase(frase: String){
        frases.add(frase)
    }

    override fun toString(): String {
        return nome
    }
}
