


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
import com.aman.financial_litracy_app.navigation.Screens
import com.aman.financial_litracy_app.onboard.OnboardingScreen




@Composable
fun App() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination =Routes.OnboardingScreen
    ) {
        composable(Screens.Login.route) {
            Login()
        }
        composable(Screens.SignupStart.route) {
            SignupStart()
        }
        composable(Screens.SignupComplete.route) {
            SignupComplete(navController)
        }
        composable(Screens.ForgetPassword1.route) {
            ForgetPassword1()
        }
        composable(Screens.ForgetPassword2.route) {
            ForgetPassword2()
        }
        composable(Screens.ForgetPassword3.route) {
            ForgetPassword3()
        }
        composable(Screens.ForgetPassword4.route) {
            ForgetPassword4(navController)
        }
        composable(Screens.SelectClass.route) {
            SelectClass()
        }
        composable(Screens.HomeScreen.route) {
            HomeScreen()
        }
        composable(Screens.OnboardingScreen.route) {
            OnboardingScreen(navController) {
                navController.navigate(Routes.Login)
            }
        }
    }
}


//             navController.popBackStack() this is for back button navigation


