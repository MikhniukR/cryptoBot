package ru.crypto.bot

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ByBitService {
    fun serverTime():String {
        val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://api-testnet.bybit.com/v5/market/time"))
            .build();
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        return response.toString()
    }

    fun getOrderBook(pair: String): String {
        val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://api-testnet.bybit.com/v5/market/orderbook?category=spot&symbol=$pair&limit=5"))
            .build();
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        return response.body().toString()
    }

}