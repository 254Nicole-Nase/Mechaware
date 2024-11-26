package com.example.mechaware.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun FeedbackScreen() {
    var feedback = TextFieldValue("")

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Give Feedback", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = feedback,
            onValueChange = { feedback = it },
            label = { Text("Enter your feedback") },
            modifier = Modifier.fillMaxWidth().height(200.dp)
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
