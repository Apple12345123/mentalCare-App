package com.busani.mentalcareapp

import android.os.Build
import androidx.annotation.RequiresApi
import com.busani.mentalcareapp.reservation.LocalDateAdapter
import com.busani.mentalcareapp.reservation.LocalTimeAdapter
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDate
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
object RetrofitClient {
    // 기본 URL
    private const val BASE_URL = "http://10.100.203.58:8080"

    // Custom Gson 인스턴스 생성 (LocalDate 직렬화 어댑터 등록)
    @RequiresApi(Build.VERSION_CODES.O)
    val gson = GsonBuilder()
        .registerTypeAdapter(LocalDate::class.java, LocalDateAdapter()) // LocalDate 어댑터 등록
        .registerTypeAdapter(LocalTime::class.java, LocalTimeAdapter()) // LocalTime 어댑터 등록
        .create()

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))  // Gson 인스턴스 추가
            .build()
            .create(ApiService::class.java)
    }
}