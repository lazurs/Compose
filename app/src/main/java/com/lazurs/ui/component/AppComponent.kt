package com.lazurs.ui.component

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lazurs.R
import com.lazurs.data.entity.ArticleResponseData
import com.lazurs.ui.theme.Black
import com.lazurs.ui.theme.Gray
import dagger.hilt.android.qualifiers.ApplicationContext

/**
 * Author: lazurs
 * Date: 2024-08-14
 */
@Composable
fun LoadingPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(80.dp)
                .padding(10.dp),
            color = Color.Black

        )
    }

}

@Composable
fun EmptyOrErrorPage() {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(
            modifier = Modifier.wrapContentSize(),
            text = stringResource(id = R.string.empty_text),
            color = Gray,
            fontSize = 28.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ArticleListPage(listData: ArticleResponseData) {
    LazyColumn(modifier = Modifier.fillMaxSize().background(Color.Gray)) {
        items(items = listData.data?.datas?: emptyList()) { article->

        Card(elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
            colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .padding(10.dp)

        ) {
            NormalTextComponent(textValue = article.chapterName?:"")
            NormalTextComponent(textValue = article.title?:"")
        }

        }
    }
}

@Composable
fun NormalTextComponent(textValue: String,textStyle: TextStyle = TextStyle(
    fontSize = 18.sp,
    fontWeight = FontWeight.Normal,
    color = Color.Black
)) {
    Text(
        text = textValue,
        modifier = Modifier
            .wrapContentWidth()
            .padding(16.dp)
            .wrapContentHeight(),
        style = textStyle
    )
}