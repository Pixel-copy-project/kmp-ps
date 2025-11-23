package org.example.project

import kotlinx.coroutines.CoroutineDispatcher

interface Platform {
    val name: String
}

expect val ioDispatcher: CoroutineDispatcher
expect fun getPlatform(): Platform
expect fun formatNumberWithComma(number: Int): String