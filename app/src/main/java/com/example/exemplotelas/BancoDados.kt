package com.example.exemplotelas

class BancoDados {
    var grupos: MutableList<Grupo> = mutableListOf<Grupo>()
    fun addGrupo(grupo: Grupo){
        grupos.add(grupo)
    }
}