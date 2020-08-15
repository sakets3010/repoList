package com.example.airinfo.network

import retrofit2.converter.gson.GsonConverterFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

private const val CURRENT_BASE_URL = "https://api.github.com/search/"



private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(CURRENT_BASE_URL)
    .build()

interface ApiService {
    @GET("repositories")
    fun getGitRepo(
        @Query("q") keyword: String,
        @Query("sort") sort: String = "stars",
        @Query("order") order: String = "desc"
    ): Deferred<SearchResult>
}

object RepoApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}