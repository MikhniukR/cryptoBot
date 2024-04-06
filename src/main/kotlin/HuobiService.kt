package ru.crypto.bot

import com.huobi.client.GenericClient
import com.huobi.client.MarketClient
import com.huobi.client.req.market.CandlestickRequest
import com.huobi.client.req.market.MarketDepthRequest
import com.huobi.constant.HuobiOptions
import com.huobi.constant.enums.CandlestickIntervalEnum
import com.huobi.constant.enums.DepthSizeEnum
import com.huobi.constant.enums.DepthStepEnum
import com.huobi.model.market.Candlestick
import java.util.function.Consumer
import java.util.stream.Collector
import java.util.stream.Collectors
import java.util.stream.IntStream

class HuobiService : CryptoService {

    // Create GenericClient instance and get the timestamp
    val genericService = GenericClient.create(HuobiOptions())
    val serverTime: Long = genericService.getTimestamp()

    // Create MarketClient instance and get btcusdt latest 1-min candlestick
    val marketClient = MarketClient.create(HuobiOptions())

    override fun getCourseForPair(pair: String): List<CoursePair> {
        val list: List<Candlestick> = marketClient.getCandlestick(
            CandlestickRequest(pair.lowercase(), CandlestickIntervalEnum.MIN1, 10)
        )

        list.forEach(Consumer { candlestick: Candlestick ->
            println(candlestick.toString())
        })
        return list.stream().map { CoursePair(it.vol.toDouble(), it.open.toDouble())}.collect(Collectors.toList())
    }

    override fun getOrderBook(pair: String): List<BidAsk> {
        val marketDepth = marketClient.getMarketDepth(MarketDepthRequest(pair, DepthStepEnum.STEP1))
        return IntStream.range(0, marketDepth.asks.size + marketDepth.bids.size)
            .mapToObj {
                if (it < marketDepth.asks.size) {
                    BidAsk(
                        marketDepth.asks[it].price.toDouble(),
                        marketDepth.asks[it].amount.toDouble(),
                        BidAskType.ASK
                    )
                } else {
                    BidAsk(marketDepth.bids[it - marketDepth.asks.size].price.toDouble(),
                        marketDepth.bids[it - marketDepth.asks.size].amount.toDouble(),
                        BidAskType.BID
                    )
                }
            }
            .collect(Collectors.toList())
    }

    override fun getSymbols(): Set<String> {
        return genericService.getSymbolsV2(1000).stream()
            .map { it.dn.toString() }
            .collect(Collectors.toSet())
    }
}