package com.example.pokerhands.hands.domain.rank

import com.example.pokerhands.hands.domain.CardHand
import com.example.pokerhands.hands.domain.CardValue

class Straight {
    companion object: RankInterface {
        override fun isInside(cardHand: CardHand): Boolean {
            val numericValues = cardHand.getCardsNumericValues()

            return isSequential(numericValues) || isSequentialIfAceIsPresent(numericValues)
        }

        private fun isSequential(values: List<Int>): Boolean {
            for (i in 1..< values.count()) {
                if (values[i] != values[i - 1] + 1) {
                    return false
                }
            }

            return true
        }

        private fun isSequentialIfAceIsPresent(values: List<Int>): Boolean {
            if (!values.contains(CardValue.getAceNumericValue())) return false

            val newValues = values.dropLast(1).toMutableList()
            newValues.add(0, 1)

            return isSequential(newValues.toList())
        }
    }
}