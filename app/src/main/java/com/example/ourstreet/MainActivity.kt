package com.example.ourstreet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ourstreet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BotaoMain.setOnClickListener {
            val username = binding.NomeMain.text.toString()

            if (username.equals("")) {
                Toast.makeText(applicationContext,"Insira seu nome de usuario", Toast.LENGTH_LONG).show()
            } else {
                //Ir para a proxima tela
                val i = Intent(this, BemVindo::class.java)
                i.putExtra("nome", username)
                startActivity(i)
            }
        }
    }
}