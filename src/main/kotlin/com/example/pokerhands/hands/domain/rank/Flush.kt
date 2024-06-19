package com.example.pokerhands.hands.domain.rank

import com.example.pokerhands.hands.domain.CardHand

class Flush {
    companion object: RankInterface {
        override fun isInside(cardHand: CardHand): Boolean {
            val suitValues = cardHand.getCardsSuitValues()
            val validSuit = suitValues.first()

            return suitValues.count { it == validSuit } == 5
        }
    }
}