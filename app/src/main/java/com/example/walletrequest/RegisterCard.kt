package com.example.walletrequest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.UUID

class RegisterCard : AppCompatActivity() {

    private lateinit var config: RetroConfig

    private var service:CardService? = null

    companion object {
        const val KEY_CARD = "KEY_CARD"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registercard)

       config = RetroConfig()
        service = config.cardService




        val CardNumber = findViewById<EditText>(R.id.edCardNumber)
        val Name = findViewById<EditText>(R.id.edNameTitular)
        val Venc = findViewById<EditText>(R.id.edVenci)
        val CodSeg = findViewById<EditText>(R.id.edCodseg)
        val BottonAvancar = findViewById<Button>(R.id.btavancar)

        BottonAvancar.setOnClickListener {
            val idCard: String = UUID.randomUUID().toString()
            val cardType = "GREEN"
            val name = Name.text
            val Venc = Venc.text
            val edCodSeg = CodSeg.text
            val cardNumber = CardNumber.text

            val novoCard = Card(
                id = idCard,
                name = name.toString(),
                cvv = edCodSeg.toString(),
                expirationDate = Venc.toString(),
                Typecard = cardType,
                number = cardNumber.toString()
            )


            executarRequest(novoCard)

        }



    }

    private fun executarRequest(newCard: Card){
        service?.createCard(newCard)?.enqueue(object: Callback<Card> {
            override fun onResponse(call: Call<Card>, response: Response<Card>) {
                Toast.makeText(
                    this@RegisterCard,
                    "Cadastro Realizado com sucesso",
                    Toast.LENGTH_LONG
                ).show()
                Intent(this@RegisterCard,ConfirmCard::class.java).also {
                    it.putExtra(KEY_CARD,newCard.id)
                    startActivity(it)
                }



            }

            override fun onFailure(call: Call<Card>, t: Throwable) {
                Toast.makeText(this@RegisterCard, "Erro, Communication Failed", Toast.LENGTH_LONG)
                    .show()
            }

        })

        }
    }

