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

    override fun getCourseForPair(pair: String): List<CoursePair> {
        val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
                .uri(URI.create("https://api-testnet.bybit.com/v5/market/tickers?category=spot&symbol=${pair.uppercase()}"))
            .build()
        val response = JSONArray(
            JSONObject(
                client.send(request, HttpResponse.BodyHandlers.ofString()).body()
            ).getJSONObject("result")
                .getJSONArray("list")
        )

        return IntStream.range(0, response.length())
            .mapToObj { response.getJSONObject(it) }
            .flatMap {
                listOf(CoursePair(it.getDouble("bid1Size"), it.getDouble("bid1Price")),
                    CoursePair(it.getDouble("ask1Size"), it.getDouble("ask1Price"))
                ).stream()
            }
            .collect(Collectors.toList())
    }


    override fun getOrderBook(pair: String): List<BidAsk> {
        val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://api-testnet.bybit.com/v5/market/orderbook?category=spot&symbol=${pair.uppercase()}&limit=20"))
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        val result = JSONObject(response.body().toString()).getJSONObject("result")
        val asks = result.getJSONArray("a")
        val bids = result.getJSONArray("b")
        return IntStream.range(0, asks.length() + bids.length())
            .mapToObj {
                if (it < asks.length()) {
                    BidAsk(
                        asks.getJSONArray(it).getDouble(0),
                        asks.getJSONArray(it).getDouble(1),
                        BidAskType.ASK
                    )
                } else {
                    BidAsk(
                        bids.getJSONArray(it - asks.length()).getDouble(0),
                        asks.getJSONArray(it - asks.length()).getDouble(1),
                        BidAskType.BID
                    )
                }
            }
            .collect(Collectors.toList())
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