package com.example.app.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun Formulario(){

    var nombre by remember { mutableStateOf("")}
    var correo by remember { mutableStateOf("")}
    var edad by remember { mutableStateOf("")}
    var modal by remember { mutableStateOf(false)}

    Column (
        modifier= Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Nombre")
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Ingrese su nombre")},
            modifier = Modifier.Companion.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Text("Correo")
        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Ingrese su correo")},
            modifier = Modifier.Companion.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Text("Edad")
        OutlinedTextField(
            value = edad,
            onValueChange = { edad = it.filter { char -> char.isDigit()} },
            label = { Text("Ingrese su edad")},
            modifier = Modifier.Companion.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(onClick = { modal = true }) {
            Text(text = "Enviar")
        }

        if(modal){
            AlertDialog(
                onDismissRequest = {  },
                title = { Text("Mensaje")},
                text = { Text("Hola")},
                confirmButton = {
                    Button(onClick = { modal = false }) {
                        Text("Ok")
                    }
                }
            )
        }
    }
}