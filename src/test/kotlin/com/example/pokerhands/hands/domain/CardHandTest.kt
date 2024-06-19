package com.example.pokerhands.hands.domain

import com.example.pokerhands.hands.domain.exception.InvalidCardHandException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class CardHandTest {
    @Test
    fun `should card hand throw error if there is less than 5 cards`() {
        assertThrows<InvalidCardHandException> {
            CardHand("5S 4S 3S 2S")
        }
    }

    @Test
    fun `should card hand throw error if the formatting is incorrect`() {
        assertThrows<InvalidCardHandException> {
            CardHand("5S4S 3S 2S;3S")
        }
    }

    @Test
    fun `should create the object if card hand is valid`() {
        assertDoesNotThrow {
            CardHand("5S 4S 3S 2S 3H")
        }
    }
}