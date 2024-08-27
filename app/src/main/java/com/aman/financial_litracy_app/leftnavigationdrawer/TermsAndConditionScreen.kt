package com.aman.financial_litracy_app.leftnavigationdrawer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TermsAndConditionScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text ="Terms of Use",
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
                .padding(it).padding(10.dp)
                .verticalScroll(rememberScrollState())) {
                Text(
                    text = "last updated on 01/05/2024",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier
                        .padding(5.dp)
                        .align(Alignment.CenterHorizontally)
                )
                HorizontalDivider(thickness = 5.dp, modifier = Modifier.padding(horizontal = 10.dp))
                TextCard(title = "1. Clause 1", content = "The sun dappled through the leaves as I strolled along the winding path. Birdsong filled the air, and the gentle breeze carried the sweet scent of wildflowers. A gentle smile crept across my face as I savored the tranquility of the moment.")
                TextCard(title = "2. Clause 2", content = "The sun dappled through the leaves as I strolled along the winding path. Birdsong filled the air, and the gentle breeze carried the sweet scent of wildflowers. A gentle smile crept across my face as I savored the tranquility of the moment.")
                TextCard(title = "3. Clause 3", content = "The sun dappled through the leaves as I strolled along the winding path. Birdsong filled the air, and the gentle breeze carried the sweet scent of wildflowers. A gentle smile crept across my face as I savored the tranquility of the moment.")
                TextCard(title = "4. Clause 4", content = "The sun dappled through the leaves as I strolled along the winding path. Birdsong filled the air, and the gentle breeze carried the sweet scent of wildflowers. A gentle smile crept across my face as I savored the tranquility of the moment.")
                TextCard(title = "5. Clause 5", content = "The sun dappled through the leaves as I strolled along the winding path. Birdsong filled the air, and the gentle breeze carried the sweet scent of wildflowers. A gentle smile crept across my face as I savored the tranquility of the moment.")
                TextCard(title = "6. Clause 6", content = "The sun dappled through the leaves as I strolled along the winding path. Birdsong filled the air, and the gentle breeze carried the sweet scent of wildflowers. A gentle smile crept across my face as I savored the tranquility of the moment.")
                TextCard(title = "7. Clause 7", content = "The sun dappled through the leaves as I strolled along the winding path. Birdsong filled the air, and the gentle breeze carried the sweet scent of wildflowers. A gentle smile crept across my face as I savored the tranquility of the moment.")
                TextCard(title = "8. Clause 8", content = "The sun dappled through the leaves as I strolled along the winding path. Birdsong filled the air, and the gentle breeze carried the sweet scent of wildflowers. A gentle smile crept across my face as I savored the tranquility of the moment. hii this is tp")
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = Color.White,
                        disabledContainerColor = MaterialTheme.colorScheme.primaryContainer,
                        disabledContentColor = Color.White
                    )
                ) {
                    Text(text = "Accept & Continue")
                }
            }
        }
    )
}

@Preview
@Composable
fun TermsAndConditionScreenPreview() {
    TermsAndConditionScreen()
}

@Composable
fun TextCard(title: String, content: String) {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(text = title, style = MaterialTheme.typography.titleMedium)
        Text(text = content, style = MaterialTheme.typography.bodySmall)
    }

}