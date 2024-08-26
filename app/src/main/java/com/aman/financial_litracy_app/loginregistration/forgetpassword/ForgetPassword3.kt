package com.aman.financial_litracy_app.loginregistration.forgetpassword

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aman.financial_litracy_app.navigation.Screens


@Composable
fun ForgetPassword3(navController: NavController) {
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false)}

        Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,

    horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text
        = "Set new password",
        style = MaterialTheme.typography.titleLarge,
        textAlign = TextAlign.Center
        )
        Text(
            text = "Enter your new password below and check the hint while setting it",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )

        OutlinedTextField(
            value = newPassword,
            onValueChange = { newPassword = it },
            label = { Text(text = "Enter New Password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),

        trailingIcon = {
            IconButton(onClick
            = { /* Handle show password */ }) {
            Icon(
                imageVector = if (showPassword) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription =  if (showPassword) "Hide password" else "Show password"
            )
        }
        },
        modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text(text
                = "Confirm Password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),


        trailingIcon = {
            IconButton(onClick
            = { /* Handle show password */ }) {
            Icon(
                imageVector = if (showPassword) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription =  if (showPassword) "Hide password" else "Show password"
            )
        }
        },
        modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
            navController.navigate(Screens.ForgetPassword4.route)
            /* Handle submit */ },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Submit")
        }

        Text(
            text = "Already have an account?",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
        TextButton(onClick = { /* Handle log in */ }) {
            Text(text = "Log in")
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun fp3(){
//    ForgetPassword3()
//}