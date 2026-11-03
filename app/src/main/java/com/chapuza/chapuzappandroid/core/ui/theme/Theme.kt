package com.chapuza.chapuzappandroid.core.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = Dark,
    onPrimary = White,
    primaryContainer = Mint,
    onPrimaryContainer = Dark,
    secondary = Teal,
    onSecondary = White,
    secondaryContainer = Mint,
    onSecondaryContainer = Dark,
    tertiary = MintLine,
    tertiaryContainer = MintSoft,
    onTertiaryContainer = Dark,
    background = Bg,
    onBackground = Dark,
    surface = Bg,
    onSurface = Dark,
    surfaceVariant = Busy,
    onSurfaceVariant = Muted,
    surfaceContainerLowest = White,
    surfaceContainerLow = Card,
    surfaceContainer = Sheet,
    surfaceContainerHigh = Sheet,
    surfaceContainerHighest = MintSoft,
    outline = MintLine,
    outlineVariant = Border,
    scrim = Dark
)

@Composable
fun ChapuZappAndroidTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
        shapes = Shapes
    )
}