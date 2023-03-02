package br.senai.sp.jandira.rickandmortyapitest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.rickandmortyapitest.service.RetrofitFactory
import br.senai.sp.jandira.rickandmortyapitest.ui.theme.RickAndMortyAPITESTTheme
import br.senai.sp.jandira.rickandmortyapitest.model.Character
import br.senai.sp.jandira.rickandmortyapitest.service.searchCharacter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      RickAndMortyAPITESTTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
          CharactersList()
        }
      }
    }
  }
}

@Composable
fun CharactersList() {
  var characterNameState by rememberSaveable {
    mutableStateOf("")
  }

  var resultState by rememberSaveable {
    mutableStateOf("")
  }

  Column(
    modifier = Modifier.fillMaxSize().padding(12.dp)
  ) {
    OutlinedTextField(
      value = characterNameState,
      onValueChange = { characterNameState = it },
      modifier = Modifier.fillMaxWidth(),
      label = { Text("Digite o nome do personagem") }
    )
    Button(
      onClick = {
        resultState = searchCharacter(characterNameState) {
          resultState = it
        }
      },
      modifier = Modifier.fillMaxWidth()
    ) {
      Text(text = "Buscar", fontSize = 18.sp)
    }
    Text(text = resultState)
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  RickAndMortyAPITESTTheme {

  }
}