package org.example.project

import android.os.Build
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import java.text.DecimalFormat

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
actual fun getPlatform(): Platform = AndroidPlatform()

actual fun formatNumberWithComma(number: Int): String{
    val decimalFormat = DecimalFormat("##,###")
    return decimalFormat.format(number)
}