package ru.crypto.bot

interface CryptoService {
    fun getCourseForPair(pair: String): List<CoursePair>
    fun getOrderBook(pair: String): List<BidAsk>
    fun getSymbols(): Set<String>
}