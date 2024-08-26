package com.aman.financial_litracy_app.courses

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
fun CourseListScreen() {
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

            val courseViewModel:CourseViewModel = viewModel()

            val courseList = listOf(
                CourseInfo("Financial Literacy for Beginners", "Dr. Emily Davis", "2 Months", 12, R.drawable.course_image_pay),
                CourseInfo("Understanding Credit Scores and Reports", "Professor Mark Johnson", "1 Month", 8, R.drawable.course_image_pay),
                CourseInfo("Budgeting and Saving Strategies", "Financial Advisor Sarah Lee", "3 Weeks", 6, R.drawable.course_image_pay),
                CourseInfo("Investing Basics: Stocks, Bonds, and Mutual Funds", "Investment Expert David Kim", "4 Months", 16, R.drawable.course_image_pay),
                CourseInfo("Retirement Planning: 401(k)s, IRAs, and Social Security", "Retirement Planner Karen Taylor", "2 Months", 10, R.drawable.course_image_pay),
                CourseInfo("Personal Finance for College Students", "Student Financial Advisor Alex Brown", "1 Week", 4, R.drawable.course_image_pay),
                CourseInfo("Debt Management and Repayment Strategies", "Debt Counselor Michael White", "3 Months", 12, R.drawable.course_image_pay),
                CourseInfo("Understanding Taxes and Filing Your Returns", "Tax Accountant Lisa Nguyen", "2 Months", 8, R.drawable.course_image_pay),
                CourseInfo("Building Wealth and Financial Independence", "Financial Coach Emily Chen", "6 Months", 20, R.drawable.course_image_pay),
                CourseInfo("Financial Planning for Entrepreneurs", "Small Business Advisor David Lee", "4 Months", 16, R.drawable.course_image_pay)
            )
            LazyColumn(
                modifier = Modifier.padding(it)
            ){
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
fun CourseListScreenPrevi() {
    CourseListScreen()
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


data class CourseInfo(
    val productName: String,
    val instructorName: String,
    val duration: String,
    val numberOfLessons: Int,
    val imagePlaceholder: Int
)

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