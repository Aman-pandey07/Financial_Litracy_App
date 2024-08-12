package com.aman.financial_litracy_app.onboard

import androidx.annotation.DrawableRes
import com.aman.financial_litracy_app.R

sealed class OnboardingModel(
    @DrawableRes val image:Int,
    val title:String,
    val description:String
) {
   data object FirstPages:OnboardingModel(
       image = R.drawable.onboardingimage1,
       title ="Money Responsibility" ,
       description ="Successful money management includes keeping records of money spent" ,
   )
    data object SecondPages:OnboardingModel(
        image = R.drawable.onboardingimage2,
        title = "Saving and Investing",
        description ="Part of learning about money management includes knowing where to put savings." ,
    )
}