package com.example.exemplotelas.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager

import com.example.exemplotelas.R


class FrasesFragment : Fragment() {

    private lateinit var frases: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        frases = arguments?.get("frases") as List<String>
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_frases, container, false)
        val viewPager: ViewPager = root.findViewById(R.id.fraseViewPager)
        viewPager.adapter =
            FrasesAdapter(activity!!.supportFragmentManager, frases)
        return root
    }



}
