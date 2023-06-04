package com.example.walletrequest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterCards(var listaDeCards: List<Card>): RecyclerView.Adapter<ViewHolderCards>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCards {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.card_item,parent,false)
        return ViewHolderCards(view)
    }

    override fun getItemCount(): Int {
        return listaDeCards.size
    }

    override fun onBindViewHolder(holder: ViewHolderCards, position: Int) {
        val cards:Card = listaDeCards[position]
        holder.configItens(cards)
    }
}