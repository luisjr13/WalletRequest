package com.example.walletrequest
import android.telephony.mbms.StreamingServiceInfo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface CardService {

    @GET("cards") // Está fazendo um get na API(cards)-
    // fazendo isso: https://wallet-backend-theta.vercel.app/cards(Concatenando).
    fun findAll(): Call<List<Card>> // Função que vai pegar todos cards em forma de Lista.

    @GET("cards/{id}") // Essa é rota que vai ficar na url.
    fun findByid(@Path("id") cardId: String):Call<Card> // Path: Envia o valor do id para a rota.
    // O cardId: String é variável que vai ter o id. Call<Card>: É o retorno.

    @POST("cards/")
    fun createCard(@Body card:Card) : Call<Card>

    @PUT("cards/{id}")
    fun updateCard(@Path("id") cardId: String,@Body card:Card): Call<Card>

    @DELETE("cards/{id}")
    fun deleteById(@Path("id") CardId:String) : Call<Card>

    @DELETE("cards/")
    fun deleteAll() : Call<Any>

}