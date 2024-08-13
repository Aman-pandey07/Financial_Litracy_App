package com.aman.financial_litracy_app.loginregistration

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aman.financial_litracy_app.R
import com.aman.financial_litracy_app.navigation.Routes

@Composable
fun Login() {
    val emailState = remember{ mutableStateOf("") }
    val passwordState = remember{ mutableStateOf("") }
    val rememberMeChecked = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Hi, Welcome Back!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Hello again, you've been missed!",
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Email", modifier = Modifier
            .padding(start = 20.dp)
            .align(Alignment.Start))
        OutlinedTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Password", modifier = Modifier
            .padding(start = 20.dp)
            .align(Alignment.Start))
        OutlinedTextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = rememberMeChecked.value,
                onCheckedChange = { rememberMeChecked.value = it }
            )
            Text(text = "Remember Me", modifier = Modifier.padding(15.dp))
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Forgot Password", color = Color.Blue, modifier = Modifier.padding(0.dp,15.dp,15.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {  },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Or With")
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(R.drawable.ic_google), // Replace with actual image
                contentDescription = "Google",
                modifier = Modifier.size(100.dp)
            )
            Image(
                painter = painterResource(R.drawable.ic_facebook), // Replace with actual image
                contentDescription = "Facebook",
                modifier = Modifier.size(100.dp)
            )

        }
        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = { }){ Text(text = "Don't have an account? Sign Up")}

    }

}
@Preview(showBackground = true)
@Composable
fun LoginPrevi(){
    Login()
}