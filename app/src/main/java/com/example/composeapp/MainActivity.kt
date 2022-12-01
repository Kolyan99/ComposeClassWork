package com.example.composeapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                    SetImage()
                    SetRow()
                    SetColum()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!"
    )
}
@Composable
fun SetImage(){
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background) ,
        contentDescription = "",
        modifier = Modifier.requiredSize(50.dp)
    )
}

@Composable
fun SetRow(){
    Row {
        Text(text = "text")
        Image(painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
            modifier = Modifier.requiredSize(100.dp)
        )

    }
}
@Composable
fun SetColum(){
    var remembered by remember{ mutableStateOf("") }
    var remembered2 by remember{ mutableStateOf("") }
    Column(
        modifier = Modifier.padding(PaddingValues(top = 200.dp, start = 50.dp))

    ) {
        TextField(
            value = remembered,
            onValueChange = {
                remembered = it
            },
            label = {
                Text(text = "Enter yor name")
            }
        )
        Column() {
            TextField(
                value = remembered2,
                onValueChange = {
                    remembered2 = it
                },
                label = {
                    Text(text = "Enter yor password")
                }
            )
            val context = LocalContext.current
            Button(
                onClick = {
                   // context.startActivity(Intent(context, MainActivity::class.java))
                    Toast.makeText(context, "$remembered $remembered2", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.wrapContentHeight()
                    .wrapContentWidth()
                    .padding(PaddingValues(top = 50.dp))
                    .align(alignment = Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Button text",
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeAppTheme {
        Greeting("Android")
    }
}