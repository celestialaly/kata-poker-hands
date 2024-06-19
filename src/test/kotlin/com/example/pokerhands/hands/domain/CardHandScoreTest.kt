package com.example.pokerhands.hands.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CardHandScoreTest {
    @Test
    fun `should be a high card`() {
        val hand = CardHand("KS 5H 3S 2S 8H")
        val score = CardHandScore(hand)
        score.getRank() shouldBe Rank.HIGH_CARD
    }

    @Test
    fun `should be a pair`() {
        val hand = CardHand("5S 5H 3S 2S 8H")
        val score = CardHandScore(hand)
        score.getRank() shouldBe Rank.PAIR
    }

    @Test
    fun `should be a two pairs`() {
        val hand = CardHand("5S 5H 3S 3H 8H")
        val score = CardHandScore(hand)
        score.getRank() shouldBe Rank.TWO_PAIRS
    }

    @Test
    fun `should be a three of a kind`() {
        val hand = CardHand("5S 5H 5D 3H 8H")
        val score = CardHandScore(hand)
        score.getRank() shouldBe Rank.THREE_OF_A_KIND
    }

    @Test
    fun `should be a straight`() {
        var hand = CardHand("5S 6H 7D 8H 9S")
        var score = CardHandScore(hand)
        score.getRank() shouldBe Rank.STRAIGHT

        // test with Ace acting as a 1
        hand = CardHand("AS 2H 3D 4H 5S")
        score = CardHandScore(hand)
        score.getRank() shouldBe Rank.STRAIGHT
    }

    @Test
    fun `should be a flush`() {
        val hand = CardHand("2H 5H 8H 9H KH")
        val score = CardHandScore(hand)
        score.getRank() shouldBe Rank.FLUSH
    }

    @Test
    fun `should be a full house`() {
        val hand = CardHand("2H 2C 2S 4H 4S")
        val score = CardHandScore(hand)
        score.getRank() shouldBe Rank.FULL_HOUSE
    }

    @Test
    fun `should be a four of a kind`() {
        val hand = CardHand("2H 2C 2S 2D 4S")
        val score = CardHandScore(hand)
        score.getRank() shouldBe Rank.FOUR_OF_A_KIND
    }

    @Test
    fun `should be a straight flush`() {
        var hand = CardHand("5S 6S 7S 8S 9S")
        var score = CardHandScore(hand)
        score.getRank() shouldBe Rank.STRAIGHT_FLUSH

        // test with Ace acting as a 1
        hand = CardHand("AS 2S 3S 4S 5S")
        score = CardHandScore(hand)
        score.getRank() shouldBe Rank.STRAIGHT_FLUSH
    }
}