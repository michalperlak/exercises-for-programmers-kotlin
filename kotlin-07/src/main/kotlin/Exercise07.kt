fun main(args: Array<String>) {
    val reader = NumberInputReader(InputValidator())

    val length = reader.askAndReadNumber("What is the length of the room in feet?")
    val width = reader.askAndReadNumber("What is the width of the room in feet?")

    println("You entered dimensions of $length feet by $width feet")

    val areaCalculator = AreaCalculator(length, width)
    println("The area is")
    println("${areaCalculator.getAreaInSquareFeet()} square feet")
    println("${areaCalculator.getAreaInSquareMeters()} square meters")
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