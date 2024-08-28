package com.aman.financial_litracy_app

import App
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aman.financial_litracy_app.courses.Course
import com.aman.financial_litracy_app.courses.CourseDetailScreen
import com.aman.financial_litracy_app.courses.CourseListScreen
import com.aman.financial_litracy_app.courses.Lesson
import com.aman.financial_litracy_app.homescreen.HomeScreen
import com.aman.financial_litracy_app.homescreen.NotificationScreen
import com.aman.financial_litracy_app.leftnavigationdrawer.AboutUsScreen
import com.aman.financial_litracy_app.leftnavigationdrawer.BookAWorkshopScreen
import com.aman.financial_litracy_app.leftnavigationdrawer.ContactUsScreen
import com.aman.financial_litracy_app.leftnavigationdrawer.LeftNavigationDrawer
import com.aman.financial_litracy_app.leftnavigationdrawer.MyAccountScreen
import com.aman.financial_litracy_app.leftnavigationdrawer.TermsAndConditionScreen
import com.aman.financial_litracy_app.loginregistration.SelectClass
import com.aman.financial_litracy_app.loginregistration.SignupStart
import com.aman.financial_litracy_app.loginregistration.forgetpassword.ForgetPassword1
import com.aman.financial_litracy_app.loginregistration.forgetpassword.ForgetPassword3

import com.aman.financial_litracy_app.ui.theme.Financial_Litracy_AppTheme
import com.aman.financial_litracy_app.viewmodel.CourseViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val courseViewModel: CourseViewModel = viewModel()
            Financial_Litracy_AppTheme {
//                Surface(color = MaterialTheme.colorScheme.background) {
//                    App()
//                }


            }
        }
    }
}





