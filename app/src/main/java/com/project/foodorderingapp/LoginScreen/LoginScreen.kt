package com.project.foodorderingapp.LoginScreen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodorderingapp.R
import com.project.foodorderingapp.ui.theme.GreenJC





val customFontFamily = FontFamily(
    Font(R.font.pacifico) // Replace with your font file name
)
val customColor = Color(0xFFFFFFFF)
@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current.applicationContext
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.foodia6),
                contentScale = ContentScale.FillBounds
            )

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 140.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "LOGIN",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = customFontFamily,
                    color = customColor
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text(text = "Username") },
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.colors(
                    focusedLeadingIconColor = GreenJC,
                    unfocusedLeadingIconColor = GreenJC,
                    focusedLabelColor = GreenJC,
                    unfocusedLabelColor = GreenJC,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = GreenJC,
                    unfocusedIndicatorColor = GreenJC,
                    unfocusedPlaceholderColor = GreenJC
                ), leadingIcon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = "username")
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Password") },
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.colors(
                    focusedLeadingIconColor = GreenJC,
                    unfocusedLeadingIconColor = GreenJC,
                    focusedLabelColor = GreenJC,
                    unfocusedLabelColor = GreenJC,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = GreenJC,
                    unfocusedIndicatorColor = GreenJC,
                    unfocusedPlaceholderColor = GreenJC
                ), leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "Email")
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                visualTransformation = PasswordVisualTransformation()
            )
            Button(
                onClick = {
                    if (authenticate(username, password)) {
                        onLoginSuccess()
                        Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                    }
                }, colors = ButtonDefaults.buttonColors(GreenJC),
                contentPadding = PaddingValues(
                    start = 60.dp,
                    end = 60.dp,
                    top = 8.dp,
                    bottom = 8.dp
                ),
                modifier = Modifier.padding(top = 18.dp)
            ) {
                Text(text = "Login", fontSize = 22.sp)
            }

        }
    }
}

private fun authenticate(username: String, password: String): Boolean {
    val validUsername = "prati"
    val validPassword = "123"
    return username == validUsername && password == validPassword
}