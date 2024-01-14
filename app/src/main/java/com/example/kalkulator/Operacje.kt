package com.example.kalkulator

sealed class operacje(val symbol: String){
    object dodaj: operacje("+")
    object odejmij: operacje("-")
    object pomnoz: operacje("x")
    object podziel: operacje("/")
    object e: operacje("e")
    object procent: operacje("%")
    object SIN: operacje ("SIN")
    object COS: operacje ("COS")
    object TAN: operacje ("TAN")
    object potega: operacje("^")
    object pierwiastek: operacje ("√")
    object log: operacje ("lg")
}
