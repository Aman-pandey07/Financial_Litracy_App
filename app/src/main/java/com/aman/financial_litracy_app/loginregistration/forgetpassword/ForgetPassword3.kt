package com.aman.financial_litracy_app.loginregistration.forgetpassword

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aman.financial_litracy_app.navigation.Screens
import androidx.compose.material.icons.Icons
import androidx.compose.ui.res.painterResource
import com.aman.financial_litracy_app.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgetPassword3(
    navController: NavController
) {
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false)}

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
                text = "Set new password",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Enter your new password below and check the hint while setting it",

                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(32.dp))
            //textfieldoutlined
            var showPassword by remember { mutableStateOf(false) }
            val eyeOpenPainter = painterResource(R.drawable.ic_eye_open)
            val eyeClosedPainter = painterResource(R.drawable.ic_eye_closed)// Track password visibility

//            val icon = if (showPassword) {
//                Image(
//                    painter = painterResource(R.drawable.ic_eye_open), // Replace with your eye open icon
//                    contentDescription = "Show Password"
//                )
//            } else {
//                Image(
//                    painter = painterResource(R.drawable.ic_eye_closed), // Replace with your eye closed icon
//                    contentDescription = "Hide Password"
//                )
//            }

            Text(
                text = "Enter New Password",
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(Alignment.Start)
            )
            OutlinedTextField(
                value = newPassword,
                onValueChange = { newPassword = it },
                label = { Text("Enter New Password", color = Color.LightGray) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                placeholder = { Text(text = "Enter new password", color = Color.Gray)},
                shape = RoundedCornerShape(10.dp),
                trailingIcon = {
                    IconButton(onClick = { showPassword = !showPassword }) {
                        Image(painter = if (showPassword) eyeOpenPainter else eyeClosedPainter, contentDescription = "Show Password")
                    }
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Gray
                )
            )
//            OutlinedTextField(
//                value = newPassword,
//                onValueChange = { newPassword = it },
//                label = { Text(text = "Enter New Password") },
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
//
////                trailingIcon = {
////                    IconButton(onClick
////                    = { /* Handle show password */ }) {
////                        Icon(
////                            imageVector = if (showPassword) Icons.Default.Lock else Icons.Default.FavoriteBorder,
////                            contentDescription =  if (showPassword) "Hide password" else "Show password"
////                        )
////                    }
////                },
//                modifier = Modifier.fillMaxWidth()
//            )
            Text(
                text = "Confirm Password",
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(Alignment.Start)
            )
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirm Password", color = Color.LightGray) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                placeholder = { Text(text = "Confirm new password", color = Color.Gray)},
                shape = RoundedCornerShape(10.dp),
                trailingIcon = {
                    IconButton(onClick = { showPassword = !showPassword }) {
                        Image(painter = if (showPassword) eyeOpenPainter else eyeClosedPainter, contentDescription = "Show Password")
                    }
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                    navController.navigate(Screens.ForgetPassword4.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(50.dp)
                    .background(color = Color.White),
                shape = RoundedCornerShape(10.dp)// Adjust button padding
            ) {
                Text(
                    text = "Submit",
                    color = Color.White
                ) // White text on primary background
            }

            Spacer(
                modifier = Modifier
                    .height(32.dp)
                    .weight(0.5f)
            ) // Adjust spacing before login text

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

//        Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Center,
//
//    horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text
//        = "Set new password",
//        style = MaterialTheme.typography.titleLarge,
//        textAlign = TextAlign.Center
//        )
//        Text(
//            text = "Enter your new password below and check the hint while setting it",
//            style = MaterialTheme.typography.bodyMedium,
//            textAlign = TextAlign.Center
//        )
//
//        OutlinedTextField(
//            value = newPassword,
//            onValueChange = { newPassword = it },
//            label = { Text(text = "Enter New Password") },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
//
//        trailingIcon = {
//            IconButton(onClick
//            = { /* Handle show password */ }) {
//            Icon(
//                imageVector = if (showPassword) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
//                contentDescription =  if (showPassword) "Hide password" else "Show password"
//            )
//        }
//        },
//        modifier = Modifier.fillMaxWidth()
//        )
//
//        OutlinedTextField(
//            value = confirmPassword,
//            onValueChange = { confirmPassword = it },
//            label = { Text(text
//                = "Confirm Password") },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
//
//
//        trailingIcon = {
//            IconButton(onClick
//            = { /* Handle show password */ }) {
//            Icon(
//                imageVector = if (showPassword) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
//                contentDescription =  if (showPassword) "Hide password" else "Show password"
//            )
//        }
//        },
//        modifier = Modifier.fillMaxWidth()
//        )
//
//        Button(
//            onClick = {
////            navController.navigate(Screens.ForgetPassword4.route)
//            /* Handle submit */ },
//            modifier = Modifier.padding(top = 16.dp)
//        ) {
//            Text(text = "Submit")
//        }
//
//        Text(
//            text = "Already have an account?",
//            style = MaterialTheme.typography.bodyMedium,
//            textAlign = TextAlign.Center
//        )
//        TextButton(onClick = { /* Handle log in */ }) {
//            Text(text = "Log in")
//        }
//    }
}


//@Preview(showBackground = true)
//@Composable
//fun fp3(){
//    ForgetPassword3()
//}