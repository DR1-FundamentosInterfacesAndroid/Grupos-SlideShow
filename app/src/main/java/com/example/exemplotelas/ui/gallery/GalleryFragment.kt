package com.example.exemplotelas.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.exemplotelas.BancoDadosModel
import com.example.exemplotelas.Grupo
import com.example.exemplotelas.R
import kotlinx.android.synthetic.main.fragment_gallery.*

class GalleryFragment : Fragment() {

    private lateinit var bancoModel: BancoDadosModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        val spinGrupos: Spinner = root.findViewById(R.id.spinner)
        val textoFrase: EditText = root.findViewById(R.id.editText2)
        val button: Button = root.findViewById(R.id.button2)

        // Buscando o Model da Activity...
        bancoModel = activity?.run {
            ViewModelProviders.of(this)[BancoDadosModel::class.java]
        } ?: throw Exception("Invalid Activity")

        bancoModel.banco.observe(viewLifecycleOwner,Observer{
            val aa = ArrayAdapter<Grupo>(activity!!.baseContext, android.R.layout.simple_spinner_item, it.grupos)
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinGrupos.setAdapter(aa)
        })

        // Adicionando um Texto
        button.setOnClickListener {
            var frase: String = textoFrase.text.toString()
            var grupo: Grupo = spinner.selectedItem as Grupo
            grupo.addFrase(frase)
            textoFrase.setText("")
        }

        return root
    }
}

