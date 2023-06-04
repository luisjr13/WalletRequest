package com.example.walletrequest

val ListCard:List<Card> = emptyList()

abstract data class Card(

    val id:String,
    val name:String,
    val cvv:String,
    val number:String,
    val expirationDate:String,
    val Typecard:String,
) {
    val Typecard: CharSequence?
}
