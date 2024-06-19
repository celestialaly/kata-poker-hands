package com.example.pokerhands.hands.domain.rank

import com.example.pokerhands.hands.domain.CardHand

class FourOfAKind {
    companion object: RankInterface {
        override fun isInside(cardHand: CardHand): Boolean {
            val numericValues = cardHand.getCardsNumericValues()

            return numericValues.groupingBy { it }.eachCount().filterValues { it == 4 }.isNotEmpty()
        }
    }
}