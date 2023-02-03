package com.example.jetpackcomponentscatalogue

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomponentscatalogue.ui.theme.JetpackComponentsCatalogueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComponentsCatalogueTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    var iconState by rememberSaveable {
                        mutableStateOf(false)
                    }
                    Column {
//                        IconComponent(iconState) { iconState = !iconState }
                        ProgressComponent()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    var test = true
    JetpackComponentsCatalogueTheme {
        ProgressComponent()
    }
}

@Composable
fun ProgressComponent() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)) {
        CircularProgressIndicator()
        LinearProgressIndicator()
    }
}

@Composable
fun IconComponent(value: Boolean, onChangeValue: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Icon(
            imageVector = if (value) Icons.Rounded.Favorite  else Icons.Rounded.FavoriteBorder,
            contentDescription = "Icon",
            tint = Color.Red,
            modifier = Modifier.clickable { onChangeValue() }
        )
    }
}

@Composable
fun ImageComponentAdvance() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, Color.Red, CircleShape)
    )
}

@Composable
fun ImageComponent() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        alpha = 0.5f
    )
}

@Composable
fun ButtonComponent() {
    var enable by rememberSaveable {
        mutableStateOf(true)
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { enable = false }, enabled = enable, colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta, contentColor = Color.Blue
            ), border = BorderStroke(5.dp, Color.Green)
        ) {
            Text(text = "Hola")
        }

        OutlinedButton(
            onClick = { enable = false }, enabled = enable,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Blue,
                disabledBackgroundColor = Color.Blue,
                disabledContentColor = Color.Red
            ),
        ) {
            Text(text = "Hola")
        }

        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Hola")
        }
    }
}

@Composable
fun TextFieldOutlinedComponent(value: String, onChange: (String) -> Unit) {
    OutlinedTextField(value,
        onValueChange = { onChange(it) },
        modifier = Modifier.padding(24.dp),
        label = { Text(text = "Holiwis") })
}

@Composable
fun TextFieldAdvance() {
    var input by remember { mutableStateOf("") }
    TextField(value = input, onValueChange = {
        input = if (it.contains("a")) {
            it.replace("a", "")
        } else {
            it
        }
    }, label = { Text(text = "Introduce tu nombre", color = Color.Gray) })
}

@Composable
fun TextFieldComponent() {
    var myText by rememberSaveable { mutableStateOf("jhonatan") }
    TextField(value = myText, onValueChange = { myText = it })
}

@Composable
fun TextComponent() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo", color = Color.Blue)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Light)
        Text(text = "Esto es un ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            text = "Esto es un ejemplo", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.Underline, TextDecoration.LineThrough)
                )
            )
        )
        Text(text = "Esto es un ejemplo", fontSize = 30.sp)
    }
}