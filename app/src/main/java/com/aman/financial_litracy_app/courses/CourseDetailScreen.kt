package com.aman.financial_litracy_app.courses

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aman.financial_litracy_app.R
import com.aman.financial_litracy_app.leftnavigationdrawer.ContactInfoCard


data class Course(
    val title: String,
    val duration: String,
    val lessons: Int,
    val instructor: String,
    val price: Double,
    val description: String,
    val image: Int,
    val lessonsList: List<Lesson>
)

data class Lesson(
    val title: String,
    val duration: Int
)
val lessonsList = listOf(
Lesson("Allowances and Spending Plans", 10),
Lesson("Money Responsibility", 15),
Lesson("Saving and Investing", 20),
Lesson("Comparison Shopping", 20),
Lesson("Trends In Financial Literacy", 20),
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseDetailScreen(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text ="Courses Details",
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
            Column(modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(10.dp)
                .verticalScroll(rememberScrollState())
            ) {
                Image(
                    painter = painterResource(id = R.drawable.course_detail_screen), // Replace with your image resource
                    contentDescription =null,
//                    course.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )

//                Column(
//                    modifier = Modifier
//                        .padding(vertical = 16.dp)
//                ) {
                    Text(
                        text = "2 hours 15 min.15 Lessions",
//                        "${course.duration} • ${course.lessons} Lessons",
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.padding(vertical = 5.dp)
                    )
                    Text(
                        text = "Finance Course",
//                        course.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 5.dp)
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
                        Text(text ="Vivian Neiro"
//                        "By ${course.instructor}"
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text ="$4.99/for lifetime",
//                            "$${course.price}/for lifetime",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }

//                }

                // Course description
                Text(
                    text ="Description...",
//                    course.description,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
                Text(
                    text = "Meanwhile, in a quiz that covered topics such as interest rates, inflation, bond prices, mortgages and financial risk, consumers who correctly answered at least four",
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )


                // Lessons section
                Text(
                    text ="Lessons 15 Videos)",
//                    "Lessons (${course.lessons} Videos)",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
                LazyColumn(modifier = Modifier.height(300.dp)) {
                    items(lessonsList) { lesson ->
                        LessonItem(lesson)
                    }
                }

                // Enroll button
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = { /* Handle enroll action */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .clip(RoundedCornerShape(10.dp))
                ) {
                    Text(
                        text = "Enroll Now",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    )
}

@Composable
fun LessonItem(lesson: Lesson) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp, vertical = 8.dp)
            .border(
                width = 2.dp, // Set the border width
                color = Color.LightGray // Set the border color
            )
            .clip(RoundedCornerShape(16.dp))
            .height(50.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.play_icon),
            contentDescription ="Play Icon"
        )

        Text(
            text = lesson.title,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 8.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "${lesson.duration} min",
            style = MaterialTheme.typography.bodySmall
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun CourseDetailScreenPreview(){
//    CourseDetailScreen()
//}