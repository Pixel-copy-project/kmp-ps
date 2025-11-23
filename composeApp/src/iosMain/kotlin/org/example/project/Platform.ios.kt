package org.example.project

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import platform.UIKit.UIDevice
import platform.Foundation.*

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual val ioDispatcher: CoroutineDispatcher = Dispatchers.Default
actual fun getPlatform(): Platform = IOSPlatform()
actual fun formatNumberWithComma(number: Int): String{
    val formatter = NSNumberFormatter().apply {
        numberStyle = NSNumberFormatterDecimalStyle // 십진수 스타일
        groupingSeparator = "," // 천 단위 구분자로 콤마 지정
        usesGroupingSeparator = true // 천 단위 구분자 사용 활성화
        maximumFractionDigits = 0u // 소수점 이하 자리수는 0개
        // locale = NSLocale.localeWithLocaleIdentifier("ko_KR") // 필요하다면 로케일 지정
    }
    return formatter.stringFromNumber(NSNumber(int = number)) ?: number.toString()
}