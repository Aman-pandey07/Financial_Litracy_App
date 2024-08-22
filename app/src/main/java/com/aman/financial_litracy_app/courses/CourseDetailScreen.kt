package com.aman.financial_litracy_app.courses

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aman.financial_litracy_app.R


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


@Composable
fun CourseDetailScreen(course: Course) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        // Course image
        Spacer(modifier = Modifier.size(20.dp))
        Image(
            painter = painterResource(id = R.drawable.course_image), // Replace with your image resource
            contentDescription = course.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        // Course details
        Column(
            modifier = Modifier
                .padding(vertical = 16.dp)
        ) {
            Text(
                text = "${course.duration} • ${course.lessons} Lessons",
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = course.title,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "By ${course.instructor}",
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = "$${course.price}/for lifetime",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary
            )
        }

        // Course description
        Text(
            text = course.description,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Lessons section
        Text(
            text = "Lessons (${course.lessons} Videos)",
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        LazyColumn {
            items(course.lessonsList) { lesson ->
                LessonItem(lesson)
            }
        }

        // Enroll button
        Button(
            onClick = { /* Handle enroll action */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text(
                text = "Enroll Now",
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

@Composable
fun LessonItem(lesson: Lesson) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.play_icon), // Replace with your play icon
            contentDescription = "Play lesson",
            modifier = Modifier.size(24.dp)
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

@Preview(showBackground = true)
@Composable
fun CourseDetailScreenPreview(){
    CourseDetailScreen(course = Course(
        title = "Finance Course",
        duration = "2 hours 15 min",
        lessons = 15,
        instructor = "Vivian Neiro",
        price = 4.99,
        description = "Description...",
        image = R.drawable.course_image,
        lessonsList = listOf(
            Lesson("Lesson 1", 10),
            Lesson("Lesson 2", 15),
            Lesson("Lesson 3", 20)
        )
    ))
}