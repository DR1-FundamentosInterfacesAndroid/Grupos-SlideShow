package com.example.exemplotelas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BancoDadosModel : ViewModel() {

    private val _banco = MutableLiveData<BancoDados>().apply {
        value = BancoDados()
    }
    val banco: LiveData<BancoDados> = _banco

    fun addGrupo(grupo: Grupo){
        _banco.apply{
            value!!.addGrupo(grupo)
        }
    }
}
