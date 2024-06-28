package com.busani.mentalcareapp.reservation

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.busani.mentalcareapp.databinding.HospitalItemBinding
import com.busani.mentalcareapp.hospital.Hospital

class ReservationAdapter(var hospitaList: List<Hospital>) {
    inner class HospitalViewHolder(val binding: HospitalItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        // 항목 뷰에 데이터를 바인딩
        fun bind(hospital: Hospital) {
            binding.hospitalName.text = hospital.hospitalName
            binding.hospitalLocation.text = hospital.hospitalLocation
            binding.hospitalCall.text = hospital.hospitalCall
            binding.hospitalWebsite.text = hospital.hospitalWebsite
            // 항목을 클릭했을 때 댓글 액티비티를 시작하고 데이터 전달
            binding.root.setOnClickListener {
                // 컨테스트 추출
                val context = it.context
                val intent = Intent(context, ReservationActivity::class.java)
                intent.putExtra("hospitalId", hospital.hospitalId)
                context.startActivity(intent)
            }
        }
    }
}