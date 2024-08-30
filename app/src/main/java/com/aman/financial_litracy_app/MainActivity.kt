package com.aman.financial_litracy_app

import App
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel

import com.aman.financial_litracy_app.ui.theme.Financial_Litracy_AppTheme
import com.aman.financial_litracy_app.viewmodel.AuthViewModel
import com.google.firebase.FirebaseApp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        FirebaseApp.initializeApp(this)

        setContent {
            val authViewModel: AuthViewModel = viewModel()
            //remember i have placed authviewmodel down bwlow thw setcontent which was originally above the setcontent
//            val courseViewModel: CourseViewModel = viewModel()
            Financial_Litracy_AppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    App(authViewModel = authViewModel)
                }


            }
        }
    }
}





