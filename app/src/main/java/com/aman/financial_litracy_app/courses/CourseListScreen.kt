package com.aman.financial_litracy_app.courses

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aman.financial_litracy_app.R
import com.aman.financial_litracy_app.viewmodel.CourseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseListScreen(courseViewModel: CourseViewModel) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text ="All Courses",
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




            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(it)
            ){
                item {
                    AllCoursesHeader()
                }
                items(courseViewModel.getCourses()){ course ->
                    ProductInfoCard(
                        productName = course.courseName,
                        instructorName = course.courseInstructor,
                        duration = course.courseDuration,
                        numberOfLessons = course.courseDescription,
                        imagePlaceholder = course.courseImage
                    )
                }
            }

            //hardcoded data
//            LazyColumn(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(it)
//            ){
//                item {
//                    // AllCoursesHeader at the top of LazyColumn
//                    AllCoursesHeader()
//                }
//
//                items(courseList){course->
//                    com.aman.financial_litracy_app.payment.ProductInfoCard(
//                        productName = course.productName,
//                        instructorName = course.instructorName,
//                        duration = course.duration,
//                        numberOfLessons = course.numberOfLessons,
//                        imagePlaceholder = course.imagePlaceholder
//                    )
//                }
//            }
        }
    )
}

@Preview
@Composable
fun CourseListScreenPreview() {
    CourseListScreen(courseViewModel = CourseViewModel())
}

@Composable
fun ProductInfoCard(
    productName: String,
    instructorName: String,
    duration: String,
    numberOfLessons: String,
    imagePlaceholder: Int
) {
    Card (
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(),
        elevation = CardDefaults.cardElevation(),
        border = BorderStroke(1.dp, Color.Gray),
        content={
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ){
                // Image placeholder
                Image(
                    painter = painterResource(id = imagePlaceholder),
                    contentDescription = "Product image",
                    modifier = Modifier
                        .padding(2.dp)
                        .size(80.dp)
                )

                Column(modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = productName, style = MaterialTheme.typography.titleLarge)
                    Text(text = instructorName, style = MaterialTheme.typography.labelSmall)
                    Text(text = "$duration • $numberOfLessons Lessons", style = MaterialTheme.typography.labelSmall)
                }
            }
        }
    )
}




@Composable
fun AllCoursesHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = "All Courses (25 Results)",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.weight(1f)
        )
    }
}