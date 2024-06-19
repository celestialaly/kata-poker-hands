package com.example.pokerhands.hands.domain

import com.example.pokerhands.hands.domain.rank.*

enum class Rank(val importance: Int) {
    HIGH_CARD(0),
    PAIR(1),
    TWO_PAIRS(2),
    THREE_OF_A_KIND(3),
    STRAIGHT(4),
    FLUSH(5),
    FULL_HOUSE(6),
    FOUR_OF_A_KIND(7),
    STRAIGHT_FLUSH(8);

    companion object {
        fun sortByImportance(): List<Rank> {
            return Rank.entries.sortedByDescending { it.importance }
        }
    }
}

class RankCalculator {
    companion object {
        fun isInside(cardHand: CardHand, rankTested: Rank): Boolean {
            return when (rankTested) {
                Rank.PAIR -> Pair.isInside(cardHand)
                Rank.TWO_PAIRS -> TwoPairs.isInside(cardHand)
                Rank.THREE_OF_A_KIND -> ThreeOfAKind.isInside(cardHand)
                Rank.STRAIGHT -> Straight.isInside(cardHand)
                Rank.FLUSH -> Flush.isInside(cardHand)
                Rank.FULL_HOUSE -> FullHouse.isInside(cardHand)
                Rank.FOUR_OF_A_KIND -> FourOfAKind.isInside(cardHand)
                Rank.STRAIGHT_FLUSH -> StraightFlush.isInside(cardHand)
                else -> false
            }
        }
    }
}

class CardHandScore(cardHand: CardHand) {
    private val rank: Rank

    init {
        rank = determineScore(cardHand)
    }

    private fun determineScore(cardHand: CardHand): Rank {
        Rank.sortByImportance().forEach {
            if (RankCalculator.isInside(cardHand, it)) {
                return it
            }
        }

        return Rank.HIGH_CARD
    }

    fun getRank(): Rank {
        return rank
    }
}