package com.example.oech_app.ui.components

import androidx.annotation.StringRes
import com.example.oech_app.R

enum class ProfileItem(
    val image: Int,
    @StringRes val title: Int,
    @StringRes val description: Int
) {
    PROFILE(
        image = R.drawable.iconoir_profile_circled,
        title = R.string.edit_profile,
        description = R.string.name_phone_no_address_email
    ),
    STATEMENTS(
        image = R.drawable.healthicons_i_certificate_paper_outline,
        title = R.string.statements_reports,
        description =
        R.string.download_transaction_details_orders_deliveries
    ),
    NOTIFICATION(
        image = R.drawable.notification,
        title = R.string.notification_settings,
        description =
        R.string.mute_unmute_set_location_tracking_setting
    ),
    CARD(
        image = R.drawable.wallet_2,
        title = R.string.card_bank_account_settings,
        description =
        R.string.change_cards_delete_card_details
    ),
    REFERRALS(
        image = R.drawable.carbon_two_person_lift,
        title = R.string.check_no_of_friends_and_earn,
        description = R.string.check_no_of_friends_and_earn
    ),
    ABOUT(
        image = R.drawable.map,
        title = R.string.about_us,
        description = R.string.know_more_about_us_terms_and_conditions
    )
}