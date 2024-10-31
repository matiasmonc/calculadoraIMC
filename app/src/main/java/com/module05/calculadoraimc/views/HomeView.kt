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
import com.module05.calculadoraimc.components.Alert
import com.module05.calculadoraimc.components.Boton
import com.module05.calculadoraimc.components.Espacio
import com.module05.calculadoraimc.components.Inputs
import com.module05.calculadoraimc.components.MultiButtonSegmentado
import com.module05.calculadoraimc.components.Texto
import com.module05.calculadoraimc.viewmodel.ImcViewModel
import java.math.RoundingMode

@Composable
fun HomeView(paddingValues: PaddingValues, imcViewModel: ImcViewModel){

    val state = imcViewModel.state
    var showAlert by remember { mutableStateOf(false)}
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
        MultiButtonSegmentado(state.sexo) {
            index, key -> imcViewModel.onValue(index.toString(), key)
        }
        Inputs(
            label = "Edad",
            onValueChange = { imcViewModel.onValue(it, "edad") },
            value = state.edad.toString() )
        Espacio(10.dp)
        Inputs(
            label = "Peso (Kg)",
            onValueChange = { imcViewModel.onValue(it, "peso") },
            value = state.peso.toString() )
        Espacio(10.dp)
        Inputs(
            label = "Altura (cm)",
            onValueChange = { imcViewModel.onValue(it, "altura") },
            value = state.altura.toString() )
        Espacio(20.dp)
        Boton(calcular = {
            if(state.peso != "" && state.altura != "" ){
                imcViewModel.calcular()
            }else{
                showAlert = true
            }
        })
        Espacio(size = 30.dp)
        Texto(texto = state.res, size = 40)

        if(showAlert){
            Alert(
                title = "Error",
                msj = "Ingresa el Peso y al Altura",
                confirmText = "Aceptar",
                onConfirmClick = { showAlert = false },
                onDismissClick = { showAlert = false }
            )
        }
    }
}