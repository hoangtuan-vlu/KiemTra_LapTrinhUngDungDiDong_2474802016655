package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2474802016655


import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Ánh xạ View bằng findViewById
        val tvUserEmail = findViewById<TextView>(R.id.tvUserEmail)
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        val lvSkills = findViewById<ListView>(R.id.lvSkills)

        // Trích xuất dữ liệu chuỗi Email từ Intent (Câu 2)
        val email = intent.getStringExtra("USER_EMAIL")
        tvUserEmail.text = "Email: ${email ?: "N/A"}"

        // Xử lý nút Đăng xuất (quay về LoginActivity)
        btnLogout.setOnClickListener {
            finish()
        }

        // Khởi tạo danh sách ít nhất 05 môn học / kỹ năng mẫu (Câu 3)
        val skillList = arrayOf(
            "Lập trình Kotlin",
            "Thiết kế Layout XML",
            "Quản lý Git/GitHub",
            "Xử lý Intent",
            "Kiến trúc Android"
        )

        // Gắn ArrayAdapter kèm layout chuẩn android.R.layout.simple_list_item_1
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            skillList
        )
        lvSkills.adapter = adapter

        // Bắt sự kiện click từng item trên ListView hiển thị Toast (Câu 3)
        lvSkills.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = skillList[position]
            Toast.makeText(this, "Bạn đã chọn: $selectedItem", Toast.LENGTH_SHORT).show()
        }
    }
}