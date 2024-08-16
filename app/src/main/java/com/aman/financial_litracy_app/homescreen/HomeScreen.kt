package com.aman.financial_litracy_app.homescreen


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aman.financial_litracy_app.R




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                    // Replace with your app name
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle navigation drawer open */ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Handle notification click */ }) {
                        Icon(Icons.Filled.Notifications, contentDescription = "Notifications")
                    }
                }
            )
        },


        content = {
            Column(modifier = Modifier.padding(it)) {
                

                SearchBar()


                val courses = listOf("All Courses","Finance","Account","Business")
                CourseSelectionRow(courses)



                Text(text = "Hii")
            }
        },


        bottomBar ={
            BottomAppBar(
                contentColor = Color.Black,
                content = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding()
                    ) {
                    BottomAppBarItem(
                        icon = Icons.Default.Home, // Replace with your home icon
                        label = "Home", // Replace with your home label
                        onClick = { /* Handle home click */ }
                    )
                    BottomAppBarItem(
                        icon = Icons.Default.DateRange, // Replace with your my courses icon
                        label = "MyCourses", // Replace with your my courses label
                        onClick = { /* Handle my courses click */ }
                    )
                    BottomAppBarItem(
                        icon = Icons.Default.PlayArrow, // Replace with your save icon
                        label = "Save", // Replace with your save label
                        onClick = { /* Handle save click */ }
                    )
                    BottomAppBarItem(
                        icon = Icons.Default.AccountCircle, // Replace with your profile icon
                        label = "Profile", // Replace with your profile label
                        onClick = { /* Handle profile click */ }
                    )
                }
                }
            )
        }



    )
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}

//Bottom app bar items code
@Composable
fun BottomAppBarItem(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Column {
            Icon(icon, contentDescription = label, modifier = Modifier.fillMaxWidth())
            Text(text = label)
        }

    }
}

// Search bar code
@Composable
fun SearchBar() {
    var searchText by remember { mutableStateOf("") }

    OutlinedTextField(
        value = searchText,
        onValueChange = { searchText = it },
        placeholder = { Text(text = "Search any courses") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null
            )
        },
        trailingIcon = {
            if (searchText.isNotEmpty()) {
                IconButton(onClick = { searchText = "" }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_clear),
                        contentDescription = null
                    )
                }
            }
        }
    )
}

@Composable
fun CourseSelectionRow(courses: List<String>) {
    var selectedCourse by remember { mutableStateOf<String?>(null) }


    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(courses) { course ->
            val isSelected = course == selectedCourse
            Box(
                modifier = Modifier
                    .padding(horizontal = 8.dp,vertical = 8.dp)
                    .background(if (isSelected) Color.Blue else Color.LightGray)
                    .clickable { selectedCourse = course },
                contentAlignment = Alignment.Center,

            ) {
                Text(
                    text = course,
                    color = if (isSelected) Color.White else Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }
}

