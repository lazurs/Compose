package testapi.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

/**
 * Author: lazurs
 * Date: 2024-09-11
 */
@Composable
fun ImageCard(text: String, painter: Painter, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier.padding(16.dp)

    ) {
        Box(
            modifier = Modifier
                .height(600.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = "this is image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Gray),
                            startY = 1200f,
                            endY = 1400f
                        )
                    )
            ) {

            }
            Box(
                contentAlignment = Alignment.BottomStart,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                Text(
                    text = text,
                    style = TextStyle(color = Color.White, fontSize = 18.sp)
                )
            }
        }
    }

}

@Composable
fun ShowText() {
    Box(
        modifier = Modifier
            .background(Color.White)
            .padding(16.dp)
            .fillMaxSize(0.5f)
    ) {
        Text(text =
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.Magenta,
                    fontSize = 18.sp
                )
            ) {
                append("Laz")
            }
            append("urs")
            withStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    fontSize = 28.sp
                )
            ) {
                append("Very")
            }
            append("Nice")

        }, color = Color.Red,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline
        )

    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ShowTextFiled() {

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember {
        SnackbarHostState()
    }
    var textFieldValue by remember {
        mutableStateOf("")
    }
    Scaffold(modifier = Modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }, floatingActionButton = {
            Button(onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(message = "hello $textFieldValue")
                }
            }) {
                Text(text = "提交")
            }
        }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(value = textFieldValue,
                label = {
                    Text(text = "输入内容")
                },
                onValueChange = {
                    textFieldValue = it
                }, modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(20.dp))

        }
    }
}