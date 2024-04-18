package com.neopixl.n26eco.navigation

import android.util.Base64

fun String.addArguments(args: String): String {
    return this.plus("/").plus(args)
}

fun String.addFloatArgument(args: Float): String {
    return this.plus("/").plus(args)
}

fun String.addLongArgument(args: Long): String {
    return this.plus("/").plus(args)
}
fun String.addStringArgument(args: String): String {
    return this.plus("/").plus(args)
}

fun String.addBooleanArguments(args: Boolean): String {
    return this.plus("/").plus(args)
}

fun String.addArgumentsPlaceholder(args: String): String {
    return this.plus("/{").plus(args).plus("}")
}
fun String.toBase64(): String {
    return Base64.encodeToString(this.toByteArray(Charsets.UTF_8), Base64.DEFAULT)
}

fun String.fromBase64(): String {
    return String(Base64.decode(this, Base64.DEFAULT), Charsets.UTF_8)
}

const val DEFAULT_ARG = "default"