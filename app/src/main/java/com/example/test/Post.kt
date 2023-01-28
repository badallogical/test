package com.example.test

import androidx.compose.ui.graphics.painter.Painter

data class Post(
    val user: User,
    val postPic: List<Painter>?,
    val postCaption: String,
    val postType: String,
    val likeCount: Int,
    val commentsCount: Int )