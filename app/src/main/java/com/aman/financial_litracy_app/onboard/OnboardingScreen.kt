package com.aman.financial_litracy_app.onboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(navController: NavHostController, onFinished: () -> Unit) {
    val pages = listOf(OnboardingModel.FirstPages,OnboardingModel.SecondPages)
    val pagerState = rememberPagerState (initialPage = 0){
        pages.size
    }
    val scope = rememberCoroutineScope()
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) { ButtonUI(text = "Skip",
            backgroundColor = Color. Transparent,
            textColor = Color.Gray,
            textStyle = MaterialTheme.typography.bodyMedium,
            fontSize = 20) {/* manage onclick here*/} }

        Spacer(modifier = Modifier.size(60.dp))


        HorizontalPager(state = pagerState) {index ->
            OnboardingGraphUI(onboardingModel = pages[index])
        }


        Spacer(modifier = Modifier.size(60.dp))


        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp),
                horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) { IndicatorUI(pageSize = pages.size, currentPage = pagerState.currentPage) }


        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            ButtonUI(
                text = "Continue",
                backgroundColor = MaterialTheme.colorScheme.primary,
                textColor = MaterialTheme.colorScheme.onPrimary){
                scope.launch {
                    if (pagerState.currentPage < pages.size - 1) {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    } else {
                        onFinished()
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun OnboardingScreenPreview(){
//    OnboardingScreen{
//
//    }
//}