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

    @GET("/consultation/{consultationId}")
    fun getConsultation(@Path("consultationId") consultationId: Long): Call<Consultation>

    @DELETE("/consultation/{consultationId}")
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
    fun createReservation(@Body reservation: Reservation): Call<Reservation>

    @GET("/reservation/{reservationId}")
    fun getReservation(@Path("reservationId") reservationId: Long): Call<Reservation>
    @GET("/reservation/user/{userId}")
    fun getReservationByUserId(@Path("userId") userId: String): Call<List<Reservation>>

    @DELETE("/reservation/{reservationId}")
    fun deleteReservation(@Path("reservationId") reservationId: Long): Call<String>


}