package com.example.jetpackcomponentscatalogue.ui.theme

data class CheckInfo(val title: String, var selected: Boolean = false, var onCheckedChange: (Boolean) -> Unit)
