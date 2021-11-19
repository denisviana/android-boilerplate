package com.app.presentation.styles

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightThemeColors = lightColors(
    primary = Color.Black,
    primaryVariant = Color.White,
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    error = Color.Red,
    onBackground = Color.White
)

private val DarkThemeColors = darkColors(
    primary = Color.White,
    onPrimary = Color.Black,
    primaryVariant = Color.Black,
    secondary = Color.Red,
    onSecondary = Color.White,
    onBackground = Color.Black
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkThemeColors else LightThemeColors,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}