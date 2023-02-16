package com.example.jetpackcomponentscatalogue

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomponentscatalogue.ui.theme.CheckInfo
import com.example.jetpackcomponentscatalogue.ui.theme.JetpackComponentsCatalogueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComponentsCatalogueTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background)
                ) {
                    /*var options = getOptions(listOf("Yeison", "Jhonatan", "Blanca", "Yovany"))
                    var stateRadio by rememberSaveable { mutableStateOf("Aris") }
                    var show by rememberSaveable { mutableStateOf(false) }
                    var showSimpleDialog by rememberSaveable { mutableStateOf(false) }
                    var showDialogGoogle by rememberSaveable { mutableStateOf(false) }
                    var showConfirmDialog by rememberSaveable { mutableStateOf(false) }
                    var ringToneValue by rememberSaveable { mutableStateOf("") }
                    Log.i("ringtone", ringToneValue)*/

                    Column(Modifier.fillMaxWidth()) {
                        /*SimpleRecyclerView()
                        SuperHeroView()*/
//                        SuperHeroGridView()
                        //SuperHeroWhitSpecialControlsView()
                        SuperHeroStickyView()
                    }
                    /*Column(Modifier.verticalScroll(rememberScrollState())) {

                        TriStatusCheckBox()
                        options.forEach {
                            CheckBoxWithTextComponentAdvanced(it)
                        }
                        RadioButtonComponentAdvance(stateRadio) { stateRadio = it }
                        CardComponent()
                        BadgeBoxComponent()
                        DividerComponent()
                        DropDownMenuComponent()
                        BasicSlider()
                        AdvanceSlider()
                        RangeSliderComponent()
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(vertical = 20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Button(onClick = { show = !show }) {
                                Text(text = "Mostrar DialogComponent")
                            }
                            Button(onClick = { showSimpleDialog = !showSimpleDialog }) {
                                Text(text = "Mostrar SimpleCustomDialog")
                            }
                            Button(onClick = { showDialogGoogle = !showDialogGoogle }) {
                                Text(text = "Mostrar Dialog Google")
                            }
                            Button(onClick = { showConfirmDialog = !showConfirmDialog }) {
                                Text(text = "Mostrar Confirm  Dialog")
                            }
                        }
                        DialogComponent(
                            show = show,
                            onDismiss = { show = !show },
                            onConfirm = { Log.i("test", "test dialog") })
                        SimpleCustomDialog(
                            show = showSimpleDialog,
                            onDismiss = { showSimpleDialog = !showSimpleDialog })
                        CustomDialog(
                            show = showDialogGoogle,
                            onDismiss = { showDialogGoogle = !showDialogGoogle })
                        ConfirmationDialog(
                            show = showConfirmDialog,
                            onDismiss = { showConfirmDialog = !showConfirmDialog },
                            value = ringToneValue,
                            onChangeRadio = { ringToneValue = it }
                        )

                    }*/
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
        BadgeBoxComponent()
    }
}

@Composable
fun DropDownMenuComponent() {
    var selectedText by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    var desserts = listOf("Helado", "Chocolates", "Café", "Fruta", "Natilla", "Chilaquiles")

    Column(
        Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = !expanded }
                .fillMaxWidth()
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = !expanded },
            modifier = Modifier.fillMaxWidth()
        ) {
            desserts.forEach {
                DropdownMenuItem(onClick = {
                    expanded = !expanded
                    selectedText = it
                }) {
                    Text(text = it)
                }
            }
        }
    }
}

@Composable
fun DividerComponent() {
    Divider(Modifier.fillMaxWidth())
}

@Composable
fun BadgeBoxComponent() {
    BadgedBox(badge = {
        Badge(contentColor = Color.White) {
            Text(text = "1")
        }
    }) {
        Icon(imageVector = Icons.Default.Star, contentDescription = "Star")
    }
}

@Composable
fun CardComponent() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 12.dp,
        shape = MaterialTheme.shapes.small,
        backgroundColor = Color.Red,
        contentColor = Color.Green,
        border = BorderStroke(5.dp, Color.Green)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 2")
            Text(text = "Ejemplo 3")
        }
    }
}

@Composable
fun RadioButtonComponentAdvance(name: String, onItemSelected: (String) -> Unit) {

    Column(Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Aris",
                onClick = { onItemSelected("Aris") },
            )
            Text(text = "Aris")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Jhonatan",
                onClick = { onItemSelected("Jhonatan") },
            )
            Text(text = "Jhonatan")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Yovany",
                onClick = { onItemSelected("Yovany") },
            )
            Text(text = "Yovany")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Blanca",
                onClick = { onItemSelected("Blanca") },
            )
            Text(text = "Blanca")
        }
    }
}

@Composable
fun RadioButtonComponent() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = true,
            onClick = { /*TODO*/ },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Green,
                disabledColor = Color.Yellow
            ),
            enabled = false
        )
        Text(text = "ejemplo 1")
    }
}

@Composable
fun TriStatusCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var state by rememberSaveable { mutableStateOf(false) }
        CheckInfo(title = it, selected = state, onCheckedChange = { newState -> state = newState })
    }
}


@Composable
fun CheckBoxWithTextComponentAdvanced(checkInfo: CheckInfo) {
    var (title, selected, onCheckedChange) = checkInfo
    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = selected, onCheckedChange = { onCheckedChange(!selected) })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = title)
    }
}

@Composable
fun CheckBoxWithTextComponent() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Ejemplo 1")
    }
}

@Composable
fun CheckBoxComponent() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }

    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Magenta,
            checkmarkColor = Color.Blue,
            disabledColor = Color.Green,
            disabledIndeterminateColor = Color.Yellow
        )
    )
}

@Composable
fun SwitchComponent() {
    var switchState by rememberSaveable {
        mutableStateOf(true)
    }

    Switch(
        checked = switchState,
        onCheckedChange = { switchState = !switchState },
        enabled = false,
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Red,
            checkedTrackColor = Color.Green,
            uncheckedTrackColor = Color.Blue,
            uncheckedThumbColor = Color.Magenta,
            disabledCheckedThumbColor = Color.Yellow,
            disabledUncheckedThumbColor = Color.Cyan
        )
    )
}

@Composable
fun ProgressComponentAdvance() {
    var progressStatus by rememberSaveable {
        mutableStateOf(0f)
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(progress = progressStatus)

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = { if (progressStatus <= 1f) progressStatus += 0.1f }) {
                Text(text = "Incrementar")
            }
            Button(onClick = { if (progressStatus > 0f) progressStatus -= 0.1f }) {
                Text(text = "Reducir")
            }
        }
    }
}

@Composable
fun ProgressComponent() {
    var showLoading by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(color = Color.Red, strokeWidth = 10.dp)
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 32.dp),
                backgroundColor = Color.Green,
                color = Color.Red
            )
        }

        Button(onClick = { showLoading = !showLoading }) {
            Text(text = "Cargar perfil")
        }
    }
}

@Composable
fun IconComponent(value: Boolean, onChangeValue: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Icon(imageVector = if (value) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
            contentDescription = "Icon",
            tint = Color.Red,
            modifier = Modifier.clickable { onChangeValue() })
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