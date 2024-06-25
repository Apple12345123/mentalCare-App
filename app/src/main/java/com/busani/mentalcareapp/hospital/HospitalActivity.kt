package com.busani.mentalcareapp.hospital

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.busani.mentalcareapp.R
import com.busani.mentalcareapp.databinding.ActivityHospitalBinding
import java.util.Locale.filter

class HospitalActivity : AppCompatActivity() {
    lateinit var binding: ActivityHospitalBinding
    lateinit var hospitalList: List<Hospital>
    lateinit var hospitalAdapter: HospitalAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityHospitalBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 병원명, 주소로 검색 및 필터
        hospitalList = emptyList()
        hospitalAdapter = HospitalAdapter(hospitalList)


        // 액티비티에서 어댑터 및 레이아웃 매니저 설정
        val adapter = HospitalAdapter(hospitalList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)


        binding.editTextName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filter(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        // 버튼을 누르면 해당 페이지로 이동
        binding.run {

            myReservationIcon.setOnClickListener {
                val myReservation0 = Intent(this@HospitalActivity, MyReservationActivity::class.java)
                startActivity(myReservation0)
            }

            questionIcon.setOnClickListener {
                val question0 = Intent(this@HospitalActivity, QuestionActivity::class.java)
                startActivity(question0)
            }
        }

        // Button 클릭 시 Bottom Sheet 표시 (LocalCode 설정)
        binding.localIcon.setOnClickListener {
            val bottomSheet = BottomSheetFragment()
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }

    }
    private fun filter(text: String) {
        val filteredList = hospitalList.filter {
            it.hospitalName.contains(text, ignoreCase = true)
        }

        hospitalAdapter.updateList(filteredList)
    }

}
