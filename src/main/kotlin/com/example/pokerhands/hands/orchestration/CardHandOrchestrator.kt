package com.example.pokerhands.hands.orchestration

import com.example.pokerhands.hands.domain.CardHand

interface CardHandOrchestrator {
    fun compareHands(hand: String, otherHand: String)
}

class CardHandOrchestratorAdapter: CardHandOrchestrator {
    override fun compareHands(hand: String, otherHand: String) {
        val cardHand = CardHand(hand)
        val secondCardHand = CardHand(otherHand)

        //TODO implement comparator
    }
}