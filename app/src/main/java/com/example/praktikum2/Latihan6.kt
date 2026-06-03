package com.example.praktikum2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Latihan6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan6)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editnim_lat6 = findViewById<EditText>(R.id.edit_nim_lat6)
        val editnama_lat6 = findViewById<EditText>(R.id.edit_nama_lat6)
        val editkelas_lat6 = findViewById<EditText>(R.id.edit_kelas_lat6)
        val btnSubmit = findViewById<Button>(R.id.btproses_lat6) // Pastikan ID ini ada di XML

        btnSubmit.setOnClickListener {
            val nim = editnim_lat6.text.toString()
            val nama = editnama_lat6.text.toString()
            val kelas = editkelas_lat6.text.toString()

            if (nim.isNotEmpty() && nama.isNotEmpty() && kelas.isNotEmpty()) {
                Toast.makeText(this, "NIM: $nim\nNama: $nama\nKelas: $kelas", Toast.LENGTH_LONG).show()
                // Atau pindah ke activity lain
            } else {
                Toast.makeText(this, "Harap isi semua data!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}