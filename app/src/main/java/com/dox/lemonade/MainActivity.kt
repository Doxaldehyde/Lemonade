package com.dox.lemonade


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dox.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                Lemonade()
            }
        }
    }
}

@Preview
@Composable
fun Lemonade(){
    LemonadeWithImage()
}

@Composable
fun LemonadeWithImage() {
    var result by remember{ mutableStateOf(1)}
     when(result){
        1 -> Column(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Text(text = stringResource(R.string.select), fontSize = 18.sp)
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(onClick = { result = 2 },
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(1.dp, Color.Blue)
            ) {
                Image(painter = painterResource(R.drawable.lemon_tree),
                    contentDescription = result.toString()
                )
            }

        }
        2 -> Column(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Text(text = stringResource(R.string.squeeze), fontSize = 18.sp)
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(onClick = { result = (2..3).random()},
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(1.dp, Color.Blue)
            ) {
                Image(painter = painterResource(R.drawable.lemon_squeeze),
                    contentDescription = result.toString()
                )
            }

        }
        3 -> Column(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Text(text = stringResource(R.string.drink), fontSize = 18.sp)
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(onClick = { result = 4 },
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(1.dp, Color.Blue)
            ) {
                Image(painter = painterResource(R.drawable.lemon_drink),
                    contentDescription = result.toString()
                )
            }

        }
        4 -> Column(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Text(text = stringResource(R.string.empty), fontSize = 18.sp)
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(onClick = { result = 1 },
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(1.dp, Color.Blue)
            ) {
                Image(painter = painterResource(R.drawable.lemon_restart),
                    contentDescription = result.toString()
                )
            }

        }
        else -> R.drawable.lemon_tree
    }

}