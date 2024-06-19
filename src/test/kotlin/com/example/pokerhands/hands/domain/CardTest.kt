package com.example.pokerhands.hands.domain

import com.example.pokerhands.hands.domain.exception.InvalidCardException
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class CardTest {
//    @ParameterizedTest
//    @ValueSource(chars = ['a'])
    @Test
    fun `should throw an error on invalid suit or invalid value`() {
        assertThrows<InvalidCardException> {
            Card("9Z")
        }

        assertThrows<InvalidCardException> {
            Card("0S")
        }

        assertThrows<InvalidCardException> {
            Card("0Z")
        }
    }

    @Test
    fun `should create the object if value & suit is correct`() {
        assertDoesNotThrow {
            Card("9S")
            Card("KS")
        }
    }
}