package com.aman.financial_litracy_app.loginregistration.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface


import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aman.financial_litracy_app.R
import com.aman.financial_litracy_app.navigation.Screens
import com.aman.financial_litracy_app.viewmodel.AuthState
import com.aman.financial_litracy_app.viewmodel.AuthViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupStart(
    navController: NavController,authViewModel: AuthViewModel
    ) {
    var showPopup by remember { mutableStateOf(false) }

    val fullName = remember{ mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    val phoneNumber = remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val authState = authViewModel.authState.observeAsState()

    LaunchedEffect (authState.value){
        when(authState.value){
            is AuthState.Authenticated->navController.navigate(Screens.SuccessPopup.route)
            is AuthState.Error ->navController.navigate(Screens.UnSuccessfulPopup.route)
            else -> Unit
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background) // Use MaterialTheme colors
            .systemBarsPadding().navigationBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.padding(30.dp))
            Text(
                text = "Create an account",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Connect with your friends today!",
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(16.dp))

//            if (showPopup) {
//                SuccessPopup(onContinue = {
//                    showPopup = false
//                    // Navigate to another screen or perform another action
//                    navController.navigate(Screens.Login.route)
//                })
//            }

            OutlinedTextField(
                value = fullName.value,
                onValueChange = { fullName.value = it },
                label = { Text("Full name") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onSurface
                )
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email address") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onSurface
                )
            )
            Spacer(modifier = Modifier.height(16.dp))


            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "+91",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(end = 8.dp),
                    color = MaterialTheme.colorScheme.onSurface
                )
                OutlinedTextField(
                    value = phoneNumber.value,
                    onValueChange = { phoneNumber.value = it },
                    label = { Text("Enter your phone number") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.onSurface
                    )
                )
            }
            Spacer(modifier = Modifier.height(16.dp))


            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onSurface
                )
            )



            //yaha tak ho gaya hai
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
//                navController.navigate(Screens.ForgetPassword1.route)
                    authViewModel.signup(email,password)

                },
                enabled = authState.value!=AuthState.Loading,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(50.dp)
                    .background(color = Color.White),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Signup",color = Color.White)
            }
//            if (showPopup) {
//                SuccessPopup(onContinue = {
//                    showPopup = false
//                    // Navigate to another screen or perform another action
//                })
//            }
            Spacer(modifier = Modifier.height(16.dp))

            HorizontalDivider(modifier = Modifier.padding(10.dp))
            Text(text = "Or With", color = Color.Black, modifier = Modifier.align(Alignment.CenterHorizontally))

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Card(
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(15.dp)
                        )
                        .background(Color.White)
                        .clip(RoundedCornerShape(16.dp)),
                    elevation = CardDefaults.cardElevation(5.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.google_image),
                        contentDescription = "Google",
                        modifier = Modifier
                            .clickable { navController.navigate(Screens.SignupStart.route) }
                            .width(100.dp)
                            .height(50.dp)
                            .background(Color.White)
                            .padding(horizontal = 3.dp)

                    )
                }

                Card(
                    modifier = Modifier
                        .background(Color.White)
                        .border(
                            width = 1.dp,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(15.dp)
                        )
                        .clip(RoundedCornerShape(16.dp)),
                    elevation = CardDefaults.cardElevation(5.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.facebook_image), // Replace with actual image
                        contentDescription = "Facebook",
                        modifier = Modifier
                            .clickable { navController.navigate(Screens.SignupStart.route) }
                            .width(100.dp)
                            .height(50.dp)
                            .background(Color.White)
                            .padding(horizontal = 3.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            TextButton(
                onClick = {
                    navController.navigate(Screens.Login.route)
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            { Text(text = "Already have an account? Login")}
        }
    }


}



//@Preview
//@Composable
//fun SignStartPreview(){
//    val navController = rememberNavController()
//    SignupStart(navController = navController)
//}