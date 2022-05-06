package com.assignment.model

import androidx.annotation.DrawableRes


sealed class MainModel {
    data class Header(
        val title: String
    ) : MainModel()

    data class Content(
        @DrawableRes val image_one: Int,
        @DrawableRes val image_two: Int,
        @DrawableRes val image_three: Int,
    ) : MainModel()

}
