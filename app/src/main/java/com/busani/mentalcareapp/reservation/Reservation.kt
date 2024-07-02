package com.busani.mentalcareapp.reservation

import java.sql.Time
import java.time.LocalDate
import java.time.LocalTime

data class Reservation (
    val reservationId: Long?,
    val userId: String?,
    val reservationDate: LocalDate,
    val reservationTime: LocalTime,
    val hospitalId: String,
    val hospitalName: String?,
    val consultationId: Long?
)