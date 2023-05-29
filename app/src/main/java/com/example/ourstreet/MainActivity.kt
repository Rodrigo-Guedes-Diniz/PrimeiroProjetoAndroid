package com.example.ourstreet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ourstreet.databinding.ActivityMainBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BotaoMain.setOnClickListener {
            val username = binding.NomeMain.text.toString()

            if (username == "rodrigo") {
                Toast.makeText(applicationContext,"Insira seu nome de usuario", Toast.LENGTH_LONG).show()

                /* testando conexao com Firebase
                val database = Firebase.database
                val myRef = database.getReference("message")

                myRef.setValue("Hello, World!") */

            } else {
                //Ir para a proxima tela
                val i = Intent(this, BemVindo::class.java)
                i.putExtra("nome", username)
                startActivity(i)
            }

        }
    }
}