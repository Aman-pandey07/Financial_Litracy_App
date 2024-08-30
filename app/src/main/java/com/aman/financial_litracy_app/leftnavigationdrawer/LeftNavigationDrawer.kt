package com.aman.financial_litracy_app.leftnavigationdrawer


import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aman.financial_litracy_app.R
import com.aman.financial_litracy_app.navigation.Screens
import com.aman.financial_litracy_app.viewmodel.AuthState
import com.aman.financial_litracy_app.viewmodel.AuthViewModel

@Composable
fun LeftNavigationDrawer(navController: NavController,authViewModel: AuthViewModel) {
    val authState = authViewModel.authState.observeAsState()
    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Unauthenticated -> navController.navigate(Screens.Login.route)
            else->Unit
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .background(color = Color.White)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "My Profile", modifier = Modifier.fillMaxWidth())
        // Profile details section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .clickable {
                    navController.navigate(Screens.MyAccountScreen.route)
                }
        ) {
            // Profile image
            Image(
                painter = painterResource(id = R.drawable.profile_image), // Replace with your image resource
                contentDescription = "Profile image",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )

            // Profile name and contact
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = "Micheal Sam",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "+01 65841542265",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

        }

        // Navigation options
        HorizontalDivider()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            NavigationItem(icon = R.drawable.home_icon, text = "Home", onClick = { navController.navigate(Screens.HomeScreen.route) })
            NavigationItem(icon = R.drawable.book_icon, text = "Book A Workshop",onClick = { navController.navigate(Screens.BookAWorkshopScreen.route) })
            NavigationItem(icon = R.drawable.courses_icon, text = "Courses",onClick = { navController.navigate(Screens.CourseListScreen.route) })
            NavigationItem(icon = R.drawable.about_us_icon, text = "About Us",onClick = { navController.navigate(Screens.AboutUsScreen.route) })
            NavigationItem(icon = R.drawable.contact_us_icon, text = "Contact Us",onClick = { navController.navigate(Screens.ContactUsScreen.route)})
            NavigationItem(icon = R.drawable.terms_and_conditions_icon, text = "Terms and Conditions",onClick = { navController.navigate(Screens.TermsAndConditionScreen.route) })
            NavigationItem(icon = R.drawable.notification_icon, text = "Notification",onClick = { navController.navigate(Screens.NotificationScreen.route) })
            NavigationItem(icon = R.drawable.my_account_icon, text = "My Account",onClick = { navController.navigate(Screens.MyAccountScreen.route) })
            NavigationItem(icon = R.drawable.reset_password_icon, text = "Reset password",onClick = {navController.navigate(Screens.ResetPassword.route) })

            Spacer(modifier = Modifier.weight(1f))
            HorizontalDivider()
            NavigationItem(icon = R.drawable.logout_icon, text = "Logout",onClick = {authViewModel.logout() })
        }
    }
}





//@Preview(showBackground = true)
//@Composable
//fun LeftNavigationDrawerPreview() {
//    LeftNavigationDrawer()
//}
@Composable
fun NavigationItem(icon: Int, text: String,onClick: () -> Unit ) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {onClick() }
            .size(40.dp)
    ) {

        Icon(
            painter = painterResource(id = icon),
            contentDescription = text,
            modifier = Modifier
                .size(24.dp)
                .padding(end = 8.dp)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}