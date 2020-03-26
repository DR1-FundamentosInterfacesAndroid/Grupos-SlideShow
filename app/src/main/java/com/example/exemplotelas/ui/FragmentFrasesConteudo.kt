package com.example.exemplotelas.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.exemplotelas.R
import kotlinx.android.synthetic.main.fragment_frases_conteudo.*

class FragmentFrasesConteudo : Fragment() {

    private val ARG_PARAM1 = "frase"

    private var frase: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            frase = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_frases_conteudo, container, false).apply {
            textoFrase.setText(frase)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            FragmentFrasesConteudo().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }

}
