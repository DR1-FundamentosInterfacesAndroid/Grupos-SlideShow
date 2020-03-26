package com.example.exemplotelas.ui.slideshow

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exemplotelas.BancoDadosModel
import com.example.exemplotelas.Grupo
import com.example.exemplotelas.R
import kotlinx.android.synthetic.main.fragment_slide_line.view.*

class SlideshowFragment : Fragment() {

    private lateinit var bancoModel: BancoDadosModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)
        val listagemGrupos: RecyclerView = root.findViewById(R.id.listagem)

        // Buscando o Model da Activity...
        bancoModel = activity?.run {
            ViewModelProviders.of(this)[BancoDadosModel::class.java]
        } ?: throw Exception("Invalid Activity")

        bancoModel.banco.observe(viewLifecycleOwner,Observer{
            listagemGrupos.layoutManager = LinearLayoutManager(activity!!.baseContext)
            listagemGrupos.adapter = GrupoListAdapter(it.grupos,activity!!.baseContext,activity!!.findNavController(R.id.nav_host_fragment))
        })

        return root
    }

    class GrupoListAdapter(private val grupos: List<Grupo>,
                           private val context: Context,
                           private val navControl: NavController
    ) : RecyclerView.Adapter<GrupoHolder>() {

        override fun onBindViewHolder(holder: GrupoHolder, position: Int) {
            val grupo = grupos[position]
            holder.nomeGrupo.text = grupo.nome
            holder.contagem.progress = grupo.frases.size

            holder.nomeGrupo.setOnClickListener { view ->
                var frases: List<String> = grupo.frases
                var bundle = bundleOf("frases" to frases)
                navControl.navigate(R.id.frasesFragment, bundle)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GrupoHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.fragment_slide_line, parent, false)
            return GrupoHolder(view)
        }

        override fun getItemCount(): Int {
            return grupos.size
        }
    }

    class GrupoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeGrupo: TextView = itemView.textView5
        val contagem: ProgressBar = itemView.progressBar
    }
}

