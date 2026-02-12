package com.example.lab5

import android.icu.text.NumberFormat
import android.os.Bundle
import android.transition.Slide
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab5.ui.theme.Lab5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab5Theme {
                //ArtGalleryScreen()
                TipCalculator()
            }
        }
    }
}

@Composable
fun ArtGalleryScreen() {
    data class Slide(val imageRes: Int, val title: String, val artist: String, val year: String)
    var currentSlide by remember { mutableStateOf(0) }
    val slides = listOf(
        Slide(R.drawable.first, "Абрикос", "Хайзенберг", "2025"),
        Slide(R.drawable.second, "Обдумывание", "Коты^4", "2025"),
        Slide(R.drawable.third, "Хвастливость", "Крутой кот", "2025"),
        Slide(R.drawable.fourth, "Бобр", "Скачивайте приложение макс", "2025")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = slides[currentSlide].imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Color.LightGray,
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = slides[currentSlide].title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Row {
                    Text(text = slides[currentSlide].artist, fontWeight = FontWeight.Bold)
                    Text(text = " (${slides[currentSlide].year})")
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    currentSlide = if (currentSlide > 0) currentSlide - 1 else slides.size - 1
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Предыдущая")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = {
                    currentSlide = if (currentSlide < slides.size - 1) currentSlide + 1 else 0
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Следующая")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TipCalculator() {
    var billAmount by remember { mutableStateOf("") }
    var tipPercentage by remember { mutableStateOf("") }
    var roundUp by remember { mutableStateOf(false) }

    val amount = billAmount.toDoubleOrNull() ?: 0.0
    val percentage = tipPercentage.toDoubleOrNull() ?: 0.0

    var tip by remember(amount, percentage, roundUp) {
        var calculatedTip = percentage / 100 * amount
        if (roundUp) {
            calculatedTip = kotlin.math.ceil(calculatedTip)
        }
        mutableStateOf(calculatedTip)
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Посчитайте чаевые",
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = billAmount,
            onValueChange = { billAmount = it },
            label = { Text("Сумма счета") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = tipPercentage,
            onValueChange = { tipPercentage = it },
            label = { Text("Процент чаевых") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Округлить?")
            Switch(
                checked = roundUp,
                onCheckedChange = { roundUp = it }
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = String.format("Сумма чаевых: %.2f₽",tip),
            fontSize = 30.sp
        )
    }
}

