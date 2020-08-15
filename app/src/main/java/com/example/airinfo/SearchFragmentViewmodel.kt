package com.example.airinfo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.navArgs
import com.example.airinfo.network.RepoApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class SearchFragmentViewmodel : ViewModel() {



    private var _repo:MutableLiveData<List<com.example.airinfo.network.Repo>> = MutableLiveData<List<com.example.airinfo.network.Repo>>()

    fun getRepo(keyword:String): LiveData<List<com.example.airinfo.network.Repo>> {
        Log.d("tag","keyword:${keyword}")
        val reposDeferred = RepoApi.retrofitService.getGitRepo(keyword)
        CoroutineScope(Dispatchers.Main).launch {
            try{
                val repos  = reposDeferred.await()
                _repo.value = repos.items

            }
            catch (e:Exception){
                e.printStackTrace()
            }
        }
        return _repo
    }

}