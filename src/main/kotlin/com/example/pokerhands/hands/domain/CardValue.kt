package com.example.pokerhands.hands.domain

enum class FigureValue(val value: Char) {
    JACK('J'),
    QUEEN('Q'),
    KING('K'),
    ACE('A')
}

val validValues = charArrayOf(
    '2', '3', '4', '5', '6', '7', '8', '9', 'T',
    FigureValue.JACK.value, FigureValue.QUEEN.value, FigureValue.KING.value, FigureValue.ACE.value
)

class CardValue(private val value: Char) {
    init {
        require(validValues.contains(value))
    }

    fun getNumericValue(): Int {
        return validValues.indexOf(value) + 2
    }

    companion object {
        fun getAceNumericValue(): Int {
            return validValues.indexOf(FigureValue.ACE.value) + 2
        }
    }
}