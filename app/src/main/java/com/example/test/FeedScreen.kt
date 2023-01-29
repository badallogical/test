package com.example.test.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.test.Post
import com.example.test.PostWidget
import com.example.test.R
import com.example.test.User

//@Parcelize
//data class CommentModel(
//    public val comments : List<String>
//): Parcelable

//class CommentParamType : NavType<CommentModel>(isNullableAllowed = true) {
//    override fun get(bundle: Bundle, key: String): CommentModel? {
//        return bundle.getParcelable(key)
//    }
//
//    override fun parseValue(value: String): CommentModel {
//        return Gson().fromJson(value, CommentModel::class.java)
//    }
//
//    override fun put(bundle: Bundle, key: String, value: CommentModel) {
//        bundle.putParcelable(key, value)
//    }
//}

@Composable
fun FeedScreen(navController: NavHostController) {

    val posts = listOf<Post>(
        Post(
            user = User( name = "Badal",
                pic = painterResource(id = R.drawable.profile1)
            ),
            postPic = null,
            postType = "Question",
            postCaption = "Who are you ?",
            likeCount = 189,
            commentsCount = 599,
            comments = listOf("very good", "nice", "not bad", "ohh my god")
        ),
        Post(
            user = User( name = "Manoj",
                pic = painterResource(id = R.drawable.profile1)
            ),
            postPic = listOf( painterResource(id = R.drawable.post1), painterResource(id = R.drawable.flower2 )),
            postType = "Marketing",
            postCaption = "It is very beautiful",
            likeCount = 189,
            commentsCount = 599,
            comments = listOf("very good", "nice", "not bad", "ohh my god")
        ),
        Post(
            user = User( name = "Raghu",
                pic = painterResource(id = R.drawable.profile1)
            ),
            postPic = listOf(painterResource(id = R.drawable.post2)),
            postType = "Marketing",
            postCaption = "It is very beautiful",
            likeCount = 189,
            commentsCount = 599,
            comments = listOf("very good", "nice", "not bad", "ohh my god")
        )
    )

    LazyColumn(){
        items(posts){
            post -> PostWidget(post = post, navController )
        }
    }

}

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "FeedScreen"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("FeedScreen") {
            FeedScreen ( navController )
        }

        composable(route = "commentList/{comments}" ,
            arguments = listOf(navArgument("comments"){
                type = NavType.StringType
                defaultValue = ""
                nullable = false
            } )
            ){ entry ->
            CommentScreen(  entry.arguments?.getString("comments") )
        }
    }
}

@Composable
fun CommentScreen( comment: String? ) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        val comments  = comment?.split(",") as List<String>
        TopAppBar(backgroundColor = Color.White, contentColor = Color.Black){
            Text(
                text = "Comments",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth()
            )
        }
        LazyColumn(Modifier.fillMaxWidth().padding( horizontal = 8.dp)){
            items(comments){
                comment ->  Surface(
                color = Color.White,
                elevation = 2.dp,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = comment , Modifier.padding(8.dp))
                }
                Spacer(modifier = Modifier.size(8.dp))
            }
        }
    }
}

@Preview
@Composable
fun MyPreview(){
    val comments  = listOf("very good", "nice", "not bad", "ohh my god").toString();
    comments.trim('[',']')
    CommentScreen(  comments )
}