package com.chapuza.chapuzappandroid.core.ui.theme

import com.chapuza.chapuzappandroid.R
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
private val Jakarta = FontFamily(
    Font(R.font.plus_jakarta_sans_semibold, FontWeight.SemiBold)
)
private val Inter = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium)
)

private fun style(f: FontFamily, w: FontWeight, size: Int, line: Int) = TextStyle(
    fontFamily = f,
    fontWeight = w,
    fontSize = size.sp,
    lineHeight = line.sp,
    letterSpacing = 0.sp
)

val Typography = Typography(
    headlineMedium = style(Jakarta, FontWeight.SemiBold, 28, 34),
    headlineSmall = style(Jakarta, FontWeight.SemiBold, 24, 30),
    titleLarge = style(Jakarta, FontWeight.SemiBold, 20, 26),
    titleMedium = style(Jakarta, FontWeight.SemiBold, 16, 22),
    titleSmall = style(Jakarta, FontWeight.SemiBold, 15, 20),
    labelLarge = style(Jakarta, FontWeight.SemiBold, 15, 20),
    bodyLarge = style(Inter, FontWeight.Normal, 14, 20),
    bodyMedium = style(Inter, FontWeight.Normal, 14, 20),
    bodySmall = style(Inter, FontWeight.Normal, 12, 16),
    labelMedium = style(Inter, FontWeight.Medium, 12, 16),
    labelSmall = style(Inter, FontWeight.Normal, 11, 14)
)

val BodyMediumStrong = style(Inter, FontWeight.Medium, 14, 20)
val ChipText = style(Inter, FontWeight.Medium, 13, 18)