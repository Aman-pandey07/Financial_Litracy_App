


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aman.financial_litracy_app.homescreen.HomeScreen
import com.aman.financial_litracy_app.loginregistration.Login
import com.aman.financial_litracy_app.loginregistration.SelectClass
import com.aman.financial_litracy_app.loginregistration.SignupComplete
import com.aman.financial_litracy_app.loginregistration.SignupStart
import com.aman.financial_litracy_app.loginregistration.forgetpassword.ForgetPassword1
import com.aman.financial_litracy_app.loginregistration.forgetpassword.ForgetPassword2
import com.aman.financial_litracy_app.loginregistration.forgetpassword.ForgetPassword3
import com.aman.financial_litracy_app.loginregistration.forgetpassword.ForgetPassword4
import com.aman.financial_litracy_app.navigation.Routes
import com.aman.financial_litracy_app.onboard.OnboardingScreen




@Composable
fun App() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination =Routes.OnboardingScreen
    ) {
        composable(Routes.Login) {
            Login()
        }
        composable(Routes.SignupStart) {
            SignupStart()
        }
        composable(Routes.SignupComplete) {
            SignupComplete(navController)
        }
        composable(Routes.ForgetPassword1) {
            ForgetPassword1()
        }
        composable(Routes.ForgetPassword2) {
            ForgetPassword2()
        }
        composable(Routes.ForgetPassword3) {
            ForgetPassword3()
        }
        composable(Routes.ForgetPassword4) {
            ForgetPassword4()
        }
        composable(Routes.SelectClass) {
            SelectClass()
        }
        composable(Routes.HomeScreen) {
            HomeScreen(navController)
        }
        composable(Routes.OnboardingScreen) {
            OnboardingScreen(navController) { navController.navigate(Routes.Login) }
        }
    }
}





