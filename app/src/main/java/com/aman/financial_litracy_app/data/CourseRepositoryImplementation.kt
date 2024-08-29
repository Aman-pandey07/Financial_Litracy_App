package com.aman.financial_litracy_app.data

import com.aman.financial_litracy_app.R


class CourseRepositoryImplementation: CourseRepository{
    override fun getCourses(): List<Courses> {
        return listOf(
            Courses(1, "Finance Courses",R.drawable.cp01,4.99,"Villian Neiro","2hours 15min","15 Lessons"),
            Courses(2, "Marketing Essentials", R.drawable.cp02, 3.99, "Laura Smith", "3 hours 10 min", "20 Lessons"),
            Courses(3, "Project Management", R.drawable.cp03, 6.99, "John Doe", "4 hours 5 min", "18 Lessons"),
            Courses(4, "Data Science Basics", R.drawable.cp01, 9.99, "Sarah Johnson", "5 hours 30 min", "25 Lessons"),
            Courses(5, "Web Development", R.drawable.cp02, 7.49, "Michael Brown", "6 hours 20 min", "30 Lessons"),
            Courses(6, "Digital Marketing", R.drawable.cp03, 5.49, "Emily Davis", "3 hours 50 min", "22 Lessons"),
            Courses(7, "Graphic Design", R.drawable.cp01, 4.99, "Chris Taylor", "2 hours 45 min", "17 Lessons"),
            Courses(8, "Cybersecurity Fundamentals", R.drawable.cp02, 8.99, "David Wilson", "4 hours 40 min", "19 Lessons"),
            Courses(9, "Artificial Intelligence", R.drawable.cp03, 10.99, "Anna Lee", "7 hours 15 min", "35 Lessons"),
            Courses(10, "Blockchain Technology", R.drawable.cp01, 11.99, "Paul Martinez", "6 hours 5 min", "28 Lessons")

        )
    }
}