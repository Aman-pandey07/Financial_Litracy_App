package com.aman.financial_litracy_app.leftnavigationdrawer.resetpassword

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
import androidx.compose.foundation.layout.width
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
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aman.financial_litracy_app.R
import com.aman.financial_litracy_app.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailOtpVerification(navController: NavController) {
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

            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var otpValue by remember { mutableStateOf("") }
                Image(
                    painter = painterResource(id = R.drawable.ic_check_mail), // Replace with your image resource
                    contentDescription = "Check Mail Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(150.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Subtitle
                Text(
                    text = "Check your mail",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "We just sent an OTP to your registered email address",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    color = Color.Gray,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(24.dp))

                // OTP Fields
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    repeat(4) { index ->
                        OutlinedTextField(
                            value = if (otpValue.length > index) otpValue[index].toString() else "",
                            onValueChange = {
                                if (it.length <= 1) {
                                    otpValue = otpValue.substring(0, index) + it + otpValue.substring(index + 1)
                                }
                            },
                            textStyle = TextStyle(textAlign = TextAlign.Center),
                            singleLine = true,
                            modifier = Modifier
                                .width(50.dp)
                                .height(50.dp)
                                .background(Color.White, RoundedCornerShape(8.dp)),
                            shape = RoundedCornerShape(8.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Timer and Resend
                Text(
                    text = "0:24",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(8.dp))

                TextButton(onClick = {
                    navController.navigate(Screens.EmailOtpVerification.route)
                }) {
                    Text(
                        text = "Didn’t get the code? Resend",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFF0086FF)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp).weight(1f))

                // Verify OTP Button
                Button(
                    onClick = {
                        navController.navigate(Screens.ResetPassword02.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0086FF)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Verify OTP", color = Color.White)
                }
            }
        }
    )
}

//@Preview
//@Composable
//fun EmailPrevi(modifier: Modifier = Modifier) {
//    EmailOtpVerification({},{})
//}