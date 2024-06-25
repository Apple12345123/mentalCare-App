package com.busani.mentalcareapp.consultation

import java.sql.Blob

data class Consultation(
    val consultationId: Long,
    val consultationDetails: String,
    val myChange: String,
    val picture: Blob?
)