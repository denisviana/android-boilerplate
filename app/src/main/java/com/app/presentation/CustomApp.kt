package com.app.presentation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.app.presentation.features.home.HomePage
import com.app.presentation.styles.AppTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@ExperimentalMaterialApi
@Composable
fun CustomApp() {
    AppTheme(
        content = {
            ProvideWindowInsets {
                val systemUiController = rememberSystemUiController()

                val darkIcons = MaterialTheme.colors.isLight
                val isDark = isSystemInDarkTheme()
                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = if (isDark) Color.Transparent else Color.White,
                        darkIcons = darkIcons
                    )
                }
                HomePage()
            }
        }
    )
}