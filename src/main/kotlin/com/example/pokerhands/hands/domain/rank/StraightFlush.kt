package com.example.pokerhands.hands.domain.rank

import com.example.pokerhands.hands.domain.CardHand
import com.example.pokerhands.hands.domain.CardValue

class StraightFlush {
    companion object: RankInterface {
        override fun isInside(cardHand: CardHand): Boolean {
            return Straight.isInside(cardHand) && Flush.isInside(cardHand)
        }
    }
}