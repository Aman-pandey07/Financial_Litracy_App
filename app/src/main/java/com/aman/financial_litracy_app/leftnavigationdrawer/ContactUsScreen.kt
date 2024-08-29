package com.aman.financial_litracy_app.leftnavigationdrawer


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aman.financial_litracy_app.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactUsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text ="Contact Us",
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
            Column(modifier = Modifier
                .padding(it)
            ) {
                ContactInfoCard(icon = R.drawable.contact_us_icon1, title = "Customer Service", content ="customerinfo@gmail.com" )
                ContactInfoCard(icon = R.drawable.contact_us_icon2, title = "Customer Call", content ="+91-5874854120" )
            }
        }
    )

}

//@Preview(showBackground = true)
//@Composable
//fun ContactUsScreenPreview() {
//    ContactUsScreen()
//}


@Composable
fun ContactInfoCard(icon: Int, title: String, content: String){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        elevation = CardDefaults.cardElevation(focusedElevation = 5.dp),
        colors = CardDefaults.elevatedCardColors()
    ) {
        Row {
            Image(
                painter =painterResource(id = icon),
                contentDescription =null ,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(5.dp)
            )
            Column(modifier = Modifier
                .padding(5.dp)
                .padding(start = 5.dp)) {
                Text(text = title, style = MaterialTheme.typography.titleMedium)
                Text(text = content, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}



