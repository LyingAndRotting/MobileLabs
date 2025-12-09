package com.example.lab4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab4.ui.theme.Lab4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFFFCDD2)
                ) {
                    BusinessCardApp()
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
            modifier = Modifier.size(120.dp),
            color = Color.Gray
        ){
            Image(
                painter = painterResource(id = R.drawable.profilepicture),
                contentDescription = "Android Logo",
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Roman Lali",
            fontSize = 48.sp,
            fontWeight = FontWeight.Light
        )
        Text(
            text = "C# Junior Backend Developer",
            color = Color(0xFF006D3B),
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
        ContactRow(icon = Icons.Default.Phone, text = "+7 929 207 87 40")
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
            tint = Color(0xFF006D3B)
        )
        Spacer(modifier = Modifier.size(24.dp))
        Text(
            text = text,
            fontSize = 24.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    Lab4Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFFFCDD2)
        ) {
            BusinessCardApp()
        }
    }
}
