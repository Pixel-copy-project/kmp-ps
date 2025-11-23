package org.example.project

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import java.text.DecimalFormat

class JVMPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
actual fun getPlatform(): Platform = JVMPlatform()
actual fun formatNumberWithComma(number: Int): String{
    val decimalFormat = DecimalFormat("##,###")
    return decimalFormat.format(number)
}