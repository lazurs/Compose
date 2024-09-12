package testapi.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random


/**
 * Author: lazurs
 * Date: 2024-09-11
 */

@Composable
fun TestColumOrRow(isRow:Boolean=false){
    if (isRow){
        Row(modifier = TestModify(),
            horizontalArrangement = Arrangement.spacedBy(2.dp,Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TestText(string = "zs")
            TestText(string = "lazurs")
            TestText(string = "lazurs2")
        }
    }else{
        Column(modifier= TestModify(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly) { //Arrangement.Absolute  RTL
            TestText(string = "zs"
            )
            TestText(string = "lazurs")

        }
    }

}

@Composable
fun TestText(string: String){
    Text(modifier = Modifier.background(Color.Gray),
       fontSize = 18.sp,
        text = "test--$string",
        )
}
@Composable
fun TestModify():Modifier{

    return Modifier
        .background(Color.Green)
        .fillMaxSize(0.8f)
        .border(5.dp, Color.Blue)
        .padding(5.dp)
        .border(5.dp, Color.Red)
}

@Composable
fun TestState(){
    var color by remember {
        mutableStateOf(Color.Blue)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxSize()
            .background(color))
       ClickBox(modifier = Modifier.weight(1f).fillMaxSize()) {
           color = it
       }
    }
}
@Composable
fun ClickBox(modifier: Modifier=Modifier,onclick:(Color)->Unit){
    Box(modifier= modifier
        .clickable {
            onclick.invoke(Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f))
        }
        .background(Color.White)) {

    }
}
