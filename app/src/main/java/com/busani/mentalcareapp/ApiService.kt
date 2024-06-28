package com.busani.mentalcareapp

import com.busani.mentalcareapp.consultation.Consultation
import com.busani.mentalcareapp.hospital.Hospital
import com.busani.mentalcareapp.reservation.Reservation
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    // 상담내역
    @POST("/consultation")
    fun createConsultation(@Body consultation: Consultation): Call<Consultation>

    @GET("/consultation/{id}")
    fun getConsultation(@Path("consultationId") consultationId: Long): Call<Consultation>

    @DELETE("/consultation/{id}")
    fun deleteConsultation(@Path("consultationId") consultationId: Long): Call<Any>

    /* 수정하기
    @PUT("/consultation/{id}")
    fun putConsultation(@Path("consultationId") consultationId: Long, @Body consultation: Consultation)*/

    // 병원 정보
    @POST("api/hospitals")
    fun createHospital(@Body hospital: Hospital): Call<List<Hospital>>

    @GET("api/hospitals")
    fun getHospitals(): Call<List<Hospital>>

    @GET("api/hospitals/{hospitalId}")
    fun getHospital(@Path("hospitalId") hospitalId: String): Call<Hospital>

    // 예약 정보
    @POST("/reservation")
    fun createReservation(@Body reservation: Reservation): Call<List<Reservation>>

    @GET("/reservation/{id}")
    fun getReservation(@Path("reservationId") reservationId: Long): Call<List<Reservation>>

    @DELETE("/reservation/{id}")
    fun deleteReservation(@Path("reservationId") reservationId: Long): Call<Any>


}