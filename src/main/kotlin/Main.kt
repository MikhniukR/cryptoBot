package ru.crypto.bot

import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.callbackQuery
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.InlineKeyboardMarkup
import com.github.kotlintelegrambot.entities.keyboard.InlineKeyboardButton
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.stream.Collectors

val binanceService = BinanceService()
val byBitService = ByBitService()
val huobiService = HuobiService()

fun main() {
    val bot = bot {
        token = "6913294045:AAGm75PNu_JX6eLhFU46-6y4FbR_5Q34CSQ"
        dispatch {
            command("start") {
                bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Hi there in Crypto trade bot!")
            }
            command("course") {
                val tradePair = args.joinToString()
                val response =
                    if (tradePair.isNotBlank()) huobiService.getCourseForPair(tradePair).toString()
                    else "There is no text apart from command!"
                runBlocking {
                    val job1 = launch {
                        bot.sendMessage(
                            chatId = ChatId.fromId(message.chat.id),
                            text = "#Huobi \n$response"
                        )
                    }
                    val job2 = launch {
                        bot.sendMessage(
                            chatId = ChatId.fromId(message.chat.id),
                            text = "#Binance \n${binanceService.getCourseForPair(tradePair)}"
                        )
                    }
                    val job3 = launch {
                        bot.sendMessage(
                            chatId = ChatId.fromId(message.chat.id),
                            text = "#ByBit \n${byBitService.getOrderBook(tradePair)}"
                        )
                    }
                    job1.join()
                    job2.join()
                    job3.join()
                }
            }
            command("symbols") {
                bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Please wait for 3 http requests")
                var symbolsHuobi = setOf("")
                var symbolsBinance = setOf("")
                var symbolsByBit = setOf("")
                runBlocking {
                    val job1 = launch {
                        symbolsHuobi = huobiService.getSymbols()
                    }
                    val job2 = launch {
                        symbolsBinance = binanceService.getSymbols()
                    }
                    val job3 = launch {
                        symbolsByBit = byBitService.getSymbols()
                    }
                    job1.join()
                    job2.join()
                    job3.join()
                }
                val symbols = symbolsHuobi.stream()
                    .map { it.replace("/", "") }
                    .filter { symbolsBinance.contains(it) }
//                    .filter {  symbolsByBit.contains(it) }
                    .collect(Collectors.toSet())
                bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = symbols.toString())
            }
            command("test") {
                val inlineKeyboardMarkup = InlineKeyboardMarkup.create(
                    listOf(InlineKeyboardButton.CallbackData(text = "Test Inline Button", callbackData = "testButton")),
                    listOf(InlineKeyboardButton.CallbackData(text = "Show alert", callbackData = "showAlert")),
                )
                bot.sendMessage(
                    chatId = ChatId.fromId(message.chat.id),
                    text = "Hello, inline buttons!",
                    replyMarkup = inlineKeyboardMarkup,
                )
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
            callbackQuery("testButton") {
                val chatId = callbackQuery.message?.chat?.id ?: return@callbackQuery
                bot.sendMessage(ChatId.fromId(chatId), callbackQuery.data)
            }
            callbackQuery(
                callbackData = "showAlert",
                callbackAnswerText = "HelloText",
                callbackAnswerShowAlert = true,
            ) {
                val chatId = callbackQuery.message?.chat?.id ?: return@callbackQuery
                bot.sendMessage(ChatId.fromId(chatId), callbackQuery.data)
            }
        }
    }
    bot.startPolling()
}
