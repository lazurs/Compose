package com.lazurs.data.datasource

import com.lazurs.data.entity.ArticleResponseData
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Path

/**
 * Author: lazurs
 * Date: 2024-08-15
 */
interface ArticleListDataSource {
   suspend fun getArticleList(@Path("page") page: Int):ArticleResponseData
}