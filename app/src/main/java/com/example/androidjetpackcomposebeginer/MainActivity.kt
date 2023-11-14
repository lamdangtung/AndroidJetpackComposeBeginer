package com.example.androidjetpackcomposebeginer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidjetpackcomposebeginer.ui.theme.AndroidJetpackComposeBeginerTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidJetpackComposeBeginerTheme {
                var inputText by remember {
                    mutableStateOf("")
                }
                var names by remember {
                    mutableStateOf(listOf<String>())
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        OutlinedTextField(
                            value = inputText,
                            onValueChange = { text: String -> inputText = text })
                        Button(
                            onClick = {
                                if (inputText.isNotBlank()) {
                                    names = names + inputText;
                                    inputText = ""
                                }
                            },
                        ) {
                            Text("Add", fontSize = 12.sp, color = Color.White)
                        }
                    }
                    LazyColumn {
                        items(names.size, itemContent = { index ->
                            Text(
                                names[index],
                                fontSize = 40.sp,
                                color = Color.Green,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            )
                            Divider()
                        })
                    }
                }
            }
        }
    }
}
