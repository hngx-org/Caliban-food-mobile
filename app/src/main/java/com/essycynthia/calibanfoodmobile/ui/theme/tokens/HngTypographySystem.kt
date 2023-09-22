package com.essycynthia.calibanfoodmobile.ui.theme.tokens

/*data class HngTypographySystem(){

}*/

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class HngTypographySystem(
    val h1Bold: TextStyle,
    val h1Regular: TextStyle,
    val h2Bold: TextStyle,
    val h2Medium: TextStyle,
    val h3Bold: TextStyle,
    val h3Regular: TextStyle,
    val bodyRegular: TextStyle,
    val bodyMedium: TextStyle,
    val smallBodyRegular: TextStyle,
    val smallBodyMedium: TextStyle,
    val caption: TextStyle,
    val button: TextStyle,
) {

    constructor(): this(
        h1Bold = TextStyle(
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 42.sp,
        ),
        h1Regular = TextStyle(
            fontSize = 28.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 42.sp,
        ),
        h2Bold = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 30.sp,
        ),
        h2Medium = TextStyle(
            fontSize = 28.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 30.sp,
        ),
        h3Bold = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 24.sp,
        ),
        h3Regular = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 24.sp,
        ),
        bodyRegular = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 20.sp,
        ),
        bodyMedium = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 20.sp,
        ),
        smallBodyRegular = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 18.sp,
        ),
        smallBodyMedium = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 18.sp,
        ),
        caption = TextStyle(
            fontSize = 10.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 15.sp,
        ),
        button = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 14.sp,
        ),
    )
}

fun HngTypographySystem.toMaterialTypography(): Typography =
    Typography(
        displayLarge = h1Bold,
        displaySmall = h1Regular,
        headlineLarge = h2Bold,
        headlineMedium = h2Medium,
        titleLarge = h3Bold,
        titleSmall = h3Regular,
        bodyMedium = bodyMedium,
        bodySmall = bodyRegular,
        labelMedium = smallBodyMedium,
        labelSmall = smallBodyRegular,
    )
