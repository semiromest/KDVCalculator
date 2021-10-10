package com.example.kdvcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kdvcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.hesaplaButton.setOnClickListener{

            kdvHesaplama()
        }
    }
    fun kdvHesaplama() {
        val ürünBedeliString = binding.urunTutari.text.toString()

        val tutar = ürünBedeliString.toDoubleOrNull()

        if (tutar == null) {

            binding.kdvTutariText.text = " "

            return

        }
        fun kdvUrunHesaplama(){


        }
        val secilenRadioButton = binding.kdvYuzdeSecenekleriRadioGroup.checkedRadioButtonId

        val kdvyuzdesi = when (secilenRadioButton) {

            R.id.yuzde_onbes_kdv -> 0.15

            R.id.yuzde_onsekiz_kdv -> 0.18

            else -> 0.20

        }

        var kdvstring = "KDV Tutarı :"

        var kdv = kdvyuzdesi * tutar

        val yukarıYuvarla = binding.yukariYuvarlansinMi.isChecked

        if (yukarıYuvarla)
        {
           kdv = kotlin.math.ceil(kdv)


        }
        binding.kdvTutariText.text="$kdvstring" + kdv.toString()
    }
}
