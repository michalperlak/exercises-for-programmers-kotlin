fun main(args: Array<String>) {
    print("Enter a noun: ")
    val noun = readLine()

    print("Enter a verb: ")
    val verb = readLine()

    print("Enter an adjective: ")
    val adjective = readLine()

    print("Enter an adverb: ")
    val adverb = readLine()

    println(generateStory(noun, verb, adjective, adverb))
}

fun generateStory(noun: String?, verb: String?, adjective: String?, adverb: String?): String = "Do you $verb your $adjective $noun $adverb?. Amazing!!!"

