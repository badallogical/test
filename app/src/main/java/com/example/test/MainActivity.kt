package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test.ui.theme.FeedScreen
import com.example.test.ui.theme.TestTheme

class MainActivity : ComponentActivity() {

    val posts = listOf<Post>(

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTheme {
                FeedScreen()
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
        var state by remember { mutableStateOf(0) }
        val titles = listOf("Tab 1", "Tab 2", "Tab 3 with lots of text")
        Column {
            TabRow(selectedTabIndex = state) {
                titles.forEachIndexed { index, title ->
                    Tab(
                        selected = state == index,
                        onClick = { state = index },
                        text = { Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis) }
                    )
                }
            }
            if( state == 0 ){

            }
        }
    }
}