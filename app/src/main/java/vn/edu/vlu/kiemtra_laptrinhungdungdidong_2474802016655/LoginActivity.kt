package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2474802016655

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Ánh xạ View bằng findViewById truyền thống (Không dùng ViewBinding)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            when {
                // Bỏ trống Email hoặc Mật khẩu
                email.isEmpty() || password.isEmpty() -> {
                    tvStatus.setTextColor(Color.RED)
                    tvStatus.text = "Lỗi: Vui lòng không để trống thông tin!"
                }
                // Email sai định dạng chuẩn
                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    tvStatus.setTextColor(Color.RED)
                    tvStatus.text = "Lỗi: Email không đúng định dạng chuẩn!"
                }
                // Mật khẩu < 6 ký tự
                password.length < 6 -> {
                    tvStatus.setTextColor(Color.RED)
                    tvStatus.text = "Lỗi: Mật khẩu phải có từ 6 ký tự trở lên!"
                }
                // Dữ liệu hoàn toàn hợp lệ -> Chuyển sang ProfileActivity kèm Intent
                else -> {
                    tvStatus.setTextColor(Color.parseColor("#4CAF50"))
                    tvStatus.text = "Xác thực thành công!"

                    val intent = Intent(this, ProfileActivity::class.java)
                    intent.putExtra("USER_EMAIL", email)
                    startActivity(intent)
                }
            }
        }
    }
}