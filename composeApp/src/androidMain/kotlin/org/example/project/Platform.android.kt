package org.example.project

import android.os.Build
import java.text.DecimalFormat

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual fun formatNumberWithComma(number: Int): String{
    val decimalFormat = DecimalFormat("##,###")
    return decimalFormat.format(number)
}