package com.naufalfakhrizakaria_19102074.practice5activity

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class Practice5ReadDataFragment : Fragment() {
    var nim: Int? = null
    companion object {
        var EXTRA_NAMA = ""
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var tvMyData = view.findViewById<TextView>(R.id.tvMyData)
        var btnKembaliBeranda = view.findViewById<Button>(R.id.btnKembaliBeranda)

        if (arguments != null) {
            val myName = arguments?.getString(EXTRA_NAMA)
            tvMyData.text = "Nama Saya : $myName, NIM Saya : $nim"
        }

        btnKembaliBeranda.setOnClickListener {
            val mIntent = Intent(activity, MainActivity::class.java)
            startActivity(mIntent)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_practice5_read_data, container, false)
    }
}