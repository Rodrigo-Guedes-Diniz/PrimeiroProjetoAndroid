package com.example.ourstreet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.sql.Ref

class ListaRuasActivity : AppCompatActivity() {
    private lateinit var ruasRecyclerView: RecyclerView
    private lateinit var tvLoadingData: TextView
    private lateinit var ruasLista: ArrayList<CadastroRuas>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_ruas)

        ruasRecyclerView = findViewById(R.id.tvListaRuas)
        ruasRecyclerView.layoutManager = LinearLayoutManager(this)
        ruasRecyclerView.setHasFixedSize(true)
        tvLoadingData = findViewById(R.id.tvLoadingData)

        ruasLista = arrayListOf<CadastroRuas>()

        getRuasData()

        }

        private fun getRuasData() {

            ruasRecyclerView.visibility = View.GONE
            tvLoadingData.visibility = View.VISIBLE

            dbRef = FirebaseDatabase.getInstance().getReference("Cadastro")

            dbRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    ruasLista.clear()
                    if (snapshot.exists()) {
                        for (ruaSnap in snapshot.children){
                            val ruaData = ruaSnap.getValue(CadastroRuas::class.java)
                            ruasLista.add(ruaData!!)
                        }
                        val rAdapter = ruasAdapter(ruasLista)
                        ruasRecyclerView.adapter = rAdapter


                        ruasRecyclerView.visibility = View.VISIBLE
                        tvLoadingData.visibility = View.GONE
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })

        }


    }

