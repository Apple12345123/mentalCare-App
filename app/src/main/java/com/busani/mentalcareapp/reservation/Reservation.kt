package com.busani.mentalcareapp.reservation

import java.time.LocalDate
import java.time.LocalTime

data class Reservation (
    val reservationId: Long,
    val userId: String,
    val reservationDate: LocalDate,
    val treatmentDate: LocalDate,
    val treatmentTime: LocalTime
)