package com.busani.mentalcareapp.hospital

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.busani.mentalcareapp.databinding.HospitalItemBinding

class HospitalAdapter(var hospitalList: List<Hospital>) :
    RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>() {

    inner class HospitalViewHolder(val binding: HospitalItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    // 6. 어댑터의 메서드 구현
    // 6-1. onCreateViewHolder : 뷰 홀더를 초기화
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        val binding = HospitalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HospitalViewHolder(binding)
    }

    // 6-2. getItemCount : 데이터의 개수
    override fun getItemCount(): Int = hospitalList.size

    // 6-3. onBindViewHolder : 데이터와 뷰홀더 바인딩
    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        holder.binding.run {
            hospitalName.text = hospitalList[position].hospitalName
            hospitalLocation.text = hospitalList[position].hospitalLocation
            hospitalCall.text = hospitalList[position].hospitalCall
            hospitalWebsite.text = hospitalList[position].hospitalWebsite

        }
    }

    fun updateList(newList: List<Hospital>) {
        hospitalList = newList
        notifyDataSetChanged()
    }
}