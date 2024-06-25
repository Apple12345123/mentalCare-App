package com.busani.mentalcareapp.hospital

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busani.mentalcareapp.R
import com.busani.mentalcareapp.databinding.ActivityHospitalBinding
import com.busani.mentalcareapp.databinding.MyReservationBinding

class MyReservationActivity : AppCompatActivity() {
    lateinit var binding: MyReservationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= MyReservationBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

    }
}