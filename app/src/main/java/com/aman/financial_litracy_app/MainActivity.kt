package com.aman.financial_litracy_app

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.aman.financial_litracy_app.onboard.OnboardingScreen
import com.aman.financial_litracy_app.ui.theme.Financial_Litracy_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Financial_Litracy_AppTheme {

                    ShowOnboardingScreen()

            }
        }
    }
}

@Composable
private fun ShowOnboardingScreen() {
   val context = LocalContext.current

    Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)){
        OnboardingScreen{
            Toast.makeText(context,"dnihbnijvdniunuo",Toast.LENGTH_SHORT).show()
        }
    }
}

