package com.aman.financial_litracy_app.navigation

sealed class Screens(val route: String) {
    object Login : Screens("login")
    object SignupStart : Screens("signup_start")
    object SignupComplete : Screens("signup_complete")
    object ForgetPassword1 : Screens("forget_password1")
    object ForgetPassword2 : Screens("forget_password2")
    object ForgetPassword3 : Screens("forget_password3")
    object ForgetPassword4 : Screens("forget_password4")
    object SelectClass : Screens("select_class")
    object HomeScreen : Screens("home_screen")
    object OnboardingScreen : Screens("onboarding_screen")
}