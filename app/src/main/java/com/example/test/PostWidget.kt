package com.example.test

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PostWidget(post: Post) {
    Surface() {
        Column(modifier = Modifier.fillMaxWidth()) {

            // Author and post type
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(start = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = post.user.pic,
                        contentDescription = "pic",
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(40.dp)
                    )

                    Column() {
                        Row(verticalAlignment = Alignment.CenterVertically) {

                            Text(
                                text = post.user.name,
                                fontSize = 16.sp
                            )
                            Spacer(modifier = Modifier.width(8.dp))

                            Surface(color = Color(red = 200, green = 200, blue = 200, alpha = 60)) {
                                Text(
                                    text = post.postType,
                                    fontSize = 14.sp,
                                    color = Color.Blue
                                )
                            }
                        }

                        Text(
                            text = "2 hour ago",
                            fontSize = 8.sp
                        )
                    }
                }

                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_more_horiz_24),
                        contentDescription = "more",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            // caption
            Text(
                text = post.postCaption,
                style = MaterialTheme.typography.caption,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, bottom = 8.dp)
            )

            if (post.postPic != null) {
                // pic photo
                val pics = post.postPic
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    itemsIndexed(pics) { index, item ->
                        Image(
                            painter = item,
                            contentDescription = "beautiful",
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier.width(LocalConfiguration.current.screenWidthDp.dp)
                        )
                    }
                }
            }


            // likes and comment
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { /*TODO*/ },
                        Modifier.size(20.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.love),
                            contentDescription = "Likes",
                        )
                    }
                    Text(
                        text = " ${post.likeCount} likes",
                        style = MaterialTheme.typography.caption
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { /*TODO*/ },
                        Modifier.size(20.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.chat),
                            contentDescription = "comment"
                        )
                    }
                    Text(
                        text = " ${post.commentsCount} comments",
                        style = MaterialTheme.typography.caption
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { /*TODO*/ },
                        Modifier.size(20.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.share),
                            contentDescription = "share"
                        )
                    }
                    Text(
                        text = " share",
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MyPreview() {
    PostWidget(
        post = Post(
            user = User(
                name = "Badal",
                pic = painterResource(id = R.drawable.profile1)
            ),
            postPic = listOf(
                painterResource(id = R.drawable.post1),
                painterResource(id = R.drawable.flower2)
            ),
            postType = "Marketing",
            postCaption = "It is very beautiful",
            likeCount = 189,
            commentsCount = 599
        )
    )
}