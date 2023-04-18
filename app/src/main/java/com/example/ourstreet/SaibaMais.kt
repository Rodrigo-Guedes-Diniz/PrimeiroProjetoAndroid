package com.example.ourstreet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ourstreet.databinding.ActivitySaibaMaisBinding

class SaibaMais : AppCompatActivity() {

    private lateinit var binding: ActivitySaibaMaisBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySaibaMaisBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saiba_mais)

        binding.BotaoVoltar.setOnClickListener {
            val i = Intent(this, BemVindo::class.java)
            startActivity(i)




        }
    }
}