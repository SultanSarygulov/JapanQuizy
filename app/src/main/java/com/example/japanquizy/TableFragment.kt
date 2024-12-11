package com.example.japanquizy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.japanquizy.databinding.FragmentTableBinding

class TableFragment : Fragment() {



    private lateinit var binding: FragmentTableBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentTableBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecycleView()
    }

    private fun setRecycleView() {
        binding.kanasList.adapter = KanaAdapter(kanasList)
    }


}