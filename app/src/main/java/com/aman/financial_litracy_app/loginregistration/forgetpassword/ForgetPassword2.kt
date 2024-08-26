package com.aman.financial_litracy_app.loginregistration.forgetpassword

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aman.financial_litracy_app.navigation.Screens

@Composable
fun ForgetPassword2(navController: NavController) {
    var verificationCode by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text
        = "Email Verification",
        style = MaterialTheme.typography.titleLarge,
        textAlign = TextAlign.Center
        )
        Text(
            text = "Copy the verification code in your application to verify this account recovery",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )

        Row {
            repeat(5) {
                OutlinedTextField(
                    value = verificationCode,
                    onValueChange = { verificationCode = it },
                    singleLine = true,
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1f)
                )
            }
        }

        Button(
            onClick = {
            navController.navigate(Screens.ForgetPassword3.route)
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
//fun fp2(){
//    ForgetPassword2()
//}