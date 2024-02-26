package com.example.oech_app.ui.screen.sendAPackage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.oech_app.domain.models.Details

/**
 *Класс LogInViewModel необходим для взаимодействия между экраном LogIn и сервером
 *Создан Александром Николаевичем Рыжковым
 *Дата создания: 18.02.2024 в 19:04
 */

class SendAPackageReceiptViewModel() :
    ViewModel() {
    var state by mutableStateOf(SendAPackageReceiptState())
        private set

    fun receiveData(data: SendAPackageState) {
        deliveryCharges(data.destinationDetails.toList())
        tax()
        totalPackage()
    }

    private fun deliveryCharges(details: List<Details>) {
        state = state.copy(
            deliveryCharges = 2500 * details.size
        )
    }

    private fun tax() {
        state = state.copy(
            tax = (state.deliveryCharges + state.instantDelivery) * 0.05f
        )
    }

    private fun totalPackage() {
        state = state.copy(
            packageTotal = state.tax + state.deliveryCharges + state.deliveryCharges
        )
    }
}

data class SendAPackageReceiptState(
    val details: Details = Details(),
    val deliveryCharges: Int = 2500,
    val instantDelivery: Int = 250,
    val tax: Float = 0f,
    val packageTotal: Float = 0f,
    val trackingNumber: String = "",
)

