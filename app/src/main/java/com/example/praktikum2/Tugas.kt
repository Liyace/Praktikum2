package com.example.praktikum2

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Tugas : AppCompatActivity() {

    private var isLampuMenyala = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tugas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ivLampu = findViewById<ImageView>(R.id.ivLampu)
        val btnToggle = findViewById<Button>(R.id.button)
        val rgWarna = findViewById<RadioGroup>(R.id.rgWarna)

        // Fungsi untuk menyalakan lampu dengan warna yang dipilih
        fun nyalakanLampu() {
            val drawable = ContextCompat.getDrawable(this, R.drawable.lampu_on)?.mutate()
            when (rgWarna.checkedRadioButtonId) {
                R.id.rbKuning -> {
                    drawable?.colorFilter = PorterDuffColorFilter(0xFFFFD700.toInt(), PorterDuff.Mode.SRC_ATOP)
                }
                R.id.rbBiru -> {
                    drawable?.colorFilter = PorterDuffColorFilter(0xFF2196F3.toInt(), PorterDuff.Mode.SRC_ATOP)
                }
                else -> { // Putih (default, tanpa filter)
                    drawable?.colorFilter = null
                }
            }
            ivLampu.setImageDrawable(drawable)
        }

        // Fungsi untuk mematikan lampu
        fun matikanLampu() {
            ivLampu.setImageResource(R.drawable.lampu_off)
        }

        // Tombol toggle ON/OFF
        btnToggle.setOnClickListener {
            isLampuMenyala = !isLampuMenyala
            if (isLampuMenyala) {
                btnToggle.text = "TURN OFF"
                nyalakanLampu()
            } else {
                btnToggle.text = "TURN ON"
                matikanLampu()
            }
        }

        // Saat pilihan warna berubah, jika lampu menyala maka perbarui warna
        rgWarna.setOnCheckedChangeListener { _, _ ->
            if (isLampuMenyala) {
                nyalakanLampu()
            }
        }
    }
}