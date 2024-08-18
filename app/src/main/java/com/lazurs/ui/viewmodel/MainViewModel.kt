package com.lazurs.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lazurs.base.ResponseState
import com.lazurs.data.entity.ArticleBean
import com.lazurs.data.entity.ArticleResponseData
import com.lazurs.ui.repository.WanAndroidRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Author: lazurs
 * Date: 2024-08-14
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val wanAndroidRepository: WanAndroidRepository
) : ViewModel() {
    private val _articles: MutableStateFlow<ResponseState<ArticleResponseData>> =
        MutableStateFlow(ResponseState.Loading())
    val articles: StateFlow<ResponseState<ArticleResponseData>> = _articles

    init {
        getArticles(0)
    }

    fun getArticles(page: Int) {
        viewModelScope.launch {
            wanAndroidRepository.getArticleList(page = page)
                .collectLatest { response ->
                    _articles.value = response
                }
        }
    }


    companion object {
        const val TAG = "MainViewModel"
    }

}