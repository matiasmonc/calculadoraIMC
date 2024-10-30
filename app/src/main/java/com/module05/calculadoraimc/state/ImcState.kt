package com.module05.calculadoraimc.state

data class ImcState(
    val edad: String = "",
    val peso: String = "",
    val altura: String = "",
    val sexo: Int = 0,
    val res: String = ""
)
