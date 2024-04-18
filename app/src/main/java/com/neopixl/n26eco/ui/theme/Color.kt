package com.neopixl.n26eco.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class AppColors(
    green: Color,
    black: Color,
    white: Color,
    lightGray: Color,
    red: Color,
    blue:Color,
    orange:Color,
    isLight: Boolean
) {

    var green by mutableStateOf(green)
        private set
    var black by mutableStateOf(black)
        private set
    var white by mutableStateOf(white)
        private set
    var lightGray by mutableStateOf(lightGray)
        private set
    var red by mutableStateOf(red)
        private set

    var blue by mutableStateOf(blue)
        private set
    var orange by mutableStateOf(orange)
        private set
    var isLight by mutableStateOf(isLight)
        internal set

    fun copy(
        green: Color = this.green,
        black: Color = this.black,
        white: Color = this.white,
        lightGray: Color = this.lightGray,
        red:Color=this.red,
        blue: Color=this.blue,
        orange: Color=this.orange,
        isLight: Boolean = this.isLight
    ): AppColors = AppColors(
        green,
        black,
        white,
        lightGray,
        red,
        blue,
        orange,
        isLight,
    )

    fun updateColorsFrom(other: AppColors) {
        green = other.green
        black = other.black
        white = other.white
        lightGray = other.lightGray
        red = other.red
        blue = other.blue
        orange = other.orange
    }
}

private val colorLightGreen = Color(0xFF008080)
private val colorLightBlack = Color(0xFF000000)
private val colorLightWhite = Color(0xFFFFFFFF)
private val colorLightLightGray = Color(0xFFF3F3F4)
private val colorLightRed = Color(0xFFCC0000)
private val colorLightBlue = Color(0xFF36419D)
private val colorLightOrange = Color(0xFFe3802b)

private val colorDarkGreen = Color(0xFF008080)
private val colorDarkBlack = Color(0xFFD9D9D9)
private val colorDarkWhite = Color(0xFF1A1A1A)
private val colorDarkLightGray = Color(0xFFF3F3F4)
private val colorDarkRed = Color(0xFFCC0000)
private val colorDarkBlue = Color(0xFF36419D)
private val colorDarkOrange = Color(0xFFe3802b)

fun lightColors(
    green: Color = colorLightGreen,
    black: Color = colorLightBlack,
    white: Color = colorLightWhite,
    lightGray: Color = colorLightLightGray,
    red: Color= colorLightRed,
    blue: Color= colorLightBlue,
    orange: Color= colorLightOrange
): AppColors = AppColors(
    green = green,
    black = black,
    white = white,
    lightGray = lightGray,
    red=red,
    blue=blue,
    orange=orange,
    isLight = true,
)

fun darkColors(
    green: Color = colorDarkGreen,
    black: Color = colorDarkBlack,
    white: Color = colorDarkWhite,
    lightGray: Color = colorDarkLightGray,
    red: Color= colorDarkRed,
    blue: Color= colorDarkBlue,
    orange: Color= colorDarkOrange
): AppColors = AppColors(
    green = green,
    black = black,
    white = white,
    lightGray = lightGray,
    red = red,
    blue=blue,
    orange=orange,
    isLight = false,
)

val LocalColors = staticCompositionLocalOf { lightColors() }