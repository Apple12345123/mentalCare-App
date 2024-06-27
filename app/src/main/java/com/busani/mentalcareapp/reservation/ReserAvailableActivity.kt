package com.busani.mentalcareapp.reservation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busani.mentalcareapp.R
import com.busani.mentalcareapp.databinding.ReservationAvailableBinding

class ReserAvailableActivity : AppCompatActivity() {
    lateinit var binding: ReservationAvailableBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ReservationAvailableBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

    }
}