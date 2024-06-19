package com.example.pokerhands.hands.domain.rank

import com.example.pokerhands.hands.domain.CardHand

class FullHouse {
    companion object: RankInterface {
        override fun isInside(cardHand: CardHand): Boolean {
            val numericValues = cardHand.getCardsNumericValues()
            val eachCount = numericValues.groupingBy { it }.eachCount()

            return eachCount.filterValues { it == 3 }.isNotEmpty() && eachCount.filterValues { it == 2 }.isNotEmpty()
        }
    }
}