package com.lazurs.ui.component

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.lazurs.R
import com.lazurs.data.entity.ArticleBean
import com.lazurs.data.entity.ArticleResponseData
import com.lazurs.ui.theme.Gray

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
    Column(
        modifier = Modifier.fillMaxSize(),
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
    val dataList = listData.data?.datas ?: emptyList()
    var showList by remember {
        mutableStateOf(dataList)
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
     Log.e("zsddd","recompose1")
        items(items = showList) { article ->
            Card(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(
                    corner = CornerSize(16.dp)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .padding(10.dp)

            ) {
                Log.e("zsddd","recompose2")
                Box(modifier = Modifier.fillMaxSize()) {
                    Log.e("zsddd","recompose3")
                    Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight(), verticalAlignment = Alignment.CenterVertically
                        ) {
                            UserIconComponent(url = "https://www.wanandroid.com/blogimgs/42da12d8-de56-4439-b40c-eab66c227a4b.png")
                            NormalTextComponent(textValue = article.author ?: "")
                        }
                        DesTextComponent(textValue = article.title ?: "")
                    }
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(
                                start = 8.dp, bottom = 12.dp
                            )
                    ) {
                            BottomTextComponent(textValue = article.chapterName ?: "")
                    }
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(
                                end = 16.dp, bottom = 8.dp
                            )
                    ) {
                        FavoriteImageComponent(article.isFavorite) {
                            Log.e("zsdddd","onclick")
                            showList = showList.mapIndexed{ i, item->
                                if (showList.indexOf(article)==i){
                                    article.copy(isFavorite = !item.isFavorite)
                                }else{
                                    item
                                }
                            }.toMutableList()
                        }
                    }
                }

            }

        }
    }
}

@Composable
fun NormalTextComponent(
    textValue: String, textStyle: TextStyle = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        color = Color.Black
    )
) {
    Text(
        text = textValue,
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(start = 10.dp, end = 8.dp),
        style = textStyle,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis

    )
}

@Composable
fun DesTextComponent(
    textValue: String, textStyle: TextStyle = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        color = Color.Black
    )
) {
    Text(
        text = textValue,
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(start = 10.dp, end = 8.dp, top = 10.dp),
        style = textStyle,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis

    )
}

@Composable
fun BottomTextComponent(
    textValue: String, textStyle: TextStyle = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        color = Color.Black
    )
) {
    Text(
        text = textValue,
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(start = 10.dp, end = 8.dp),
        style = textStyle,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}
@Composable
fun FavoriteImageComponent(isLike:Boolean,onClick: () -> Unit){
    Log.e("zsdd","dianji"+isLike)
    val isFavorite by remember(isLike) {
        mutableStateOf(isLike)
    }
    Image(painter =
        if (isFavorite){
            painterResource(id = R.mipmap.icon_like)
        }else{
            painterResource(id = R.mipmap.icon_unlike)
        }, contentDescription = "",
        modifier = Modifier
            .size(40.dp, 40.dp)
            .clickable(onClick = onClick))
}

@Composable
fun UserIconComponent(url: String) {
    AsyncImage(
        modifier = Modifier
            .width(40.dp)
            .height(
                40.dp
            )
            .padding(start = 10.dp),
        model = ImageRequest.Builder(LocalContext.current)
            .data(url).transformations(CircleCropTransformation())
            .build(), contentDescription = "",
        contentScale = ContentScale.Crop
    )
}