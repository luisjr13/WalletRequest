package com.example.walletrequest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottonOpencard = findViewById<Button>(R.id.btCadcard)
        val bottonListcards = findViewById<Button>(R.id.myCards)

        bottonOpencard.setOnClickListener {
            val skipCreatepag = Intent(this,RegisterCard::class.java)
            startActivity(skipCreatepag)
        }
        bottonListcards.setOnClickListener {
             val skipListcardpag = Intent(this,ShowAllCards::class.java)
            startActivity(skipListcardpag)
        }


    }
}