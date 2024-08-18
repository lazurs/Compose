package com.lazurs.data.api

import com.lazurs.data.entity.ArticleResponseData
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Author: lazurs
 * Date: 2024-08-14
 */
interface ApiService {

    @GET("article/list/{page}/json")
    suspend fun getArticleList(@Path("page") page: Int): ArticleResponseData
}