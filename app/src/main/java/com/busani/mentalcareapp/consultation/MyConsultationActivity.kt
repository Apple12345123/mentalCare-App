package com.busani.mentalcareapp.consultation

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busani.mentalcareapp.R
import com.busani.mentalcareapp.RetrofitClient
import com.busani.mentalcareapp.databinding.MyConsultationBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyConsultationActivity : AppCompatActivity() {
    lateinit var binding: MyConsultationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= MyConsultationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val id = intent.getLongExtra("consultationId", 0)
        val api = RetrofitClient.api
        api.getConsultation(id).enqueue(object : Callback<Consultation> {
            override fun onResponse(call: Call<Consultation>, response: Response<Consultation>) {
                if (response.isSuccessful) {
                    // 네트워킹에 성공할 경우 데이터를 가져옴 (엘비스 연산자로 null 처리)
                    val posts = response.body()
                } else {
                    handleServerError(response)  // 오류 처리 함수 호출
                }
            }

            override fun onFailure(call: Call<Consultation>, t: Throwable) {
                handleNetworkError(t)
                // 실패 처리
            }
        })



    }
    // 레트로핏 오류 처리
    // 응답은 하였으나 성공(200번대)이 아닌 경우 핸들러
    private fun handleServerError(response: Response<*>) {
        when (response.code()) {
            400 -> Log.d("mylog", "400 Bad Request ${response.message()}")
            401 -> Log.d("mylog", "401 Unauthorized ${response.message()}")
            403 -> Log.d("mylog", "403 Forbidden ${response.message()}")
            404 -> Log.d("mylog", "404 Not Found ${response.message()}")
            500 -> Log.d("mylog", "500 Server Error ${response.message()}")
            else -> Log.d("mylog", "Response Error ${response.message()}")
        }
    }
    // 네트워크 요청 자체가 실패한 경우 핸들러
    private fun handleNetworkError(t: Throwable) {
        Log.d("mylog", "Network Error ${t.message}")
        Toast.makeText(this, "네트워크 요청실패", Toast.LENGTH_SHORT).show()
    }

}