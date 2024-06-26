package com.busani.mentalcareapp.consultation


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.busani.mentalcareapp.RetrofitClient
import com.busani.mentalcareapp.databinding.ActivityConsultationBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "ConsultationActivity"
class ConsultationActivity : AppCompatActivity() {
    lateinit var binding: ActivityConsultationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityConsultationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.run {
            button.setOnClickListener {
                // 사용자로부터 데이터를 입력받아 데이터 객체 생성
                val contentConsul = contentConsul.text.toString()
                val changeConsul = editText2.text.toString()
                // val picture = picture.

                val consultation = Consultation(1, contentConsul, changeConsul, null)
                RetrofitClient.api.createConsultation(consultation).enqueue(object : Callback<Consultation> {
                    override fun onResponse(call: Call<Consultation>, response: Response<Consultation>) {
                        if (response.isSuccessful) {
                            Toast.makeText(this@ConsultationActivity, "새 글 쓰기 성공했습니다.", Toast.LENGTH_SHORT).show()
                            val id = response.body()?.consultationId
                            val intent = Intent(this@ConsultationActivity, MyConsultationActivity::class.java)
                            intent.putExtra("consultationId", id)
                            startActivity(intent)

                            finish()  // 새 글 작성 성공시, Activity 종료, 이전으로 돌아감
                        } else {
                            Toast.makeText(this@ConsultationActivity, "응답 실패 ${response.code()} ${response.message()}", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<Consultation>, t: Throwable) {
                        // 실패 처리 (네트워크 요청 자체가 안되어 예외(t)를 던짐.
                        Toast.makeText(this@ConsultationActivity, "네트워크 요청 실패 ${t.message}", Toast.LENGTH_SHORT).show()
                    }

                })
            }
        }

    }
}