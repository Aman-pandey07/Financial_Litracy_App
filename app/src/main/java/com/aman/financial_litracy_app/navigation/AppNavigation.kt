


import androidx.compose.runtime.Composable
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
import com.aman.financial_litracy_app.loginregistration.login.Login
import com.aman.financial_litracy_app.loginregistration.signup.SelectClass
import com.aman.financial_litracy_app.loginregistration.signup.SignupComplete
import com.aman.financial_litracy_app.loginregistration.signup.SignupStart
import com.aman.financial_litracy_app.loginregistration.forgetpassword.ForgetPassword1
import com.aman.financial_litracy_app.loginregistration.forgetpassword.ForgetPassword2
import com.aman.financial_litracy_app.loginregistration.forgetpassword.ForgetPassword3
import com.aman.financial_litracy_app.loginregistration.forgetpassword.ForgetPassword4
import com.aman.financial_litracy_app.navigation.Routes
import com.aman.financial_litracy_app.navigation.Screens
import com.aman.financial_litracy_app.onboard.OnboardingScreen
import com.aman.financial_litracy_app.payment.PaymentScreen
import com.aman.financial_litracy_app.viewmodel.CourseViewModel


@Composable
fun App() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination =Routes.OnboardingScreen
    ) {
        composable(Screens.Login.route) {
            Login(navController)
        }
        composable(Screens.SignupStart.route) {
            SignupStart(navController)
        }
        composable(Screens.SignupComplete.route) {
            SignupComplete(navController)
        }
        composable(Screens.ForgetPassword1.route) {
            ForgetPassword1(navController)
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
            HomeScreen(navController)
        }
        composable(Screens.OnboardingScreen.route) {
            OnboardingScreen(navController) {
                navController.navigate(Routes.Login)
            }
        }
        composable(Screens.LeftNavigationDrawer.route){
            LeftNavigationDrawer()
        }



        composable(Screens.CourseDetailScreen.route){
            CourseDetailScreen(navController)
        }
        composable(Screens.CourseListScreen.route){
            CourseListScreen(courseViewModel = CourseViewModel(),navController)
        }


        composable(Screens.NotificationScreen.route){
            NotificationScreen()
        }
        composable(Screens.AboutUsScreen.route){
            AboutUsScreen()
        }
        composable(Screens.BookAWorkshopScreen.route){
            BookAWorkshopScreen()
        }
        composable(Screens.ContactUsScreen.route){
            ContactUsScreen()
        }
        composable(Screens.MyAccountScreen.route){
            MyAccountScreen()
        }
        composable(Screens.TermsAndConditionScreen.route){
            TermsAndConditionScreen()
        }
        composable(Screens.PaymentScreen.route){
            PaymentScreen()
        }


    }
}


//             navController.popBackStack() this is for back button navigation


