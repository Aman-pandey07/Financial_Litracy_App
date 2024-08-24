package com.aman.financial_litracy_app.leftnavigationdrawer


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aman.financial_litracy_app.R

@Composable
fun LeftNavigationDrawer() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(text = "My Profile", modifier = Modifier.fillMaxWidth())
        // Profile details section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
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
        Divider()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            NavigationItem(icon = R.drawable.home_icon, text = "Home")
            NavigationItem(icon = R.drawable.book_icon, text = "Book A Workshop")
            NavigationItem(icon = R.drawable.courses_icon, text = "Courses")
            NavigationItem(icon = R.drawable.about_us_icon, text = "About Us")
            NavigationItem(icon = R.drawable.contact_us_icon, text = "Contact Us")
            NavigationItem(icon = R.drawable.terms_and_conditions_icon, text = "Terms and Conditions")
            NavigationItem(icon = R.drawable.notification_icon, text = "Notification")
            NavigationItem(icon = R.drawable.my_account_icon, text = "My Account")
            NavigationItem(icon = R.drawable.reset_password_icon, text = "Reset password")
            NavigationItem(icon = R.drawable.logout_icon, text = "Logout")
        }
    }
}





@Preview(showBackground = true)
@Composable
fun LeftNavigationDrawerPreview() {
    LeftNavigationDrawer()
}
@Composable
fun NavigationItem(icon: Int, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { }
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