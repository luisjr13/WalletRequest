package com.example.walletrequest

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class ViewHolderCards(itemView:View): RecyclerView.ViewHolder(itemView) {

    private var Container:ConstraintLayout
    private var Namecard: TextView
    private var cardNumber:TextView
    private var Venci:TextView
    private var Codseg:TextView
    private var colorCard:TextView

    init {
        Container = itemView.findViewById(R.id.clContainer)
        Namecard = itemView.findViewById(R.id.tvnameTitular)
        cardNumber= itemView.findViewById(R.id.tvnumberCard)
        Venci = itemView.findViewById(R.id.tvVenci)
        Codseg = itemView.findViewById(R.id.tvCodseg)
        colorCard = itemView.findViewById(R.id.tvColorcard)
    }

    fun configItens(card: Card){
        Namecard.text = card.name
        cardNumber.text = card.number
        Venci.text = card.expirationDate
        Codseg.text = card.cvv
       colorCard.text = card.Typecard
        if (colorCard.text == "GREEN"){
         Container.setBackgroundResource(R.drawable.blue_card)
        }else{
            Container.setBackgroundResource(R.drawable.Yellow_card)
        }

    }



}