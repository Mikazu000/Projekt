package com.example.kalkulator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.cos
import kotlin.math.log
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.tan

class Model: ViewModel() {
    var state by mutableStateOf(Stan())
    private set


    fun onAction(action: Akcje){
        when(action) {
            is Akcje.Number -> WlozLiczbe(action.number)
            is Akcje.dzisietne -> WlozPrzecinek()
            is Akcje.Wyczysc -> state = Stan()
            is Akcje.Operacje -> WlozOperacje(action.operacje)
            is Akcje.wylicz -> WykonajWylicz()
            is Akcje.Usun -> WykonajUsun()
        }
    }

    private fun WlozLiczbe(number: Any) {
        if(state.operacje == null){
            if(state.numer1.length >= MAX_LENGTH){
                return
                }
                state = state.copy(
                       numer1 = state.numer1 + number
                        )
            return
        }
        if(state.numer2.length >= MAX_LENGTH){
            return
        }
        state = state.copy(
            numer2 = state.numer2 + number
        )
    }

    private fun WykonajUsun() {
        when{
            state.numer2.isNotBlank() -> state = state.copy(
                numer2 = state.numer2.dropLast(1)
            )
            state.operacje != null -> state = state.copy(
                operacje = null
            )
            state.numer1.isNotBlank() -> state = state.copy(
                numer1 = state.numer1.dropLast(1)
            )
        }
    }

    private fun WykonajWylicz() {
        val number1= state.numer1.toDoubleOrNull()
        val number2 = state.numer2.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when (state.operacje) {
                is operacje.dodaj -> number1 + number2
                is operacje.odejmij -> number1 - number2
                is operacje.pomnoz -> number1 * number2
                is operacje.podziel -> number1 / number2
                is operacje.e -> Math.pow(10.0, number2) * number1
                is operacje.potega -> number1.pow(number2)
                is operacje.log -> Math.log(number2)/Math.log(number1)
                else -> return
            }
            state = state.copy(
                numer1 = result.toString().take(15),
                numer2 = "",
                operacje = null
            )
        }
        else if (number1 != null && number2 == null){
            val result  = when (state.operacje){
                is operacje.pierwiastek -> Math.pow(number1, 1.0/2.0)
                is operacje.SIN -> Math.sin(number1)
                is operacje.COS -> Math.cos(number1)
                is operacje.TAN -> Math.tan(number1)
                is operacje.procent -> number1/100
                else -> return
            }
            state = state.copy(
                numer1 = result.toString().take(15),
                numer2 = "",
                operacje = null
            )
        }
    }

    private fun WlozOperacje(operacje: operacje) {
        if(state.numer1.isNotBlank()){
            state = state.copy(operacje = operacje)
        }
    }

    private fun WlozPrzecinek() {
        if (state.operacje == null && !state.numer1.contains(".")
            && state.numer1.isNotBlank()
        ) {
            state = state.copy(
                numer1 = state.numer1 + "."
            )
            return
        }
        if (state.operacje == null && state.numer1.isBlank()) {
            state = state.copy(
                numer1 = "0."
            )
            return
        }
        if (!state.numer2.contains(".")
            && state.numer2.isNotBlank()
        ) {
            state = state.copy(
                numer2 = state.numer2 + "."
            )
        }
        if (state.operacje == null && state.numer2.isBlank()) {
            state = state.copy(
                numer2 = "0."
            )
            return
        }
    }
    companion object{
        private const val MAX_LENGTH= 6
    }
}