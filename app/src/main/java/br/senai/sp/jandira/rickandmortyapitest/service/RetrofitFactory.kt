package br.senai.sp.jandira.rickandmortyapitest.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
  val baseUrl = "https://rickandmortyapi.com/api/"
  val retroFitFactory = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()

  fun retrofitservice(): RickAndMortyRetrofitService {
    return retroFitFactory.create(RickAndMortyRetrofitService::class.java)
  }
}
