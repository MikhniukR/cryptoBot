package ru.huobi.bot

import com.binance.connector.client.SpotClient
import com.binance.connector.client.impl.SpotClientImpl
import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.entities.ChatId
import com.huobi.client.GenericClient
import com.huobi.client.MarketClient
import com.huobi.client.req.market.CandlestickRequest
import com.huobi.constant.HuobiOptions
import com.huobi.constant.enums.CandlestickIntervalEnum
import com.huobi.model.market.Candlestick
import org.json.JSONArray
import org.json.JSONObject
import java.util.HashMap
import java.util.function.Consumer


// Create GenericClient instance and get the timestamp
val genericService = GenericClient.create(HuobiOptions())
val serverTime: Long = genericService.getTimestamp()

// Create MarketClient instance and get btcusdt latest 1-min candlestick
val marketClient = MarketClient.create(HuobiOptions())

fun getCourseForPairHuobi(pair: String): List<Candlestick> {
    val list: List<Candlestick> = marketClient.getCandlestick(
        CandlestickRequest(pair, CandlestickIntervalEnum.MIN1, 10)
    )

    list.forEach(Consumer { candlestick: Candlestick ->
        println(candlestick.toString())
    })
    return list
}

fun getCourseForPairBinance(pair: String): String {
    val client: SpotClient = SpotClientImpl()
    val parameters: Map<String, Any> = hashMapOf(Pair("symbol", pair.uppercase()), Pair("limit", 10))
//    val parameters: Map<String, Any> = hashMapOf(Pair("symbol", ArrayList(listOf(pair.uppercase()))))
    var result: String
    try {
        result = client.createMarket().trades(parameters)
    } catch (e: Exception) {
        println(e)
        result = e.message.toString()
    }

    return result
}


fun main() {
    val bot = bot {
        token = "6913294045:AAGm75PNu_JX6eLhFU46-6y4FbR_5Q34CSQ"
        dispatch {
            command("start") {
                bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Hi there in Crypto trade bot!")
            }
            command("course") {
                val joinedArgs = args.joinToString()
                val response =
                    if (joinedArgs.isNotBlank()) getCourseForPairHuobi(joinedArgs).toString()
                    else "There is no text apart from command!"
                bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Huobi \n$response")
                bot.sendMessage(
                    chatId = ChatId.fromId(message.chat.id),
                    text = "Binance \n${getCourseForPairBinance(joinedArgs)}"
                )
            }
            command("symbols") {
                val response = genericService.getSymbolsV2(50)
                bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = response.toString())
            }
            command("help") {
                bot.sendMessage(
                    chatId = ChatId.fromId(message.chat.id),
                    text = "Hi there!, this is the list of commands:\n" +
                            "/start say hello\n" +
                            "/help show this message\n" +
                            "/course show trade pair course\n" +
                            "\"course btcusdt\"\n" +
                            "/symbols get all available symbols"
                )
            }
        }
    }
    bot.startPolling()
}