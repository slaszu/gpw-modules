package pl.slaszu.twitterkotlin;

import pl.slaszu.twitterkotlin.dto.Test

class TestService(val x:String, val y:String) {
    fun get():String {
        return "X: ${this.x} , Y: ${this.y}"
    }

    fun randomTest(): Test {
        return Test("Przeminelo z wiatrem", "Michell")
    }
}