package com.module05.calculadoraimc.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.module05.calculadoraimc.components.Boton
import com.module05.calculadoraimc.components.Espacio
import com.module05.calculadoraimc.components.Inputs
import com.module05.calculadoraimc.components.MultiButtonSegmentado
import com.module05.calculadoraimc.components.Texto
import java.math.RoundingMode

@Composable
fun HomeView(paddingValues: PaddingValues){

    var edad by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }

    val sexo = remember { mutableStateOf(0) }

    var res = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Texto(texto = "Calculadora de IMC", size = 30)
        Espacio(20.dp)
        MultiButtonSegmentado(sexo)
        Inputs("Edad", { edad = it }, edad )
        Espacio(10.dp)
        Inputs("Peso (Kg)", { peso = it }, peso )
        Espacio(10.dp)
        Inputs("Altura (cm)", { altura = it }, altura )
        Espacio(20.dp)
        Boton(calcular = { realizarCalculo(peso, altura, res) })
        Espacio(size = 30.dp)
        Texto(texto = res.value, size = 40)
    }
}

fun realizarCalculo(peso: String, altura: String, res: MutableState<String>){
    val resultado = "${peso.toDouble() / (altura.toDouble() * altura.toDouble())}"
    res.value = (resultado.toBigDecimal().setScale(1, RoundingMode.HALF_UP).toDouble()).toString();
}