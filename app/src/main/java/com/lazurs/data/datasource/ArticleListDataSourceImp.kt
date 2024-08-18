package com.lazurs.data.datasource

import com.lazurs.data.api.ApiService
import com.lazurs.data.entity.ArticleResponseData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Author: lazurs
 * Date: 2024-08-15
 */
class ArticleListDataSourceImp @Inject constructor(
    private val apiService: ApiService
) :
    ArticleListDataSource {
    override suspend fun getArticleList(page: Int): ArticleResponseData =
        apiService.getArticleList(page)


}