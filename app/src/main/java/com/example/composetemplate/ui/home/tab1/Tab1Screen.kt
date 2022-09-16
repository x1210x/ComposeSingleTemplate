package com.example.composetemplate.ui.home.tab1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Tab1Screen(
    viewModel: Tab1ViewModel = viewModel()
) {
    LaunchedEffect(true) {
        viewModel.init()
    }

    val uiState = viewModel.uiState
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Red.copy(0.3f))) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = uiState.text
        )
    }
}