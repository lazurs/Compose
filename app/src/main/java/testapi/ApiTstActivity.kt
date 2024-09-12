package testapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.lazurs.R
import testapi.pages.ImageCard
import testapi.pages.ShowText
import testapi.pages.ShowTextFiled
import testapi.pages.TestColumOrRow
import testapi.pages.TestState


/**
 * Author: lazurs
 * Date: 2024-09-11
 */
class ApiTstActivity:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           // TestColumOrRow()

           // ShowCard()
          //  ShowText()
           // TestState()
            ShowTextFiled()
        }
    }


@Composable
fun ShowCard(){
    val text = "这是一张美丽的风景图这是一张美丽的风景图这是一张美丽的风景图这是一张美丽的风景图这是一张美丽的风景图"
    val painter = painterResource(id = R.drawable.ic_bc)
    ImageCard(text = text, painter = painter)
}

}