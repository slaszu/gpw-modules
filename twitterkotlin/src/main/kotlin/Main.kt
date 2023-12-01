import pl.slaszu.twitterkotlin.TestService;

fun main() {
    println("Hello World!")

    val obj = TestService("aaa", "bbb")

    println(obj.get())

    println(obj.randomTest())
}