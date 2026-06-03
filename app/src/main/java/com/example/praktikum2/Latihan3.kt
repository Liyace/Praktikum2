package com.example.praktikum2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Latihan3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val spinner = findViewById<Spinner>(R.id.spinner)
        val btProsesLatihan3 = findViewById<Button>(R.id.btProsesLatihanWarna3) // You need to declare this
        val btProsesLatihanWarna3 = findViewById<Button>(R.id.btProsesLatihanWarna3) // You need to declare this

        // Optional: Set up spinner with items if not done in XML
        val items = listOf("Merah", "Hijau", "Biru", "Reset/Lainnya")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        btProsesLatihan3.setOnClickListener {
            val pilihan = spinner.selectedItem.toString() // Fix: use selectedItem instead of selectedView

            when (pilihan) {
                "Merah" ->
                    btProsesLatihanWarna3.setBackgroundColor(ContextCompat.getColor(this, R.color.merah))
                "Hijau" ->
                    btProsesLatihanWarna3.setBackgroundColor(ContextCompat.getColor(this, R.color.hijau))
                "Biru" ->
                    btProsesLatihanWarna3.setBackgroundColor(ContextCompat.getColor(this, R.color.biru))
                else -> {
                    val builder = AlertDialog.Builder(this)
                    builder
                        .setTitle("Peringatan")
                        .setMessage("warna akan direset ke awal, apakah anda yakin?")
                        .setPositiveButton("OK") { dialog, _ ->
                            dialog.dismiss()
                            btProsesLatihanWarna3.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_500))
                        }
                        .setNegativeButton("Batal") { dialog, _ ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        }
    }
}