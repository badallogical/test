package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.test.ui.theme.MyAppNavHost
import com.example.test.ui.theme.TestTheme

class MainActivity : ComponentActivity() {

    val posts = listOf<Post>(

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTheme {
               MyAppNavHost()
            }
        }
    }
}

@Composable
fun Feeds(name: String, modifier: Modifier) {
    Text(name,modifier)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestTheme {
        MyAppNavHost()
    }
}