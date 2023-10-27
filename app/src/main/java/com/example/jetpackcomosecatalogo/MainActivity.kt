package com.example.jetpackcomosecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomosecatalogo.ui.theme.JetpackComoseCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComoseCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyTextField()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField() {

    var myText by remember { mutableStateOf("") }

    TextField(value = myText, onValueChange = {myText = it})

}

@Composable
fun MyText() {

    Column(Modifier.fillMaxSize()) {

        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo", color = Color.Blue)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Light)
        Text(text = "Esto es un ejemplo", fontFamily = FontFamily.Cursive)
        Text(
            text = "Esto es un ejemplo",
            textDecoration = TextDecoration.LineThrough
        )
        Text(
            text = "Esto es un ejemplo",
            textDecoration = TextDecoration.Underline
        )
        Text(
            text = "Esto es un ejemplo",
            textDecoration = TextDecoration.combine(
                listOf(TextDecoration.LineThrough, TextDecoration.Underline)
            )
        )

        Text(text = "Esto es un ejemplo", fontSize = 30.sp)

    }

}

@Composable
fun MyStateExample() {

    var counter by rememberSaveable {
        mutableStateOf(0)
    }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")
        }

        Text(text = "He sido pulsado $counter Veces")

    }

}

@Composable
fun MyComplexLayout() {

    Column(Modifier.fillMaxSize()) {

        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan), contentAlignment = Alignment.Center
        ) {

            Text(text = "Ejemplo1")

        }

        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {

            Box(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red), contentAlignment = Alignment.Center
            ) {

                Text(text = "Ejemplo2")

            }

            Box(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green), contentAlignment = Alignment.Center
            ) {

                Text(text = "Ejemplo3")

            }

        }

        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta), contentAlignment = Alignment.BottomCenter
        ) {

            Text(text = "Ejemplo4")

        }

    }

}

@Composable
fun MyRow() {

    Row(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
    ) {

        Text(text = "Ejemplo1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier.width(100.dp))

    }

}

@Composable
fun MyColumn() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Ejemplo 1", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo 2", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo 3", modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo 4", modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth()
                .height(100.dp)
        )
    }
}

@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.Cyan)
                .verticalScroll(
                    rememberScrollState()
                ), contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Esto es un EJEMPLO")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComoseCatalogoTheme {
        MyTextField()
    }
}