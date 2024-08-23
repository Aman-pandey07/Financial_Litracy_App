package com.aman.financial_litracy_app

import App
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aman.financial_litracy_app.homescreen.LeftNavigationDrawer
import com.aman.financial_litracy_app.payment.PaymentScreen

import com.aman.financial_litracy_app.ui.theme.Financial_Litracy_AppTheme




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Financial_Litracy_AppTheme {
//                Surface(color = MaterialTheme.colorScheme.background) {
//                    App()
//                }
                PaymentScreen()


            }
        }
    }
}





