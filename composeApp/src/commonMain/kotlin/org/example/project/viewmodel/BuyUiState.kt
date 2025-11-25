package org.example.project.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.ui.graphics.vector.ImageVector

enum class PaymentMethod{
    CREDITCARD, KAKAOPAY, SAMSUMGPAY, APPLEPAY,
}
enum class CreditCard{
    KB, NH, SHINHAN, IBK
}

data class PaymentUiState(
    val paymentMethod: PaymentMethod = PaymentMethod.CREDITCARD,
    val creditCard: CreditCard = CreditCard.KB,
    val paymentMethodList: MutableList<Pair<ImageVector, PaymentMethod>> = mutableListOf(
        Pair(Icons.Default.CreditCard, PaymentMethod.CREDITCARD),
        Pair(Icons.Default.CreditCard, PaymentMethod.KAKAOPAY),
        Pair(Icons.Default.CreditCard, PaymentMethod.SAMSUMGPAY),
        Pair(Icons.Default.CreditCard, PaymentMethod.APPLEPAY),
    )
)
