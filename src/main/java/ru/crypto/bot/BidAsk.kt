package ru.crypto.bot

class BidAsk(price: Double, value: Double, type: BidAskType) {
    val price: Double = price
        get() {
            return field
        }
    val value: Double = value
        get() {
            return field
        }
    val type: BidAskType = type
        get() {
            return field
        }

    override fun toString(): String {
        return "price = $price, value = $value\n, $type"
    }
}

enum class BidAskType {
    BID,
    ASK
}
