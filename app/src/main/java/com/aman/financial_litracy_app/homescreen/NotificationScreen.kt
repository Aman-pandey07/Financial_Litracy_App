package com.aman.financial_litracy_app.homescreen

import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aman.financial_litracy_app.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text ="Notification",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription ="Back Button" )
                    }
                }
            )
        },
        content = {
            Column (
                modifier = Modifier.padding(it)
            ){
                // Clear All button
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.padding(16.dp)
                ) {
                    TextButton(
                        onClick = {/* Handle clear all action */},
                        ){
                        Text(text = "Clear All",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.secondary
                        )

                    }
                }

                // Notification items
                LazyColumn {
                    items(notifications) { notification ->
                        NotificationItem(notification)
                    }
                }
            }
        }
    )
}

@Preview
@Composable
fun NotificationScreenPreview(){
    NotificationScreen()
}


@Composable
fun NotificationItem(notification: com.aman.financial_litracy_app.homescreen.Notification) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()

        ) {
        // Notification icon
            Image(
                painter = painterResource(id = notification.icon),
                contentDescription =notification.title,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(5.dp)
                    .size(32.dp)
            )
//            Icon(
//                // Use notification.icon directly as resource id
//                resourceId = notification.icon,
//                contentDescription = notification.title,
//                modifier = Modifier.size(32.dp)
//            )

        // Notification details
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = notification.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = notification.message,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = notification.timestamp,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
    }
    HorizontalDivider(modifier = Modifier.padding(start = 10.dp, end = 10.dp))
}


data class Notification(
    val icon: Int,
    val title: String,
    val message: String,
    val timestamp: String
)
// Sample notification data
val notifications = listOf(
    Notification(
        icon = R.drawable.notification_icon1,
        title = "Kathryn Sent You a Message",
        message = "Tap to see the message",
        timestamp = "2 m ago"
    ),
    Notification(
        icon = R.drawable.notification_icon2,
        title = "Your course has been updated tomorrow",
        message = "Tap to see the detail shipping",
        timestamp = "2 m ago"
    ),
    Notification(
        icon = R.drawable.notification_icon3,
        title = "Try The Latest Service From Tracky!",
        message = "Let's try the feature we provide",
        timestamp = "2 m ago"
    ),
    Notification(
        icon = R.drawable.notification_icon4,
        title = "Get 20% Discount for First Transaction!",
        message = "For all transaction without requirements",
        timestamp = "10 m ago"
    ),
    Notification(
        icon = R.drawable.notification_icon4,
        title = "Get 20% Discount for First Transaction!",
        message = "For all transaction without requirements",
        timestamp = "10 m ago"
    ),
    Notification(
        icon = R.drawable.notification_icon4,
        title = "Get 20% Discount for First Transaction!",
        message = "For all transaction without requirements",
        timestamp = "10 m ago"
    )
)