package com.neopixl.n26eco.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


data class AppTypography(
    val poppinsFont: FontFamily?= null,
    val montserrat: FontFamily?=null,
    val montserratPrincipalTitle: TextStyle = TextStyle(
        fontFamily =montserrat,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 25.sp,
    ),
    val montserratTitle1: TextStyle = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp,
        lineHeight = 20.sp,
    ),

    val montserrat15: TextStyle = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.SemiBold,
        fontSize = 15.sp,
        lineHeight = 20.sp,
    ),

    val montserratTitle2_12: TextStyle = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 17.sp,
    ),

    val montserratTitle3: TextStyle = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 17.sp,
    ),

    val montserratText13: TextStyle = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = 12.sp,
    ),

    val montserratText11: TextStyle = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        lineHeight = 12.sp,
    ),

    val poppinsTitle5: TextStyle = TextStyle(
        fontFamily = poppinsFont,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
    ),

    val poppinsNormal: TextStyle = TextStyle(
        fontFamily = poppinsFont,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
    ),

    )

internal val LocalTypography = staticCompositionLocalOf { AppTypography() }