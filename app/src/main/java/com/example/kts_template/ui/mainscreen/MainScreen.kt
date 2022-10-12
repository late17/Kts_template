package com.example.kts_template.ui.mainscreen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel,
    goToSecondScreen: (int: Int) -> Unit
) {
    val state = viewModel.state.collectAsState(initial = MainScreenState(1))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Text(text = "Here come the txt and the int of VM ${state.value.int}")
        Button(onClick = { viewModel.eventHandler(MainScreenEvent.IncrementInt) }) {
            Text(text = "Button")
        }
        Button(onClick = { goToSecondScreen(state.value.int) }) {
            Text(text = "Go To Another Screen")
        }
    }
}