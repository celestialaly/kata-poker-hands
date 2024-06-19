package com.example.pokerhands.hands.orchestration

import org.junit.jupiter.api.Test

class CardHandOrchestratorAdapterTest {
    @Test
    fun `should return hand with a bigger ranking as winner`() {
        val firstHand = "5S 5H 3S 3H 8H"
        val secondHand = "5S 5H 3S 2S 8H"

        val cardHandOrchestrator: CardHandOrchestrator = CardHandOrchestratorAdapter()
        cardHandOrchestrator.compareHands(firstHand, secondHand)
    }
}