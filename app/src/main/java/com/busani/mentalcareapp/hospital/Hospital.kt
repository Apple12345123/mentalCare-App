package com.busani.mentalcareapp.hospital

import java.sql.Time

data class Hospital(val hospitalId: String, val hospitalName: String, val hospitalLocation: String, val hospitalWebsite: String, val hospitalCall: String,
                    val monStartTime: Time, val monEndTime: Time, val tueStartTime: Time, val tueEndTime: Time, val wedStartTime: Time,
                    val wedEndTime: Time, val thuStartTime: Time, val thuEndTime: Time, val friStartTime: Time, val friEndTime: Time,
                    val satStartTime: Time, val satEndTime: Time, val sunStartTime: Time, val sunEndTime: Time, val sunHoliday: String, val lunchtime: Time, val holiday: String)