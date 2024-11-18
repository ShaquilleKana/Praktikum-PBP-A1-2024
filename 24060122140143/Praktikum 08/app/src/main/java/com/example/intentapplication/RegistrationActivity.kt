package com.example.intentapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegistrationActivity : AppCompatActivity(), View.OnClickListener {
    private var etName: EditText? = null
    private var etNIM: EditText? = null
    private var etPhone: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        etName = findViewById(R.id.et_name);
        etNIM = findViewById(R.id.et_nim);
        etPhone = findViewById(R.id.et_phone_number);
        val btnNext = findViewById<Button>(R.id.btn_next)
        btnNext.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view != null) {
            if (view.id == R.id.btn_next) {
                val name = etName!!.text.toString().trim { it <= ' ' }
                val nim = etNIM!!.text.toString().trim { it <= ' ' }
                val phone = etPhone!!.text.toString().trim { it <= ' ' }
                // Pastikan seluruh EditText telah diisi
                var isEmptyField = false
                if (name.isEmpty()) {
                    etName!!.error = "Field harus diisi"
                    isEmptyField = true
                }
                if (nim.isEmpty()) {
                    etNIM!!.error = "Field harus diisi"
                    isEmptyField = true
                }
                if (phone.isEmpty()){
                    etPhone!!.error = "Field harus diisi"
                    isEmptyField = true
                }

                if (!isEmptyField) {
                    val detailIntent = Intent(
                        this,
                        DetailActivity::class.java
                    )
                    detailIntent.putExtra(DetailActivity.KEY_NAME, name)
                    detailIntent.putExtra(DetailActivity.KEY_NIM, nim)
                    detailIntent.putExtra(DetailActivity.KEY_PHONE, phone)
                    startActivity(detailIntent)
                }
            }
        }
    }
}