package com.tomaslab.weatherapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.tomaslab.wetherapp.R
import com.tomaslab.wetherapp.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)


    }

}