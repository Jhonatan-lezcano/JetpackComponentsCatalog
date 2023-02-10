package com.example.jetpackcomponentscatalogue

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun ConfirmationDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    value: String,
    onChangeRadio: (String) -> Unit
) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.background(MaterialTheme.colors.background)) {
                    TitleDialog(text = "Phone ringtone", modifier = Modifier.padding(20.dp))
                    Divider(modifier = Modifier.fillMaxWidth(), color = Color.Gray)
                    RingTones(name = value, onItemSelected = { onChangeRadio(it) })
                    Divider(modifier = Modifier.fillMaxWidth(), color = Color.Gray)
                    Row(modifier = Modifier.align(Alignment.End).padding(8.dp)) {
                        TextButton(onClick = { onDismiss() }) {
                            Text(text = "CANCEL")
                        }
                        TextButton(onClick = { /*TODO*/ }) {
                            Text(text = "OK")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CustomDialog(
    show: Boolean,
    onDismiss: () -> Unit,
) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(20.dp)) {
                    TitleDialog(text = "Set backUp account")
                    AccountItem(
                        email = "user01@gmail.com",
                        drawable = R.drawable.ic_launcher_background
                    )
                    AccountItem(
                        email = "user02@gmail.com",
                        drawable = R.drawable.ic_launcher_background
                    )
                    AccountItem(
                        email = "Add account",
                        drawable = R.drawable.ic_launcher_foreground
                    )
                }
            }
        }
    }
}

@Composable
fun SimpleCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit,
) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = true)
        ) {
            Column(
                Modifier
                    .background(MaterialTheme.colors.background)
                    .padding(20.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Esto es un ejemplo")
                Text(text = "Esto es un ejemplo")
                Text(text = "Esto es un ejemplo")
            }
        }

    }
}

@Composable
fun DialogComponent(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (show) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = { Text(text = "Título") },
            text = { Text(text = "Hola soy una descripción") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "ConfirmButton")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "DismissButton")
                }
            })
    }
}

@Composable
fun RingTones(name: String, onItemSelected: (String) -> Unit) {

    Column(
        Modifier
            .fillMaxWidth()
            .height(315.dp)
            .padding(horizontal = 8.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "None",
                onClick = { onItemSelected("None") },
            )
            Text(text = "None", modifier = Modifier.padding(start = 20.dp))
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Castillo",
                onClick = { onItemSelected("Castillo") },
            )
            Text(text = "Castillo", modifier = Modifier.padding(start = 20.dp))
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Ganymede",
                onClick = { onItemSelected("Ganymede") },
            )
            Text(text = "Ganymede", modifier = Modifier.padding(start = 20.dp))
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Luna",
                onClick = { onItemSelected("Luna") },
            )
            Text(text = "Luna", modifier = Modifier.padding(start = 20.dp))
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Oberon",
                onClick = { onItemSelected("Oberon") },
            )
            Text(text = "Oberon", modifier = Modifier.padding(start = 20.dp))
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Phobos",
                onClick = { onItemSelected("Phobos") },
            )
            Text(text = "Phobos", modifier = Modifier.padding(start = 20.dp))
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Dione",
                onClick = { onItemSelected("Dione") },
            )
            Text(text = "Dione", modifier = Modifier.padding(start = 20.dp))
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "La plata",
                onClick = { onItemSelected("La plata") },
            )
            Text(text = "La plata", modifier = Modifier.padding(start = 20.dp))
        }
    }
}


@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(40.dp)
        )
        Text(
            text = email,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
fun TitleDialog(text: String, modifier: Modifier = Modifier.padding(bottom = 12.dp)) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )
}

