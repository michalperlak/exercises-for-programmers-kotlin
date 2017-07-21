import java.time.Instant
import java.time.Year

fun main(args: Array<String>) {
    val reader = NumberInputReader(InputValidator())

    val currentAge = reader.askAndReadNumber("What is your current age?")
    val retirementAge = reader.askAndReadNumber("At what age would you like to retire?")
    val calculator = RetirementCalculator(currentAge, retirementAge, Year.now().value)

    println("You have ${calculator.getYearsToRetirement()} left until you can retire")
    println("It's ${Year.now().value}, so you can retire in ${calculator.getRetirementYear()}")
}

class RetirementCalculator(val currentAge: Int, val retirementAge: Int, val currentYear: Int) {
    fun getRetirementYear(): Int  = currentYear + getYearsToRetirement()
    fun getYearsToRetirement(): Int  = retirementAge - currentAge
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