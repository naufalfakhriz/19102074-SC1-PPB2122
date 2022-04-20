package com.naufalfakhrizakaria_19102074.practice5activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.FragmentManager

class Practice5FirstFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var btnToSecondFragment = view.findViewById<Button>(R.id.btnToSecondFragment)
        var inputNamaSaya = view.findViewById<EditText>(R.id.inputNamaSaya)
        var inputNimSaya = view.findViewById<EditText>(R.id.inputNimSaya)

        btnToSecondFragment.setOnClickListener {
            val namaSaya = inputNamaSaya.text.toString()
            if (namaSaya.isEmpty()) {
                inputNamaSaya.error = "Nama Tidak Boleh Kosong"
                return@setOnClickListener
            }

            val nimSaya = inputNimSaya.text.toString()
            if (nimSaya.isEmpty()) {
                inputNimSaya.error = "Nim Tidak Boleh Kosong"
                return@setOnClickListener
            }

            val mReadDataFragment = Practice5ReadDataFragment()
            val mBundle = Bundle()
            mBundle.putString(Practice5ReadDataFragment.EXTRA_NAMA, namaSaya)
            mReadDataFragment.arguments = mBundle
            mReadDataFragment.nim = nimSaya.toInt()

            val mFragmentManager = fragmentManager as FragmentManager
            mFragmentManager
                .beginTransaction()
                .replace(R.id.frame_container, mReadDataFragment, Practice5ReadDataFragment::class.java.simpleName)
                .addToBackStack(null) .commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_practice5_first, container, false)
    }
}