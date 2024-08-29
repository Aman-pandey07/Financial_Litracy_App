package com.aman.financial_litracy_app.leftnavigationdrawer.resetpassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aman.financial_litracy_app.R
import com.aman.financial_litracy_app.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetPassword02(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text ="Reset Password",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription ="Back Button" )
                    }
                }
            )
        },
        content = {
            var showPopup by remember { mutableStateOf(false) }
            Column(modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_reset_password_02), // Replace with your image resource
                    contentDescription = "Reset Password Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(150.dp)
                )
                if (showPopup){
                    ResetSuccessPopup {
                        showPopup = false
                        navController.navigate(Screens.Login.route)
                    }
                }


                Spacer(modifier = Modifier.height(70.dp))

                // Current Password Field
                OutlinedTextField(
                    value = remember { "" },
                    onValueChange = { /* Handle password input */ },
                    label = { Text("New Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(8.dp)
                )



                Spacer(modifier = Modifier.height(24.dp).weight(1f))

                // Continue Button
                Button(
                    onClick = {

                        showPopup = true
                              },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0086FF)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Continue", color = Color.White)
                }
            }
        }
    )
}


@Preview
@Composable
fun Previewrp02(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    ResetPassword02(navController=navController)
}