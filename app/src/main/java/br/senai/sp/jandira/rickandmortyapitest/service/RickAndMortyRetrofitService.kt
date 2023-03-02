package br.senai.sp.jandira.rickandmortyapitest.service

import br.senai.sp.jandira.rickandmortyapitest.model.Character
import br.senai.sp.jandira.rickandmortyapitest.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyRetrofitService {
  @GET("character")
  fun getAllCharacters(): Call<List<Character>>

  @GET("character/{id}")
  fun getCharacter(@Path("id") id: Int): Call<Character>

  @GET("character")
  fun getCharacterByName(@Query("name") name: String): Call<ApiResponse>
}
