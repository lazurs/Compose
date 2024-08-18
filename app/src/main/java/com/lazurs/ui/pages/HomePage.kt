package com.lazurs.ui.pages

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lazurs.base.ResponseState
import com.lazurs.ui.component.LoadingPage
import com.lazurs.ui.viewmodel.MainViewModel

/**
 * Author: lazurs
 * Date: 2024-08-14
 */
const val HOMEPAGETAG = "Home_Page"
@Composable
fun HomePage(mainViewModel: MainViewModel= hiltViewModel()){
    val articlesRes by mainViewModel.articles.collectAsState()
    Surface(modifier = Modifier.fillMaxSize()) {
        when(articlesRes){
            is ResponseState.Loading->{
                //todo loading
                 LoadingPage()
            }
            is ResponseState.Error->{
                //todo error
            }
            is ResponseState.Success->{
               val resData = (articlesRes as ResponseState.Success).data
                Log.i(HOMEPAGETAG,"Success ${resData.data}")
            }
        }
    }
}