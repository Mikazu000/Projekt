package com.example.kalkulator

sealed class Akcje{
    data class Number(val number: Int): Akcje()
    object Wyczysc: Akcje()
    object Usun: Akcje()
    object dzisietne: Akcje()
    object wylicz: Akcje()
    data class Operacje(val operacje: operacje): Akcje()


}
