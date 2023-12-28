package com.fgr.palindromechecker.utils

fun String.isPalindrome(): Boolean {
    val cleanedInput = this.replace("\\s".toRegex(), "").lowercase()

    return cleanedInput == cleanedInput.reversed()
}