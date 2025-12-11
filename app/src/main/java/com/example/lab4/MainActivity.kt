package com.example.lab4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab4.ui.theme.Lab4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab4Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    BirthdayCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileSection()
        }
        ContactInformation()
    }
}

@Composable
fun ProfileSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)
    ) {
        Surface(
            modifier = Modifier.size(200.dp),
            color = Color.Gray
        ){
            Image(
                painter = painterResource(id = R.drawable.profilepicture),
                contentDescription = "Я",
                contentScale = ContentScale.Fit
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Roman Lali",
            fontSize = 48.sp,
            fontWeight = FontWeight.Light
        )
        Text(
            text = "C# Junior Backend Developer",
            color = Color.DarkGray,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
    }
}

@Composable
fun ContactInformation() {
    Column(
        modifier = Modifier.padding(bottom = 72.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        ContactRow(icon = Icons.Default.AddShoppingCart, text = "+7 929 207 87 40")
        Spacer(modifier = Modifier.height(24.dp))
        ContactRow(icon = Icons.Default.Share, text = "@SuicideboyG59")
        Spacer(modifier = Modifier.height(24.dp))
        ContactRow(icon = Icons.Default.Email, text = "roma.lali2004@yandex.ru")
    }
}

@Composable
fun ContactRow(icon: ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Black
        )
        Spacer(modifier = Modifier.size(24.dp))
        Text(
            text = text,
            fontSize = 24.sp
        )
    }
}
@Composable
fun Quadrant() {
    Column(Modifier.fillMaxSize()) {
        Row(Modifier.weight(0.5f)) {
            QuadrantCard(
                title = "Text composable",
                description = "Displays text and follows the recommended Material Design guidelines.",
                backgroundColor = Color.White,
                Modifier.weight(0.5f)
            )
            QuadrantCard(
                title = "Image composable",
                description = "Creates a composable that lays out and draws a given Painter class object.",
                backgroundColor = Color.Gray,
                Modifier.weight(0.5f)

            )
        }
        Row(Modifier.weight(0.5f)) {
            QuadrantCard(
                title = "Row composable",
                description = "A layout composable that places its children in a horizontal sequence.",
                backgroundColor = Color.Gray,
                Modifier.weight(0.5f)
            )
            QuadrantCard(
                title = "Column composable",
                description = "A layout composable that places its children in a vertical sequence.",
                backgroundColor = Color.White,
                Modifier.weight(0.5f)
            )
        }
    }
}

@Composable
fun QuadrantCard(title: String, description: String, backgroundColor: Color,
                 modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCard() {
    Box {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "C днем рождения, братан",
                fontSize = 70.sp,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.size(100.dp))
            Text(
                text = "От Ромы",
                fontSize = 36.sp,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .align(Alignment.End)
            )
        }
    }
}
