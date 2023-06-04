package com.example.walletrequest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConfirmCard : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_card)
        val cardId = intent.getStringExtra(RegisterCard.KEY_CARD).toString()

        val nameCardholder = findViewById<TextView>(R.id.tvnameTitular)

        val cardNumber = findViewById<TextView>(R.id.tvnumberCard)

        val expirationCard = findViewById<TextView>(R.id.tvVenci)

        val CardCvv = findViewById<TextView>(R.id.tvCodseg)

        var Typecard = findViewById<TextView>(R.id.tvColorcard)

         var btReturnmain = findViewById<Button>(R.id.btPagemain)

        btReturnmain.setOnClickListener {
          var intentPagemain =  Intent(this,MainActivity::class.java)
            startActivity(intentPagemain)

        }

         val retroconfig : RetroConfig = RetroConfig()
         val service = retroconfig.cardService
        cardId?.let {
            service.findByid(cardId).enqueue(object: Callback<Card>{
                override fun onResponse(call: Call<Card>, response: Response<Card>) {
                    val card = response.body()
                    nameCardholder.text = card?.name
                    cardNumber.text = card?.number
                    expirationCard.text = card?.expirationDate
                    CardCvv.text = card?.cvv
                    Typecard.text = card?.Typecard


                }

                override fun onFailure(call: Call<Card>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }






    }
}