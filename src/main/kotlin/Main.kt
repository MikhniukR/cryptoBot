package ru.huobi.bot

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
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
import java.util.*
import java.util.function.Consumer

// Create GenericClient instance and get the timestamp
val genericService = GenericClient.create(HuobiOptions())
val serverTime: Long = genericService.getTimestamp()

// Create MarketClient instance and get btcusdt latest 1-min candlestick
val marketClient = MarketClient.create(HuobiOptions())

fun getCourseForPair(pair: String): List<Candlestick> {
    val list: List<Candlestick> = marketClient.getCandlestick(
        CandlestickRequest(pair, CandlestickIntervalEnum.MIN1, 10)
    )

    list.forEach(Consumer { candlestick: Candlestick ->
        println(candlestick.toString())
    })
    return list
}

fun main() {
    val objectMapper = ObjectMapper()
    val bot = bot {
        token = "6913294045:AAGm75PNu_JX6eLhFU46-6y4FbR_5Q34CSQ"
        dispatch {
            command("start") {
                bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Hi there in Huobi trade bot!")
            }
            command("course") {
                val joinedArgs = args.joinToString()
                val response =
                    if (joinedArgs.isNotBlank()) getCourseForPair(joinedArgs).toString()
                    else "There is no text apart from command!"
                bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = response)
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