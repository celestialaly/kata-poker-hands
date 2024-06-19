package com.example.pokerhands.hands.domain.exception

class InvalidCardHandException(value: String): Exception("This card hand is invalid (badly formatted or missing cards): $value")