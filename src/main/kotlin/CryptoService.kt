package ru.crypto.bot

interface CryptoService {
    fun getCourseForPair(pair: String): List<CoursePair>
    fun getOrderBook(pair: String): String
    fun getSymbols(): Set<String>
}