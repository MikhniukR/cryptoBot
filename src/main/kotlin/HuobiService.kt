package ru.crypto.bot

import com.huobi.client.GenericClient
import com.huobi.client.MarketClient
import com.huobi.client.req.market.CandlestickRequest
import com.huobi.constant.HuobiOptions
import com.huobi.constant.enums.CandlestickIntervalEnum
import com.huobi.model.market.Candlestick
import java.util.function.Consumer
import java.util.stream.Collector
import java.util.stream.Collectors

class HuobiService {

    // Create GenericClient instance and get the timestamp
    val genericService = GenericClient.create(HuobiOptions())
    val serverTime: Long = genericService.getTimestamp()

    // Create MarketClient instance and get btcusdt latest 1-min candlestick
    val marketClient = MarketClient.create(HuobiOptions())

    fun getCourseForPair(pair: String): List<Candlestick> {
        val list: List<Candlestick> = marketClient.getCandlestick(
            CandlestickRequest(pair.lowercase(), CandlestickIntervalEnum.MIN1, 10)
        )

        list.forEach(Consumer { candlestick: Candlestick ->
            println(candlestick.toString())
        })
        return list
    }

    fun getSymbols(): Set<String> {
        return genericService.getSymbolsV2(1000).stream()
            .map { it.dn.toString() }
            .collect(Collectors.toSet())
    }
}