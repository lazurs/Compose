package com.lazurs.base

/**
 * Author: lazurs
 * Date: 2024-08-15
 */
sealed class ResponseState <T>{
    data class Success<T>(val data :T): ResponseState<T>()
    data class Error<T>(val message:Any): ResponseState<T>()
     class Loading<T> : ResponseState<T>()
}