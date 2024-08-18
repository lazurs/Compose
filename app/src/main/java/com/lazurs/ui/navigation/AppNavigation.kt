package com.lazurs.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lazurs.ui.pages.HomePage

/**
 * Author: lazurs
 * Date: 2024-08-14
 */
@Composable
fun AppNavigationGraph() {
   val navController = rememberNavController()
   NavHost(navController =navController , startDestination = Routers.HOME_SCREEN){
      composable(Routers.HOME_SCREEN){
      HomePage()
      }
   }
}