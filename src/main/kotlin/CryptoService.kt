package ru.crypto.bot

interface CryptoService {
    fun getCourseForPair(pair: String): List<String>
    fun getOrderBook(pair: String): String
    fun getSymbols(): Set<String>
}