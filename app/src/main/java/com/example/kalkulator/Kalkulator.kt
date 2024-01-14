package com.example.kalkulator

import android.graphics.fonts.FontStyle
import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kalkulator.ui.theme.Mniejwazneprzyciski


@Composable
fun Kalkulator(
    state: Stan,
    buttonSpacing: Dp = 8.dp,
    modifier: Modifier = Modifier,
    onAction: (Akcje) -> Unit
){
    Box(modifier =  modifier){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)

        ){
            Text(
                text = state.numer1 + (state.operacje?.symbol ?: "")+ state.numer2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                fontWeight = FontWeight.Black,
                fontSize = 30.sp,
                color = Color.Black,
                maxLines = 2
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                Przycisk(
                    symbol = "sin",
                    modifier = Modifier
                        .background(color = Mniejwazneprzyciski)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.Operacje(operacje.SIN))
                    }
                )
                Przycisk(
                    symbol = "cos",
                    modifier = Modifier
                        .background(color = Mniejwazneprzyciski)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.Operacje(operacje.COS))
                    }
                )
                Przycisk(
                    symbol = "tan",
                    modifier = Modifier
                        .background(color = Mniejwazneprzyciski)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.Operacje(operacje.TAN))
                    }
                )
                Przycisk(
                    symbol = "√",
                    modifier = Modifier
                        .background(color = Mniejwazneprzyciski)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.Operacje(operacje.pierwiastek))
                    }
                )
                Przycisk(
                    symbol = "^",
                    modifier = Modifier
                        .background(color = Mniejwazneprzyciski)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.Operacje(operacje.potega))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
           ){
                Przycisk(
                    symbol = "AC",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.Wyczysc)
                    }
                )
                Przycisk(
                    symbol = "<-",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.Usun)
                    }
                )
                Przycisk(
                    symbol = "%",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.Operacje(operacje.procent))
                    }
                )
                Przycisk(
                    symbol = "lg",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.Operacje(operacje.log))
                    }
                )
                Przycisk(
                    symbol = "/",
                    modifier = Modifier
                        .background(color = Mniejwazneprzyciski)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.Operacje(operacje.podziel))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                Przycisk(
                    symbol = "7",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.Number(7))
                    }
                )
                Przycisk(
                    symbol = "8",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.Number(8))
                    }
                )
                Przycisk(
                    symbol = "9",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.Number(9))
                    }
                )
                Przycisk(
                    symbol = "x",
                    modifier = Modifier
                        .background(color = Mniejwazneprzyciski)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.Operacje(operacje.pomnoz))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                Przycisk(
                    symbol = "4",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.Number(4))
                    }
                )
                Przycisk(
                    symbol = "5",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.Number(5))
                    }
                )
                Przycisk(
                    symbol = "6",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.Number(6))
                    }
                )
                Przycisk(
                    symbol = "-",
                    modifier = Modifier
                        .background(color = Mniejwazneprzyciski)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.Operacje(operacje.odejmij))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                Przycisk(
                    symbol = "1",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.Number(1))
                    }
                )
                Przycisk(
                    symbol = "2",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.Number(2))
                    }
                )
                Przycisk(
                    symbol = "3",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.Number(3))
                    }
                )
                Przycisk(
                    symbol = "+",
                    modifier = Modifier
                        .background(color = Mniejwazneprzyciski)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.Operacje(operacje.dodaj))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                Przycisk(
                    symbol = "e",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.Operacje(operacje.e))
                    }
                )
                Przycisk(
                    symbol = "0",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.Number(0))
                    }
                )
                Przycisk(
                    symbol = ".",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.dzisietne)
                    }
                )
                Przycisk(
                    symbol = "=",
                    modifier = Modifier
                        .background(color = Mniejwazneprzyciski)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Akcje.wylicz)
                    }
                )
            }
        }
    }
}