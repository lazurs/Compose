package com.lazurs.data.entity

/**
 * Author: lazurs
 * Date: 2024-08-14
 */
data class ArticleResponseData(val data:ArticleListBean?=null)
data class ArticleListBean(val curPage:Int,val datas:List<ArticleBean>)
data class ArticleBean(val shareUser:String?,
    val niceDate:String?,val chapterName:String?,
val title:String?)
