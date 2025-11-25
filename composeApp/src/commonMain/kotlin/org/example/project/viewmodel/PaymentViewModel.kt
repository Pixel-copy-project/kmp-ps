package org.example.project.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PaymentViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(PaymentUiState())
    val uiState: StateFlow<PaymentUiState>
        get() = _uiState.asStateFlow()

    fun updatePaymentMethod(paymentMethod: PaymentMethod){
        _uiState.update{ it.copy(paymentMethod = paymentMethod) }
    }

    fun updateCreditCard(creditCard: CreditCard){
        _uiState.update{ it.copy(creditCard = creditCard) }
    }
}