package com.example.pokerhands.hands.domain

class CardSuit(private val value: Char) {
    private val validValues = arrayOf('C', 'D', 'H', 'S')

    init {
        require(validValues.contains(value))
    }

    fun toChar(): Char {
        return value
    }
}