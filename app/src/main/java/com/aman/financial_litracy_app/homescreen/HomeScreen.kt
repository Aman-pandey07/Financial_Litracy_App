package com.aman.financial_litracy_app.homescreen



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aman.financial_litracy_app.R
import com.aman.financial_litracy_app.navigation.Screens
import com.aman.financial_litracy_app.viewmodel.AuthState
import com.aman.financial_litracy_app.viewmodel.AuthViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController,authViewModel: AuthViewModel){

    Scaffold(
        modifier = Modifier
            .systemBarsPadding().navigationBarsPadding(),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Welcome!!")
                    // Replace with your app name
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(Screens.LeftNavigationDrawer.route)
                    }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = {
                        navController.navigate(Screens.NotificationScreen.route)
                    }) {
                        Icon(Icons.Filled.Notifications, contentDescription = "Notifications")
                    }
                }
            )
        },


        content = {
            Column(modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())) {


                SearchBar()


                val courses = listOf("All Courses","Finance","Account","Business","Balance Sheet")
                CourseSelectionRow(courses,navController)



//                Text(text = "Hii this is area to fill honestly i have not done work today just to maintain streak i am pushing rubbish on gothub")

                HorizontalCardList(courses = dummyCourses,navController)

                Row (
                    modifier = Modifier.padding(horizontal = 10.dp)
                ){
                    Text(
                        text = "Popular courses",
                        modifier = Modifier.align(Alignment.CenterVertically),
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    Spacer(modifier = Modifier.weight(1f))
                    TextButton(onClick = {
                        navController.navigate(Screens.CourseListScreen.route)
                    }) {
                        Text(text = "See all")
                    }
                }

                HorizontalCardList1(courses = dummyCourses1,navController)
                Button(
                    onClick = {
                        // Handle submit]
                        navController.navigate(Screens.CourseListScreen.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .height(50.dp)
                        .background(color = Color.White),
                    shape = RoundedCornerShape(10.dp)// Adjust button padding
                ) {
                    Text(text = "See All Courses", color = Color.White) // White text on primary background

                }






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
                        icon = painterResource(id = R.drawable.home_icon), // Replace with your home icon
                        label = "Home", // Replace with your home label
                        onClick = {
                            navController.navigate(Screens.HomeScreen.route)

                        }
                    )
                    BottomAppBarItem(
                        icon = painterResource(id = R.drawable.my_course), // Replace with your my courses icon
                        label = "My Courses", // Replace with your my courses label
                        onClick = {
                            navController.navigate(Screens.CourseListScreen.route)

                        }
                    )
                    BottomAppBarItem(
                        icon = painterResource(id = R.drawable.workshop), // Replace with your save icon
                        label = "Workshop", // Replace with your save label
                        onClick = {
                            navController.navigate(Screens.BookAWorkshopScreen.route)
                        }
                    )
                    BottomAppBarItem(
                        icon = painterResource(id = R.drawable.profile), // Replace with your profile icon
                        label = "Profile", // Replace with your profile label
                        onClick = {
                            navController.navigate(Screens.MyAccountScreen.route)
                        }
                    )
                }
                }
            )
        }



    )
}

//@Preview
//@Composable
//fun HomeScreenPreview(){
//val navController = rememberNavController()
//    HomeScreen(navController = navController)
//}

//Bottom app bar items code
@Composable
fun BottomAppBarItem(
    icon: Painter,
    label: String,
    onClick: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(onClick = onClick) {
            Icon(icon, contentDescription = label, modifier = Modifier.fillMaxWidth())
        }
//        Spacer(modifier = Modifier.padding())
        Text(text = label)
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
            .padding(16.dp)
            .background(Color.White),
        shape = RoundedCornerShape(10.dp),

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
fun CourseSelectionRow(courses: List<String>,navController: NavController) {
    var selectedCourse by remember { mutableStateOf<String?>(null) }


    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(courses) { course ->
            val isSelected = course == selectedCourse
            Box(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .background(if (isSelected) MaterialTheme.colorScheme.primary else Color.White)
                    .clickable { selectedCourse = course }
                    .border(
                        width = 2.dp,
                        color = if (isSelected) Color.Black else Color.Gray,
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = course,
                    color = if (isSelected) Color.White else Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp)
                )
            }
        }
    }
}



