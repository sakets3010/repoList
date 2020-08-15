package com.example.airinfo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.airinfo.databinding.FragmentFlightDetailBinding
import kotlinx.android.synthetic.main.fragment_flight_detail.*
import kotlinx.android.synthetic.main.fragment_flight_detail.view.*


class FlightDetailFragment : Fragment() {
    private lateinit var binding :FragmentFlightDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_flight_detail,container,false)

        binding.searchButton.setOnClickListener {
            val keyword = binding.searchText.text.toString()
            val action = FlightDetailFragmentDirections.keywordAction(keyword)
            findNavController().navigate(action)
        }




        return binding.root
    }






}