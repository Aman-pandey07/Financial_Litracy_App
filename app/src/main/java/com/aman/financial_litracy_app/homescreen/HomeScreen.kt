package com.aman.financial_litracy_app.homescreen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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



                Text(text = "Hii this is area to fill honestly i have not done work today just to maintain streak i am pushing rubbish on gothub")

                HorizontalCardList(courses = dummyCourses)

                Row {
                    Text(text = "Popular courses", modifier = Modifier.weight(1f),)
                    TextButton(onClick = { /*TODO*/ }, modifier = Modifier.weight(1f)) {
                        Text(text = "See all")
                    }
                }

                HorizontalCardList1(courses = dummyCourses1)





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
                    .padding(horizontal = 8.dp, vertical = 8.dp)
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



// horizontal list of card

val dummyCourses = listOf(
    Course(
        imageResId = R.drawable.author_image, // Replace with actual image resource
        title = "Learn Kotlin Programming",
        price = "$19.99",
        author = "John Doe",
        duration = "3 hours"
    ),
    Course(
        imageResId = R.drawable.author_image, // Replace with actual image resource
        title = "Android App Development",
        price = "$24.99",
        author = "Jane Smith",
        duration = "5 hours"
    ),
    Course(
        imageResId = R.drawable.author_image, // Replace with actual image resource
        title = "Web Development Basics",
        price = "$14.99",
        author = "Michael Johnson",
        duration = "4 hours"
    ),
    // Add more courses as needed
)
data class Course(
    val imageResId: Int,
    val title: String,
    val price: String,
    val author: String,
    val duration: String
)
@Composable
fun HorizontalCardList(courses: List<Course>) {
    LazyRow {
        items(courses) { course ->
            CourseCard(course)
        }
    }
}
@Composable
fun CourseCard(course: Course) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(200.dp), // Adjust card width as needed
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = course.imageResId),
                contentDescription = null, // Add content description for accessibility
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = course.title,
                fontWeight = FontWeight.Bold
            )
            Text(text = course.price, color = Color.Blue)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.author_image), // Replace with actual author image
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = course.author)
            }
            Text(text = course.duration)
        }
    }
}


// the course list data
data class Course1(
    val imageResId: Int? = null, // Optional image resource
    val title: String,
    val price: String,
    val author: String,
    val duration: String
)

@Composable
fun HorizontalCardList1(courses: List<Course1>) {
    LazyColumn (modifier = Modifier.fillMaxWidth()){
        items(courses) { course ->
            CourseCard1(course)
        }
    }
}

@Composable
fun CourseCard1(course: Course1) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), // Adjust card width as needed
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {

        Row {
            course.imageResId?.let {
                Image(
                    painter = painterResource(id = it),
                    contentDescription = null, // Add content description for accessibility
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    contentScale = ContentScale.Crop
                )
            }

//            Spacer(modifier = Modifier.height(8.dp))
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = course.title,
                    fontWeight = FontWeight.Bold
                )
                Text(text = course.price, color = Color.Blue)
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = course.author)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = course.duration)
                }
            }
        }

    }
}


val dummyCourses1 = listOf(
    Course1(
        imageResId = R.drawable.author_image, // Replace with actual image resource
        title = "Kotlin Fundamentals",
        price = "$19.99",
        author = "Alex Smith",
        duration = "3 hours"
    ),
    Course1(
        imageResId = R.drawable.author_image, // Replace with actual image resource
        title = "Android Jetpack Compose",
        price = "$24.99",
        author = "Emily Johnson",
        duration = "5 hours"
    ),
    Course1(
        imageResId = R.drawable.author_image,
        title = "Database Design", // Example without image
        price = "$14.99",
        author = "David Brown",
        duration = "4 hours"
    ),
    Course1(
        imageResId = R.drawable.author_image, // Replace with actual image resource
        title = "Machine Learning Basics",
        price = "$29.99",
        author = "Sarah Lee",
        duration = "6 hours"
    )
)