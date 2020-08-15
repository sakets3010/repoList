package com.example.airinfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.airinfo.databinding.FragmentSearchBinding
import com.example.airinfo.network.Repos
import kotlinx.android.synthetic.main.fragment_search.*
import layout.listAdapter

class SearchFragment : Fragment() {
    private lateinit var binding:FragmentSearchBinding
    private lateinit var viewmodel: SearchFragmentViewmodel
    private var mRepos: MutableList<Repos> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args: SearchFragmentArgs by navArgs()
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_search,container,false)

        viewmodel = ViewModelProvider(this).get(SearchFragmentViewmodel::class.java)
        val key = args.keyword

        viewmodel.getRepo(key).observe(viewLifecycleOwner, Observer { repo->
             binding.repolistRecycler.apply {
                 adapter = listAdapter(repo)
             }
        })
        return binding.root
    }


}