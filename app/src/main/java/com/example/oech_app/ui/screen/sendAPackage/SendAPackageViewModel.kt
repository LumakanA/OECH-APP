package com.example.oech_app.ui.screen.sendAPackage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.oech_app.domain.models.Details
import com.example.oech_app.domain.models.PackageDetails

/**
 *Класс LogInViewModel необходим для взаимодействия между экраном LogIn и сервером
 *Создан Александром Николаевичем Рыжковым
 *Дата создания: 18.02.2024 в 19:04
 */

class SendAPackageViewModel() :
    ViewModel() {
    var state by mutableStateOf(ProfileState())
        private set

    fun changeDetailsAddress(address: String) {
        state = state.copy(
            details = state.details.copy(
                address = address
            )
        )
    }

    fun changeDetailsCountry(country: String) {
        state = state.copy(
            details = state.details.copy(
                country = country
            )
        )
    }

    fun changeDetailsPhone(phone: String) {
        state = state.copy(
            details = state.details.copy(
                phone = phone
            )
        )
    }

    fun changeDetailsOthers(others: String) {
        state = state.copy(
            details = state.details.copy(
                others = others
            )
        )
    }

    fun changeDestinationDetailsAddress(address: String, index: Int) {
        var item = state.destinationDetails[index]

        item = item.copy(
            address = address
        )

        state.destinationDetails[index] = item
    }

    fun changeDestinationDetailsCountry(country: String, index: Int) {
        var item = state.destinationDetails[index]

        item = item.copy(
            country = country
        )

        state.destinationDetails[index] = item
    }

    fun changeDestinationDetailsPhone(phone: String, index: Int) {
        var item = state.destinationDetails[index]

        item = item.copy(
            phone = phone
        )

        state.destinationDetails[index] = item
    }

    fun changeDestinationDetailsOthers(others: String, index: Int) {
        var item = state.destinationDetails[index]

        item = item.copy(
            others = others
        )

        state.destinationDetails[index] = item
    }

    fun changePackageItems(packageItems: String) {
        state = state.copy(
            packageDetails = state.packageDetails.copy(
                packageItems = packageItems
            )
        )
    }

    fun changePackageWeight(worth: String) {
        state = state.copy(
            packageDetails = state.packageDetails.copy(
                worth = worth
            )
        )
    }

    fun changePackageWorth(weight: String) {
        state = state.copy(
            packageDetails = state.packageDetails.copy(
                weight = weight
            )
        )
    }

    fun addDestination(){
        state.destinationDetails.add(Details())
    }
}

data class ProfileState(
    val details: Details = Details(),
    val destinationDetails: MutableList<Details> = mutableStateListOf(Details()),
    val packageDetails: PackageDetails = PackageDetails(),
    val trackingNumber: String = "",
)

