package ru.crypto.bot

import org.json.JSONArray
import org.json.JSONObject
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.stream.Collectors
import java.util.stream.IntStream

class ByBitService : CryptoService {
    fun serverTime(): String {
        val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://api-testnet.bybit.com/v5/market/time"))
            .build();
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        return response.toString()
    }

    override fun getCourseForPair(pair: String): List<String> {
        val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://api-testnet.bybit.com/v5/market/tickers?category=inverse&symbol=$pair"))
            .build()
        val response = JSONArray(
            JSONObject(
                client.send(request, HttpResponse.BodyHandlers.ofString()).body()
            ).getJSONObject("result")
                .getJSONArray("list")
        )

        return IntStream.range(0, response.length())
            .mapToObj { response.getJSONObject(it).toString() }
            .collect(Collectors.toList())
    }


    override fun getOrderBook(pair: String): String {
        val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://api-testnet.bybit.com/v5/market/orderbook?category=spot&symbol=${pair.uppercase()}&limit=5"))
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        return response.body().toString()
    }

    override fun getSymbols(): Set<String> {
        val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://api-testnet.bybit.com/v5/market/instruments-info?category=spot"))
            .build()
        val response = JSONObject(client.send(request, HttpResponse.BodyHandlers.ofString()))
        if (!response.has("symbols"))
            return setOf()
        val symbols = JSONArray(response.getJSONArray("symbols"))
        return IntStream.range(0, symbols.length())
            .mapToObj { symbols.getString(it) }
            .collect(Collectors.toSet())
    }

}