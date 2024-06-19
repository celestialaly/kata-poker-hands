package com.example.pokerhands.hands.domain

import com.example.pokerhands.hands.domain.exception.InvalidCardException

class Card(input: String) {
    private val value: CardValue
    private val suit: CardSuit

    init {
        try {
            require(input.length == 2)
            value = CardValue(input.first())
            suit = CardSuit(input.last())
        } catch (e: Exception) {
            throw InvalidCardException(input)
        }
    }

    fun getNumericValue(): Int {
        return value.getNumericValue()
    }

    fun getSuitValue(): Char {
        return suit.toChar()
    }
}