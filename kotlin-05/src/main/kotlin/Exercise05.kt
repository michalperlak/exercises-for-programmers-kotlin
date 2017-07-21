fun main(args: Array<String>) {
    val reader = NumberInputReader(InputValidator())

    val first = reader.askAndReadNumber("What is the first number?")
    val second = reader.askAndReadNumber("What is the second number?")

    val resultPrinter = BasicIntOperationsPrinter()
    resultPrinter.print(first, second)
}

class BasicIntOperationsPrinter {
    fun print(first: Int, second: Int) {
        println("$first + $second = ${first + second}")
        println("$first - $second = ${first - second}")
        println("$first * $second = ${first * second}")
        if (second != 0) {
            println("$first / $second = ${first / second}")
        }
    }
}

class NumberInputReader(val validator: InputValidator) {
    fun askAndReadNumber(message: String): Int {
        var number: String?
        do {
            print(message)
            number = readLine()
        } while (!validator.validate(number))

        return number!!.toInt()
    }
}

class InputValidator {
    fun validate(input: String?): Boolean {
        if (input == null) {
            return false
        }

        try {
            val number = input.toInt()
            return number >= 0
        } catch (e: Exception) {
            return false
        }
    }
}