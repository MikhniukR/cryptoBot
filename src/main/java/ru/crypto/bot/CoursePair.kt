package ru.crypto.bot

class CoursePair(val volume: Double, val price: Double) {
    override fun toString(): String {
        return "price = $price, volume = $volume\n"
    }

}
