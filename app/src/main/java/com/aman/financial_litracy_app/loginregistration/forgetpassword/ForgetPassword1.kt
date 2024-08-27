package com.aman.financial_litracy_app.loginregistration.forgetpassword

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aman.financial_litracy_app.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgetPassword1(
//    navController: NavController
) {
    var email by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background) // Use MaterialTheme colors
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center

        ) {
            Spacer(modifier = Modifier.padding(70.dp))
            Text(
                text = "Forgot Password",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Oops. It happens to the best of us. Input your email address to fix the issue.",

                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Email address") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth(),

                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onSurface )
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                    // Handle submit
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(50.dp)
                    .background(color = Color.White),
                shape = RoundedCornerShape(10.dp)// Adjust button padding
            ) {
                Text(text = "Submit", color = Color.White) // White text on primary background
            }

            Spacer(modifier = Modifier
                .height(32.dp)
                .weight(0.5f)) // Adjust spacing before login text

            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    text = "Already have an account?",
                    color = MaterialTheme.colorScheme.onSurface,
//                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                        text = "Log in",
                color = MaterialTheme.colorScheme.primary,
//                modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            Spacer(modifier = Modifier.padding(10.dp))
        }
    }

}
@Preview(showBackground = true)
@Composable
fun fp1(){
    ForgetPassword1()
}