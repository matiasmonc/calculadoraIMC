package com.module05.calculadoraimc.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.module05.calculadoraimc.state.ImcState
import java.math.RoundingMode

class ImcViewModel: ViewModel(){

    var state by mutableStateOf(ImcState())
        private set

    fun onValue(value: String, text: String){
        when(text){
            "edad" -> state = state.copy(edad = value)
            "peso" -> state = state.copy(peso = value)
            "altura" -> state = state.copy(altura = value)
            "sexo" -> state = state.copy(sexo = value.toInt())
        }
    }

    fun calcular(){
        val resultado = state.peso.toDouble() / (state.altura.toDouble() * state.altura.toDouble())
        //state = state.copy(res = (kotlin.math.round(resultado * 100) / 100.0).toString())
        state = state.copy(res = (resultado.toBigDecimal().setScale(1, RoundingMode.HALF_UP).toDouble()).toString())
    }

}