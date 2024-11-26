package com.example.mechaware.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun FeedbackScreen() {
    var feedback by remember { mutableStateOf("") }
    var feedbackType by remember { mutableStateOf("General") }
    val feedbackTypes = listOf("General", "Bug Report", "Feature Request")
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Give Feedback", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        // Feedback type dropdown
        Box {
            TextButton(onClick = { expanded = true }) {
                Text(feedbackType)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                feedbackTypes.forEach { type ->
                    DropdownMenuItem(
                        text = { Text(text = type) },
                        onClick = {
                            feedbackType = type
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = feedback,
            onValueChange = { feedback = it },
            label = { Text("Enter your feedback") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { /* Handle submit feedback */ }) {
            Text("Submit Feedback")
        }
    }
}

@Preview
@Composable
fun FeedbackScreenPreview() {
    FeedbackScreen()
}