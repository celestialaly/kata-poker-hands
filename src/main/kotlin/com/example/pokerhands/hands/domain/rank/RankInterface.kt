package com.example.pokerhands.hands.domain.rank

import com.example.pokerhands.hands.domain.CardHand

interface RankInterface {
    fun isInside(cardHand: CardHand): Boolean
}