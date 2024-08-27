package com.aman.financial_litracy_app

import App
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aman.financial_litracy_app.courses.CourseListScreen
import com.aman.financial_litracy_app.homescreen.NotificationScreen
import com.aman.financial_litracy_app.leftnavigationdrawer.AboutUsScreen
import com.aman.financial_litracy_app.leftnavigationdrawer.ContactUsScreen
import com.aman.financial_litracy_app.leftnavigationdrawer.TermsAndConditionScreen
import com.aman.financial_litracy_app.loginregistration.Login

import com.aman.financial_litracy_app.ui.theme.Financial_Litracy_AppTheme
import com.aman.financial_litracy_app.viewmodel.CourseViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val courseViewModel: CourseViewModel = viewModel()
            Financial_Litracy_AppTheme {
//
                Login()
            }
        }
    }
}





