package com.multi.trivia.data.model

import com.google.gson.annotations.SerializedName

data class QuizResponse(
    @SerializedName("response_code") val responseCode: Int,
    @SerializedName("results") val questionList: List<Question>
)