package com.naufalfakhrizakaria_19102074.practice5activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    val CALL_REQUEST_CODE = 100
    @SuppressLint("MissingPermission")

    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(this,
            Manifest.permission.CALL_PHONE)
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.CALL_PHONE),
                CALL_REQUEST_CODE)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupPermissions()
        var btnProdi = findViewById<Button>(R.id.btnProdi)
        var inputProdi = findViewById<EditText>(R.id.inputProdi)
        var btnCallBrowser = findViewById<Button>(R.id.btnCallBrowser)
        var btnCallCamera = findViewById<Button>(R.id.btnCallCamera)
        var btnCallPhone = findViewById<Button>(R.id.btnCallPhone)
        var inputPhoneNumber = findViewById<EditText>(R.id.inputPhoneNumber)
        var btnFragment = findViewById<Button>(R.id.btnFragment)

        btnProdi.setOnClickListener {
            val namaProdi = inputProdi.text.toString()
            if (namaProdi.isEmpty()) {
                inputProdi.error = getString(R.string.error_input_prodi)
                return@setOnClickListener
            }

            val moveWithDataIntent = Intent(this@MainActivity, Practice5ReadDataActivity::class.java)
            moveWithDataIntent.putExtra(Practice5ReadDataActivity.EXTRA_PRODI, namaProdi)
            startActivity(moveWithDataIntent)
        }

        btnCallBrowser.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://ittelkom-pwt.ac.id/")
            startActivity(intent)
        }

        btnCallCamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        btnCallPhone.setOnClickListener {
            val phoneNumber = inputPhoneNumber.getText()
            if (phoneNumber.isEmpty()) {
                inputPhoneNumber.error = "Nomor Telpon Tidak Boleh Kosong"
                return@setOnClickListener
            }
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:" + phoneNumber)
            startActivity(intent)
        }

        btnFragment.setOnClickListener {
            val intent = Intent(this, Practice5ForFragmentActivity::class.java)
            startActivity(intent)
        }
    }
}