package com.aman.financial_litracy_app

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.aman.financial_litracy_app.onboard.OnboardingScreen
import com.aman.financial_litracy_app.onboard.OnboardingUtils
import com.aman.financial_litracy_app.ui.theme.Financial_Litracy_AppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val onboardingUtils by lazy { OnboardingUtils(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Financial_Litracy_AppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    if (onboardingUtils.isOnboardingComplete()){
                        ShowHomeScreen()
                    }else{
                        ShowOnboardingScreen()
                    }
                }


            }
        }
    }
    @Composable
    private fun ShowOnboardingScreen() {
        val scope = rememberCoroutineScope()
        OnboardingScreen {
            onboardingUtils.setOnboardingComplete()
            scope.launch {
                setContent {
                    ShowHomeScreen()
                }
            }
        }
    }
}



@Composable
private fun ShowHomeScreen() {
    Column {
        Text(text = "Home Screen", style = MaterialTheme.typography.headlineLarge)
    }
}

