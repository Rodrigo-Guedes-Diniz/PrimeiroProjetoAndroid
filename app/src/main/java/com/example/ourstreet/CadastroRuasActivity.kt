package com.example.ourstreet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ourstreet.databinding.ActivityCadastroRuasBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class CadastroRuasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastroRuasBinding
    private lateinit var dbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroRuasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var edNomeRua = binding.edNomeRua
        var edNomeBairro = binding.edNomeBairro
        var edNomeCidade = binding.edNomeCidade
        var btcadastrar = binding.button
        var btListar = binding.ListaRuas

        dbRef = FirebaseDatabase.getInstance().getReference("UsuarioCadastrar")

        btcadastrar.setOnClickListener {
            val NomeRua = edNomeRua.text.toString()
            val NomeBairro = edNomeBairro.text.toString()
            val NomeCidade = edNomeCidade.text.toString()

            if (NomeRua.isEmpty()) {
                edNomeRua.error = "Por favor insira um nome"
            }
            if (NomeBairro.isEmpty()) {
                edNomeBairro.error = "Por favor insira um Cargo"
            }
            if (NomeCidade.isEmpty()) {
                edNomeCidade.error = "Por favor insira um Salário"
            }

            val ruaId = dbRef.push().key!!

            val cadastro = CadastroRuas(ruaId, NomeRua, NomeBairro, NomeCidade)

            dbRef.child(ruaId).setValue(cadastro)
                .addOnCompleteListener {
                Toast.makeText(this, "Cadastro Realizado", Toast.LENGTH_LONG).show()

                    edNomeRua.text.clear()
                    edNomeBairro.text.clear()
                    edNomeCidade.text.clear()

                } .addOnFailureListener {err ->
                    Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
                }

        }

        btListar.setOnClickListener {
            val i = Intent(this, ListaRuasActivity::class.java)
            startActivity(i)
        }

    }
}