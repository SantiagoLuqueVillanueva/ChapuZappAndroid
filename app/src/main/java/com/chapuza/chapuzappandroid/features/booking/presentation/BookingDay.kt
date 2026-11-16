package com.chapuza.chapuzappandroid.features.booking.presentation

import androidx.compose.material3.Icon
import androidx.compose.material3.R
import androidx.compose.runtime.Composable

data class BookingDay(
    val dayName: String,
    val dayNumber: Int,
    val isAvailable: Boolean,
)
val sampleDays: List<BookingDay> =
    listOf(
    BookingDay(dayName = "Lun", dayNumber = 12, isAvailable = false),
    BookingDay(dayName = "Mar", dayNumber = 13, isAvailable = true),
    BookingDay(dayName = "Mié", dayNumber = 14, isAvailable = true),
    BookingDay(dayName = "Jue", dayNumber = 15, isAvailable = true),
    BookingDay(dayName = "Vie", dayNumber = 16, isAvailable = true),
    BookingDay(dayName = "Sáb", dayNumber = 17, isAvailable = false),
    BookingDay(dayName = "Dom", dayNumber = 18, isAvailable = false),
)

val sampleHours: List<String> = listOf("09:00", "12:00", "17:00")