// horizontal list of card

val dummyCourses = listOf(
    Course(
        imageResId = R.drawable.course_image01, // Replace with actual image resource
        title = "Learn Kotlin Programming",
        price = "$19.99",
        author = "John Doe",
        duration = "3 hours"
    ),
    Course(
        imageResId = R.drawable.course_image02, // Replace with actual image resource
        title = "Android App Development",
        price = "$24.99",
        author = "Jane Smith",
        duration = "5 hours"
    ),
    Course(
        imageResId = R.drawable.course_image01, // Replace with actual image resource
        title = "Web Development Basics",
        price = "$14.99",
        author = "Mic John",
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
fun HorizontalCardList(courses: List<Course>,navController: NavController) {
    LazyRow(modifier = Modifier) {
        items(courses) { course ->
            CourseCard(course,navController = navController)
        }
    }
}
@Composable
fun CourseCard(course: Course,navController: NavController) {
    Card(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .width(200.dp)
            .background(Color.White)
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable {
                navController.navigate(Screens.CourseDetailScreen.route)
            },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(5.dp)
                .background(Color.White)
        ) {
            Image(
                painter = painterResource(id = course.imageResId),
                contentDescription = null, // Add content description for accessibility
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = course.title,
                    fontWeight = FontWeight.Bold, fontSize =14.sp, maxLines = 1
                )




            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.instructor_image), // Replace with actual author image
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = course.author)
//                Spacer(modifier = Modifier.width(.dp))
            }
            Row {
                Text(text = course.price, color = MaterialTheme.colorScheme.primary, modifier = Modifier.weight(1f))
                Text(text = course.duration)
            }

        }
    }
}


// the course list data
data class Course1(
    val imageResId: Int? = null, // Optional image resource
    val title: String,
    val price: String,
    val author: String,
    val duration: String,

)

@Composable
fun HorizontalCardList1(courses: List<Course1>, navController: NavController) {
    LazyColumn (modifier = Modifier
        .fillMaxWidth()
        .heightIn(max = 300.dp)){
        items(courses) { course ->
            CourseCard1(course,navController = navController)
        }
    }
}

@Composable
fun CourseCard1(course: Course1, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(100.dp)
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { navController.navigate(Screens.CourseDetailScreen.route) },
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 14.dp)
    ) {

        Row (
            modifier = Modifier
                .padding(5.dp)
                .background(Color.White)
        ){
            course.imageResId?.let {
                Image(
                    painter = painterResource(id = it),
                    contentDescription = null, // Add content description for accessibility
                    modifier = Modifier
                        .padding(5.dp)
                        .align(Alignment.CenterVertically)
                        .size(width = 100.dp, height = 100.dp)
                        .clip(RoundedCornerShape(10.dp)),

                    contentScale = ContentScale.Crop
                )
            }

//            Spacer(modifier = Modifier.height(8.dp))
            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxSize(),
            ) {
                Row() {
                    Text(
                        text = course.title,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        fontSize = 14.sp,
                        modifier = Modifier.weight(1f)
                    )
                    Text(text = course.price, color = Color.Blue)
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.instructor_image), // Replace with actual author image
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = course.author)
                }
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
        imageResId = R.drawable.cp01, // Replace with actual image resource
        title = "Kotlin Fundamentals",
        price = "$19.99",
        author = "Alex Smith",
        duration = "3 hours"
    ),
    Course1(
        imageResId = R.drawable.cp02, // Replace with actual image resource
        title = "Android Jetpack Compose",
        price = "$24.99",
        author = "Emily Johnson",
        duration = "5 hours"
    ),
    Course1(
        imageResId = R.drawable.cp03,
        title = "Database Design", // Example without image
        price = "$14.99",
        author = "David Brown",
        duration = "4 hours"
    ),
    Course1(
        imageResId = R.drawable.cp01, // Replace with actual image resource
        title = "Machine Learning Basics",
        price = "$29.99",
        author = "Sarah Lee",
        duration = "6 hours"
    )
)