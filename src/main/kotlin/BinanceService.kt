package ru.crypto.bot

import com.binance.connector.client.SpotClient
import com.binance.connector.client.enums.DefaultUrls.PROD_URL
import com.binance.connector.client.impl.SpotClientImpl
import org.json.JSONArray
import org.json.JSONObject
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.function.IntFunction
import java.util.stream.Collectors
import java.util.stream.IntStream



class BinanceService {

    val client: SpotClient = SpotClientImpl()

    fun getCourseForPair(pair: String): String {
        val parameters: Map<String, Any> = hashMapOf(Pair("symbol", pair.uppercase()), Pair("limit", 10))
        var result: String
        try {
            result = client.createMarket().trades(parameters)
        } catch (e: Exception) {
            println(e)
            result = e.message.toString()
        }

        return result
    }

    fun getSymbols(): Set<String> {
        val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
            .uri(URI.create("${PROD_URL}/api/v3/exchangeInfo"))
            .build();
        val response = JSONObject(client.send(request, HttpResponse.BodyHandlers.ofString()).body())
        val symbols = JSONArray(response.getJSONArray("symbols"))
        return IntStream.range(0, symbols.length())
            .mapToObj { symbols.getJSONObject(it).getString("symbol") }
            .collect(Collectors.toSet())
    }
}