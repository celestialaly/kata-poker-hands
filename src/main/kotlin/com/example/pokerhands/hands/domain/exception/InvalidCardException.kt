package com.example.pokerhands.hands.domain.exception

class InvalidCardException(value: String): Exception("This card has an invalid value or suit: $value")