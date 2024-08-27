package com.aman.financial_litracy_app.loginregistration

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
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
import com.aman.financial_litracy_app.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(
//    navController: NavController
) {
    val emailState = remember{ mutableStateOf("") }
    val passwordState = remember{ mutableStateOf("") }
    val rememberMeChecked = remember { mutableStateOf(false) }


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Spacer(modifier = Modifier.padding(40.dp))
            Text(
                text = "Hi, Welcome Back! ${"👋"}",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 10.dp)

            )
            Text(
                text = "Hello again, you've been missed!",
                textAlign = TextAlign.Center,
                color = Color.LightGray,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 10.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Email",
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(Alignment.Start)
            )
            OutlinedTextField(
                value = emailState.value,
                onValueChange = { emailState.value = it },
                label = { Text("Email", color = Color.Black) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                placeholder = { Text(text = "Enter Email", color = Color.Gray)},
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Password", modifier = Modifier
                .padding(start = 20.dp)
                .align(Alignment.Start))
            OutlinedTextField(
                value = passwordState.value,
                onValueChange = { passwordState.value = it },
                label = { Text("Password", color = Color.Black) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                placeholder = { Text(text = "Enter Password", color = Color.Gray) },
                shape = RoundedCornerShape(10.dp),
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Gray
            )
                )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
            ) {
                Checkbox(
                    checked = rememberMeChecked.value,
                    onCheckedChange = { rememberMeChecked.value = it },
                    modifier = Modifier
                )
                Text(
                    text = "Remember Me",
                    modifier = Modifier
                        .padding(start = 15.dp)
                        .align(Alignment.CenterVertically),
                    color = Color.Black
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Forgot Password",
                    color = Color.Blue,
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .align(Alignment.CenterVertically)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
//                navController.navigate(Screens.SignupStart.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(50.dp)
                    .background(color = Color.White),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Login",color = Color.White)
            }
            Spacer(modifier = Modifier.height(16.dp))

                HorizontalDivider(modifier = Modifier.padding(10.dp))
                Text(text = "Or With", color = Color.Black)

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Image(
                    painter = painterResource(R.drawable.ic_google), // Replace with actual image
                    contentDescription = "Google",
                    modifier = Modifier
                )
                Image(
                    painter = painterResource(R.drawable.ic_facebook), // Replace with actual image
                    contentDescription = "Facebook",
                    modifier = Modifier
                )

            }
            Spacer(modifier = Modifier.weight(1f))
            TextButton(onClick = { }){ Text(text = "Don't have an account? Sign Up")}

        }
    }


}
@Preview(showBackground = true)
@Composable
fun LoginPrevi(){
    Login()
}