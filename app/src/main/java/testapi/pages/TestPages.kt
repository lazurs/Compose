package testapi.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
        .border(5.dp,Color.Blue )
        .padding(5.dp)
        .border(5.dp,Color.Red )
}