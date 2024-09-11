package com.lazurs.data.entity

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.lazurs.base.ResponseState
import com.lazurs.ui.component.ArticleListPage
import com.lazurs.ui.component.EmptyOrErrorPage
import com.lazurs.ui.component.LoadingPage
import com.lazurs.ui.pages.HOMEPAGETAG
import com.lazurs.ui.repository.WanAndroidRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.toList

/**
 * Author: lazurs
 * Date: 2024-09-01
 */
class ArticlePagingDataSource(private val repo:WanAndroidRepository) :PagingSource<Int,ArticleBean>(){
    override fun getRefreshKey(state: PagingState<Int, ArticleBean>): Int? {
      return state.anchorPosition?.let { position->
        val page = state.closestPageToPosition(position)
          page?.prevKey?.minus(0)?:page?.nextKey?.plus(1)
      }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleBean> {
      return try {
          val page = params.key?:0
          val response = repo.getArticleList(page).toList()[0]
          var pageData = emptyList<ArticleBean>()
          when(response){
              is ResponseState.Loading->{

              }
              is ResponseState.Error->{

              }
              is ResponseState.Success->{
                  val resData = (response as ResponseState.Success).data
                  Log.i(HOMEPAGETAG,"Success ${resData.data}")
                  pageData = resData.data?.datas?: emptyList()
              }
          }
          LoadResult.Page(
              data = pageData,
              prevKey = null,
              nextKey = page + 1

          )
      }catch (e:Exception){
          LoadResult.Error(e)
      }
    }
}