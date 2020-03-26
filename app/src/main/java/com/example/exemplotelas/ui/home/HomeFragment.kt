package com.example.exemplotelas.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.exemplotelas.BancoDadosModel
import com.example.exemplotelas.Grupo
import com.example.exemplotelas.R

class HomeFragment : Fragment() {

    private lateinit var bancoModel: BancoDadosModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textoGrupo: EditText = root.findViewById(R.id.editText)
        val button: Button = root.findViewById(R.id.button)

        // Buscando o Model da Activity...
        bancoModel = activity?.run {
            ViewModelProviders.of(this)[BancoDadosModel::class.java]
        } ?: throw Exception("Invalid Activity")

        // Adicionando um Grupo
        button.setOnClickListener {
            var novoGrupo = Grupo(textoGrupo.text.toString())
            bancoModel.addGrupo(novoGrupo)
            textoGrupo.setText("")
        }

        return root
    }
}
