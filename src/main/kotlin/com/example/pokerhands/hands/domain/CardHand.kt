package com.example.pokerhands.hands.domain

import com.example.pokerhands.hands.domain.exception.InvalidCardHandException

const val VALID_CARD = "[2-9TJQKA][CDHS]"
const val VALID_HANDS = "^($VALID_CARD ){4}$VALID_CARD$"

class CardHand(value: String) {
    private val cards: List<Card>

    init {
        if(!Regex(VALID_HANDS).matches(value)) {
            throw InvalidCardHandException(value)
        }

        cards = value.split(' ')
            .map{ Card(it) }
            .sortedBy { it.getNumericValue() }
    }

    fun getCards(): List<Card> {
        return cards
    }

    fun getCardsNumericValues(): List<Int> {
        return cards.map { it.getNumericValue() }
    }

    fun getCardsSuitValues(): List<Char> {
        return cards.map { it.getSuitValue() }
    }
}