package com.lazurs.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.lazurs.ui.navigation.AppNavigationGraph

import com.lazurs.ui.theme.MyComposeProjectTheme
import com.lazurs.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeProjectTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Blue)
                ) {
                    AppEntryPoint()
                }

            }
        }
    }
}
@Composable
fun AppEntryPoint(){
   AppNavigationGraph()
}


