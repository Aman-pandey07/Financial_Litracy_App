package com.aman.financial_litracy_app.viewmodel

import androidx.lifecycle.ViewModel
import com.aman.financial_litracy_app.data.CourseRepository
import com.aman.financial_litracy_app.data.CourseRepositoryImplementation
import com.aman.financial_litracy_app.data.Courses

class CourseViewModel: ViewModel(){
    private val courseRepository:CourseRepository = CourseRepositoryImplementation()
    fun getCourses() = courseRepository.getCourses()


}
