package com.coalindians.app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppContent()
        }
    }
}

@Composable
fun AppContent() {
    var registered by remember { mutableStateOf(false) }
    if (!registered) RegistrationScreen(onRegistered = { registered = true })
    else MainScreen()
}

@Composable
fun RegistrationScreen(onRegistered: () -> Unit) {
    val ctx = LocalContext.current
    var mobile by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var designation by remember { mutableStateOf("") }
    var unit by remember { mutableStateOf("") }
    var area by remember { mutableStateOf("") }
    var subsidiary by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Register — Coal Indians", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = mobile, onValueChange = { mobile = it }, label = { Text("Mobile number") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone))
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = designation, onValueChange = { designation = it }, label = { Text("Designation") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = unit, onValueChange = { unit = it }, label = { Text("Unit") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = area, onValueChange = { area = it }, label = { Text("Area") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = subsidiary, onValueChange = { subsidiary = it }, label = { Text("Subsidiary") })
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = { onRegistered() }) { Text("Register") }
    }
}

@Composable
fun MainScreen() {
    val ctx = LocalContext.current
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Coal Indians — Koushik Ghosh", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(12.dp))
        LinkButton("YouTube Channel", "https://www.youtube.com/@coalindians") { url -> openUrl(ctx, url) }
        Spacer(modifier = Modifier.height(8.dp))
        LinkButton("Facebook Page", "https://www.facebook.com/NarottamMondal275") { url -> openUrl(ctx, url) }
        Spacer(modifier = Modifier.height(8.dp))
        LinkButton("Coal India Website", "https://www.coalindia.in") { url -> openUrl(ctx, url) }
        Spacer(modifier = Modifier.height(12.dp))
        Text("Contact: koush382@gmail.com | +91 7001028748", style = MaterialTheme.typography.body2)
    }
}

@Composable
fun LinkButton(label: String, url: String, onClickUrl: (String) -> Unit) {
    Button(onClick = { onClickUrl(url) }) {
        Text(label)
    }
}

fun openUrl(context: android.content.Context, url: String) {
    val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(i)
}
