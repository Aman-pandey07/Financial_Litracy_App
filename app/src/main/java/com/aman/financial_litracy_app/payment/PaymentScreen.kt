package com.aman.financial_litracy_app.payment

import android.widget.ScrollView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aman.financial_litracy_app.R
import com.google.rpc.Help

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(navController: NavController) {

    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text ="Payment Details",
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

            Column(modifier= Modifier
                .padding(it)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())


            ) {
                    ProductInfoCard(
                            productName = "Finance Courses  $4.99",
                            instructorName = "Vilian Neiro",
                            duration = "2 hours 15 minutes",
                            numberOfLessons = 15,
                            imagePlaceholder = R.drawable.course_image_pay
                    )
                Column (modifier = Modifier.padding(5.dp)){
                    Text(
                        text = "Payment",
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(5.dp),
                    )
                    Text(
                        text = "All transactions are secure and encrypted.",
                        style = MaterialTheme.typography.labelSmall
                    )

                    // Credit card section
                    Card(modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()){
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
//                        horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            // Credit card radio button
                            Row(modifier = Modifier.fillMaxWidth()) {
                                RadioButton(
                                    selected = true,
                                    onClick = { /* Handle credit card selection */ },
                                    colors = RadioButtonDefaults.colors(
                                        selectedColor = Color.Blue,
                                        unselectedColor = Color.Gray
                                    )
                                )
                                Text(
                                    text = "Credit card",
                                    style = MaterialTheme.typography.titleMedium,
                                    modifier = Modifier.align(Alignment.CenterVertically)
                                )
                            }

                            Row(modifier = Modifier.padding(5.dp)) {
                                Image(painter = painterResource(id = R.drawable.visa), contentDescription = "Visa")
                                Image(painter = painterResource(id = R.drawable.mastercard), contentDescription = "Mastercard")
                                Image(painter = painterResource(id = R.drawable.amex), contentDescription = "American Express")
                                Image(painter = painterResource(id = R.drawable.discover), contentDescription = "Discover")
                                Text(text = "and more...", style = MaterialTheme.typography.labelMedium)
                            }

                            // Card number field
                            OutlinedTextField(
                                value = "",
                                onValueChange = { /* Handle card number input */ },
                                label = { Text(text = "Card number") },
                                trailingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Lock") },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp)

                            )

                            // Name on card field
                            OutlinedTextField(
                                value = "",
                                onValueChange = { /* Handle name on card input */ },
                                label = { Text(text = "Name on card") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp)
                            )

                            // Expiration date field
                            OutlinedTextField(
                                value = "",
                                onValueChange = { /* Handle expiration date input */ },
                                label = { Text(text = "Expiration date (MM / YY)") },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp)
                            )

                            // Security code field
                            OutlinedTextField(
                                value = "",
                                onValueChange = { /* Handle security code input */ },
                                label = { Text(text = "Security code") },
                                trailingIcon = { Icon(imageVector = Icons.Default.Info, contentDescription = "Help") },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp)
                            )
                        }
                    }

                    // Payment method options
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)) {
                        // PayPal radio button
                        Row {
                            RadioButton(
                                selected = false,
                                onClick = { /* Handle PayPal selection */ },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color.Blue,
                                    unselectedColor = Color.Gray
                                )
                            )
                            Image(
                                painter = painterResource(id = R.drawable.paypal),
                                contentDescription = "PayPal",
                                modifier = Modifier.align(Alignment.CenterVertically)

                            )
                        }
                        Row {
                            RadioButton(
                                selected = false,
                                onClick = { /* Handle PayPal selection */ },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color.Blue,
                                    unselectedColor = Color.Gray
                                )
                            )
                            Image(
                                painter = painterResource(id = R.drawable.affirm),
                                contentDescription = "PayPal",
                                modifier = Modifier.align(Alignment.CenterVertically)

                            )
                        }

                    }

                    // Submit button
                    Button(
                        onClick = { /* Handle payment submission */ },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text(text = "Pay Now")
                    }
                }
            }
        }
    )
}

//@Preview(showBackground = true)
//@Composable
//fun PaymentScreenPrivi(){
//    PaymentScreen()
//}
@Composable
fun ProductInfoCard(
    productName: String,
    instructorName: String,
    duration: String,
    numberOfLessons: Int,
    imagePlaceholder: Int
) {
    Card (
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(),
        elevation = CardDefaults.cardElevation(),
        border = BorderStroke(1.dp, Color.Gray),
        content={
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ){
                // Image placeholder
                Image(
                    painter = painterResource(id = imagePlaceholder),
                    contentDescription = "Product image",
                    modifier = Modifier
                        .padding(2.dp)
                        .size(80.dp)
                )

                Column(modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.Start
                    ) {
                    Text(text = productName, style = MaterialTheme.typography.titleLarge)
                    Text(text = instructorName, style = MaterialTheme.typography.labelSmall)
                    Text(text = "$duration • $numberOfLessons Lessons", style = MaterialTheme.typography.labelSmall)
                }
            }
        }
    )
}

