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
    object LeftNavigationDrawer : Screens("left_navigation_drawer")
    object CourseDetailScreen :Screens("course_detailed_screen")
    object CourseListScreen :Screens("course_list_screen")
    object NotificationScreen :Screens("notification_screen")
    object AboutUsScreen :Screens("about_us_screen")
    object BookAWorkshopScreen :Screens("book_a_workshop_screen")
    object ContactUsScreen :Screens("contact_us_screen")
    object MyAccountScreen :Screens("my_account_screen")
    object TermsAndConditionScreen :Screens("terms_and_condition_screen")
    object PaymentScreen :Screens("payment_screen")
    object EmailOtpVerification :Screens("email_otp_verification")
    object ResetPassword :Screens("reset_password")
    object ResetPassword02 :Screens("reset_password02")

}