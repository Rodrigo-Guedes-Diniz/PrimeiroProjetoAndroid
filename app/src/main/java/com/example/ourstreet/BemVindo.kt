package com.example.ourstreet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ourstreet.databinding.ActivityBemVindoBinding
import com.example.ourstreet.databinding.ActivityMainBinding

class BemVindo : AppCompatActivity() {
    private lateinit var binding: ActivityBemVindoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBemVindoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BotaoSaberMais.setOnClickListener {
            val i = Intent(this, SaibaMais::class.java)
            startActivity(i)

            val nome = i.extras?.getString("nome")

            if (nome.equals("") || nome == null) {
                Toast.makeText(applicationContext, "Insira seu nome", Toast.LENGTH_LONG).show()
            } else {
                binding.BemVindoFulano.setText("Seja Bem Vindo, $nome")
            }

            binding.CadastroRuas?.setOnClickListener {
                val j = Intent(this, CadastroRuasActivity::class.java)
                startActivity(j)
            }

        }
    }
}