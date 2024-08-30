


import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aman.financial_litracy_app.courses.CourseDetailScreen
import com.aman.financial_litracy_app.courses.CourseListScreen
import com.aman.financial_litracy_app.homescreen.HomeScreen
import com.aman.financial_litracy_app.homescreen.NotificationScreen
import com.aman.financial_litracy_app.leftnavigationdrawer.AboutUsScreen
import com.aman.financial_litracy_app.leftnavigationdrawer.BookAWorkshopScreen
import com.aman.financial_litracy_app.leftnavigationdrawer.ContactUsScreen
import com.aman.financial_litracy_app.leftnavigationdrawer.LeftNavigationDrawer
import com.aman.financial_litracy_app.leftnavigationdrawer.MyAccountScreen
import com.aman.financial_litracy_app.leftnavigationdrawer.TermsAndConditionScreen
import com.aman.financial_litracy_app.leftnavigationdrawer.resetpassword.EmailOtpVerification
import com.aman.financial_litracy_app.leftnavigationdrawer.resetpassword.ResetPassword02
import com.aman.financial_litracy_app.leftnavigationdrawer.resetpassword.ResetPasswordScreen
import com.aman.financial_litracy_app.loginregistration.login.Login
import com.aman.financial_litracy_app.loginregistration.signup.SelectClass
import com.aman.financial_litracy_app.loginregistration.signup.SignupComplete
import com.aman.financial_litracy_app.loginregistration.signup.SignupStart
import com.aman.financial_litracy_app.loginregistration.forgetpassword.ForgetPassword1
import com.aman.financial_litracy_app.loginregistration.forgetpassword.ForgetPassword2
import com.aman.financial_litracy_app.loginregistration.forgetpassword.ForgetPassword3
import com.aman.financial_litracy_app.loginregistration.forgetpassword.ForgetPassword4
import com.aman.financial_litracy_app.loginregistration.login.SuccessfulLogin
import com.aman.financial_litracy_app.loginregistration.login.UnsuccessfulLogin
import com.aman.financial_litracy_app.loginregistration.signup.SuccessPopup
import com.aman.financial_litracy_app.loginregistration.signup.UnSuccessfullPopUpScreen
import com.aman.financial_litracy_app.navigation.Routes
import com.aman.financial_litracy_app.navigation.Screens
import com.aman.financial_litracy_app.onboard.OnboardingScreen
import com.aman.financial_litracy_app.payment.PaymentScreen
import com.aman.financial_litracy_app.viewmodel.AuthViewModel
import com.aman.financial_litracy_app.viewmodel.CourseViewModel


@Composable
fun App(authViewModel: AuthViewModel) {

    val navController = rememberNavController()
    val context = LocalContext.current

// Load onboarding status from SharedPreferences
    val sharedPrefs: SharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    var showOnboarding by remember { mutableStateOf(sharedPrefs.getBoolean("onboarding_complete", false)) }

    NavHost(
        navController = navController,
        startDestination =if (!showOnboarding) Routes.OnboardingScreen else Routes.Login
    ) {
        composable(Screens.Login.route) {
            Login(navController, authViewModel)
        }
        composable(Screens.SignupStart.route) {
            SignupStart(navController,authViewModel)
        }
        composable(Screens.SignupComplete.route) {
            SignupComplete(navController)
        }
        composable(Screens.ForgetPassword1.route) {
            ForgetPassword1(navController,authViewModel)
        }
        composable(Screens.ForgetPassword2.route) {
            ForgetPassword2(navController)
        }
        composable(Screens.ForgetPassword3.route) {
            ForgetPassword3(navController)
        }
        composable(Screens.ForgetPassword4.route) {
            ForgetPassword4(navController)
        }
        composable(Screens.SelectClass.route) {
            SelectClass(navController)
        }
        composable(Screens.HomeScreen.route) {
            HomeScreen(navController,authViewModel)
        }
        composable(Screens.OnboardingScreen.route) {
            OnboardingScreen(navController) {
                sharedPrefs.edit().putBoolean("onboarding_complete", true).apply()
                navController.navigate(Routes.Login) {
                    popUpTo(Routes.OnboardingScreen) { inclusive = true }
                }
            }
        }
        composable(Screens.LeftNavigationDrawer.route){
            LeftNavigationDrawer(navController,authViewModel)
        }



        composable(Screens.CourseDetailScreen.route){
            CourseDetailScreen(navController)
        }
        composable(Screens.CourseListScreen.route){
            CourseListScreen(courseViewModel = CourseViewModel(),navController)
        }


        composable(Screens.NotificationScreen.route){
            NotificationScreen(navController)
        }
        composable(Screens.AboutUsScreen.route){
            AboutUsScreen(navController)
        }
        composable(Screens.BookAWorkshopScreen.route){
            BookAWorkshopScreen(navController)
        }
        composable(Screens.ContactUsScreen.route){
            ContactUsScreen(navController)
        }
        composable(Screens.MyAccountScreen.route){
            MyAccountScreen(navController)
        }
        composable(Screens.TermsAndConditionScreen.route){
            TermsAndConditionScreen(navController)
        }
        composable(Screens.PaymentScreen.route){
            PaymentScreen(navController)
        }
        composable(Screens.EmailOtpVerification.route){
            EmailOtpVerification(navController)
        }
        composable(Screens.ResetPassword.route){
            ResetPasswordScreen(navController)
        }
        composable(Screens.ResetPassword02.route){
            ResetPassword02(navController)
        }
        composable(Screens.SuccessPopup.route){
            SuccessPopup(navController)
        }
        composable(Screens.UnSuccessfulPopup.route){
            UnSuccessfullPopUpScreen(navController)
        }
        composable(Screens.SuccessfulLogin.route){
            SuccessfulLogin(navController)
        }
        composable(Screens.UnsuccessfulLogin.route){
            UnsuccessfulLogin(navController,authViewModel)
        }


    }
}





