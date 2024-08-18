package com.lazurs.ui.repository

import com.lazurs.base.ResponseState
import com.lazurs.data.datasource.ArticleListDataSource
import com.lazurs.data.entity.ArticleResponseData
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

import javax.inject.Inject

/**
 * Author: lazurs
 * Date: 2024-08-14
 */
@ViewModelScoped
class WanAndroidRepository @Inject constructor(
    private val articleDataSource: ArticleListDataSource
) {
    suspend fun getArticleList(page: Int): Flow<ResponseState<ArticleResponseData>> {
        return flow {
            emit(ResponseState.Loading())
            val response = articleDataSource.getArticleList(page)
            if (null != response.data) {
                emit(ResponseState.Success(response))
            } else {
                emit(ResponseState.Error("get data error"))
            }
        }.flowOn(Dispatchers.IO).catch { e ->
            emit(ResponseState.Error(e.localizedMessage ?: "flow error 了 "))
        }
    }
}