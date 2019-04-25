package com.somenewsapp.data.model

import com.google.gson.annotations.SerializedName

data class HeadlineResponse(@SerializedName("totalResults")
                            val totalResults: Int = 0,
                            @SerializedName("articles")
                            val articles: List<ArticlesItem>?,
                            @SerializedName("status")
                            val status: String = "")