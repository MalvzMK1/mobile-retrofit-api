package br.senai.sp.jandira.rickandmortyapitest.service

import android.util.Log
import br.senai.sp.jandira.rickandmortyapitest.model.ApiResponse
import br.senai.sp.jandira.rickandmortyapitest.model.Character
import kotlinx.coroutines.awaitAll
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun searchCharacter(name: String, onComplete: (String) -> Unit): String {
  val call = RetrofitFactory()
    .retrofitservice()
    .getCharacterByName(name)

  var result = ""

  call.enqueue(object : Callback<ApiResponse> {

    override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
      result = response.body()!!.results[0].name
      onComplete.invoke(result)
    }

    override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
      TODO("Not yet implemented")
    }
  })

  return result
}