package com.module05.calculadoraimc.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Texto(texto: String, size: Int){
    Text(text = texto, fontSize = size.sp)
}

@Composable
fun Inputs( label: String, onValueChange: (String) -> Unit, value: String){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        modifier = Modifier
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
fun Espacio(size: Dp){
    Spacer(modifier = Modifier.height(size))
}

@Composable
fun Boton(calcular: () -> Unit){
    Button(
        onClick = { calcular() },
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text("Calcular")
    }
}

@Composable
fun MultiButtonSegmentado( sexo: Int, onValue: (Int, String) -> Unit){

    var options = listOf("Hombre", "Mujer")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(50))
            .border(1.dp, Color.Black, shape = RoundedCornerShape(50))
            .background(Color.White)
    ) {
        options.forEachIndexed { index, option ->
            val isSelected = index == sexo

            if(index > 0){
                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .background(Color.Black)
                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(
                        if (isSelected) Color.LightGray else Color.White

                    )
                    .clickable { onValue(index, "sexo") }
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = option,
                    color = if (isSelected) Color.White else Color.Black

                )
            }
        }
    }
}