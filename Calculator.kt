import java.util.Scanner


class Calculator {
    fun performOperation(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
        return operation(num1, num2)
    }
}


fun main() {
    val scanner = Scanner(System.`in`)
    val calculator = Calculator()


    while (true) {
        println("Enter the first number:")
        val num1 = scanner.nextInt()


        println("Enter the second number:")
        val num2 = scanner.nextInt()


        println("Select operation:")
        println("1. Add")
        println("2. Subtract")
        println("3. Multiply")
        println("4. Divide")
        println("5. Exit")
        print("Enter operation number: ")


        val operation = scanner.nextInt()


        when (operation) {
            1 -> println("Result: $num1 + $num2 = ${calculator.performOperation(num1, num2) { a, b -> a + b }}")
            2 -> println("Result: $num1 - $num2 = ${calculator.performOperation(num1, num2) { a, b -> a - b }}")
            3 -> println("Result: $num1 * $num2 = ${calculator.performOperation(num1, num2) { a, b -> a * b }}")
            4 -> {
                if (num2 == 0) {
                    println("Cannot divide by zero.")
                } else {
                    println("Result: $num1 / $num2 = ${calculator.performOperation(num1, num2) { a, b -> a / b }}")
                }
            }
            5 -> {
                println("Exiting the calculator.")
                return
            }
            else -> println("Invalid operation number.")
        }


        println("Do you want to perform another operation? (Y/N)")
        val choice = scanner.next()


        if (choice.equals("N", ignoreCase = true)) {
            println("Exiting the calculator.")
            return
        }
    }
}
