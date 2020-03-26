package com.example.exemplotelas.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FrasesAdapter(fm: FragmentManager, var frases: List<String>):
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    init{
        fm?.fragments?.clear()
    }

    override fun getItem(position: Int): Fragment {
        return FragmentFrasesConteudo.newInstance(frases[position])
    }

    override fun getCount() = frases.size
}