package br.senai.sp.jandira.rickandmortyapitest.model

import com.google.gson.annotations.SerializedName

data class Character(
  val id: Int,
  val name: String,
  val status: String,
  val type: String,
  val gender: String,
  val species: String,

  @SerializedName(value = "image")
  val photo: String
)
