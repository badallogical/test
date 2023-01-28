package com.example.test.ui.theme

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.test.Post
import com.example.test.PostWidget
import com.example.test.R
import com.example.test.User

@Composable
fun FeedScreen(){

    val posts = listOf<Post>(
        Post(
            user = User( name = "Badal",
                pic = painterResource(id = R.drawable.profile1)
            ),
            postPic = null,
            postType = "Question",
            postCaption = "Who are you ?",
            likeCount = 189,
            commentsCount = 599
        ),
        Post(
            user = User( name = "Manoj",
                pic = painterResource(id = R.drawable.profile1)
            ),
            postPic = listOf( painterResource(id = R.drawable.post1), painterResource(id = R.drawable.flower2 )),
            postType = "Marketing",
            postCaption = "It is very beautiful",
            likeCount = 189,
            commentsCount = 599
        ),
        Post(
            user = User( name = "Raghu",
                pic = painterResource(id = R.drawable.profile1)
            ),
            postPic = listOf(painterResource(id = R.drawable.post2)),
            postType = "Marketing",
            postCaption = "It is very beautiful",
            likeCount = 189,
            commentsCount = 599
        )
    )

    LazyColumn(){
        items(posts){
            post -> PostWidget(post = post)
        }
    }

}

@Preview
@Composable
fun MyPreview(){
    FeedScreen()
}