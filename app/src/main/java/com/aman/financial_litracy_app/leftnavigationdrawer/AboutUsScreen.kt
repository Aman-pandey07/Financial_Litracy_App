package com.aman.financial_litracy_app.leftnavigationdrawer


import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutUsScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text ="About Us",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription ="Back Button" )
                    }
                }
            )
        },
        content = {
            Column(modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = "Our Mission",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .padding(5.dp)
                        .align(Alignment.CenterHorizontally)
                )
                HorizontalDivider(thickness = 5.dp, modifier = Modifier.padding(horizontal = 10.dp))
                InfoCard(title = "Unmatched service", content = "Support corporate clients and financial investors with their growth strategy and international development.")
                InfoCard(title = "Specific", content = "ConsultUs’ core expertise lies in the ability to support our clients in understanding, analysing and executing commercial and investment strategies in specific markets.")
                InfoCard(title = "Experience", content = "Experience in working with and assisting a wide range of clients from international corporations to small/medium-sized businesses, from large corporate debt providers to mid-market private equity investors.")
                InfoCard(title ="Technology" , content ="The best combination of technology and people." )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "Our Commitment",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .padding(5.dp)
                        .align(Alignment.CenterHorizontally)
                )
                HorizontalDivider(thickness = 5.dp, modifier = Modifier.padding(horizontal = 10.dp))

                InfoCard(title = "Specific", content = "ConsultUs’ core expertise lies in the ability to support our clients in understanding, analysing and executing commercial and investment strategies in specific markets.")
                InfoCard(title = "Experience", content = "Experience in working with and assisting a wide range of clients from international corporations to small/medium-sized businesses, from large corporate debt providers to mid-market private equity investors.")
                InfoCard(title ="Technology" , content ="The best combination of technology and people." )

            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun AboutUsScreenPreview() {
    AboutUsScreen()
}

@Composable
fun InfoCard(title: String, content: String){
        Card(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        ) {
            Text(text = title,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .padding(2.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(text = content,style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(5.dp))
        }
}