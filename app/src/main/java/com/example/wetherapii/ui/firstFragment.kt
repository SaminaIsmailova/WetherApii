package com.example.wetherapii.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class FirstFragment : Fragment(){
    private lateinit var binding: FragmentFirstBinding
    val lon=74.6037
    val lat=42.876
    val units="metric"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding= FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }
    private fun initClicker() {
        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.resultFragment, bundleOf("keyLon" to lon,"keyLat" to lat,"keyUnits" to units ))
        }
    }
}