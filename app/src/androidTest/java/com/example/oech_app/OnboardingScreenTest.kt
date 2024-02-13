package com.example.oech_app

import com.example.oech_app.data.Storage
import com.example.oech_app.domain.onboarding.OnboardItem
import com.example.oech_app.ui.screen.onboarding.OnboardingViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(MockitoJUnitRunner::class)
class OnboardingScreenTest {

    @Mock
    private lateinit var onboardingViewModel: OnboardingViewModel
    private lateinit var storage: Storage


    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        onboardingViewModel = OnboardingViewModel(storage)
    }

    // Реализация теста для проверки корректного извлечения изображения и текста из очереди в правильном порядке
    @Test
    fun testImageAndTextQueueOrder() {
        val onboardItems: List<OnboardItem> = listOf(
            OnboardItem(
                R.drawable.onboarding_one_img,
                R.string.quick_delivery_at_your_doorstep,
                R.string.enjoy_quick_pick_up_and_delivery_to_your_destination
            ),
            OnboardItem(
                R.drawable.onboarding_two_img,
                R.string.flexible_payment,
                R.string.different_modes_of_payment_either_before_and_after_delivery_without_stress
            ),
            OnboardItem(
                R.drawable.onboarding_three_img,
                R.string.real_time_tracking,
                R.string.track_your_packages_items_from_the_comfort_of_your_home_till_final_destination
            ),
        )

    }

    // Реализация теста для проверки корректного извлечения элементов из очереди (уменьшение количества элементов на единицу)
    @Test
    fun testCorrectExtractionFromQueue() {

    }

    // Реализация теста для проверки правильной надписи на кнопке в случае, когда в очереди несколько картинок
    @Test
    fun testCorrectButtonLabelWithMultipleImages() {

    }

    // Реализация теста для проверки изменения надписи на кнопке на "Sing Up", если очередь пустая
    @Test
    fun testButtonLabelChangeWhenQueueEmpty() {

    }

    // Реализация теста для проверки открытия пустого экрана "Home" приложения при нажатии на кнопку "Sing in", если очередь пустая
    @Test
    fun testEmptyQueueOpenHolderScreenOnSignIn() {

    }
}