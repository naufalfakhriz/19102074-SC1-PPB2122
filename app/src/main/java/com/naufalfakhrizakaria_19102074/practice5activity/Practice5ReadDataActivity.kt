package com.naufalfakhrizakaria_19102074.practice5activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Practice5ReadDataActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_PRODI = "extra_prodi"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice5_read_data)
        var lblProdiSaya = findViewById<TextView>(R.id.lblProdiSaya)

        val prodi = intent.getStringExtra(EXTRA_PRODI)
        lblProdiSaya.text = "Prodi Saya Adalah $prodi"
    }
}