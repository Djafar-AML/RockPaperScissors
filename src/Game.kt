import kotlin.random.Random

fun main() {
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)

    printResult(userChoice, gameChoice)


}

fun getGameChoice(options: Array<String>) = options[Random.nextInt(options.size)]

fun getUserChoice(options: Array<String>): String {

    var isValidChoice = false
    var userChoice = ""

    // loop until the user enters a valid choice
    while (!isValidChoice) {

        println("Please enter one of the following: ")

        for (item in options)
            print(" $item")
        println(".")

        // read the user input
        val userInput = readLine()

        // validate  the user input
        if ((userInput != null) && (userInput in options)) {
            isValidChoice = true
            userChoice = userInput
        }
        if (!isValidChoice) println("you must enter a valid choice.")
    }

    return userChoice
}

fun printResult(userChoice: String, gameChoice: String) {
    var result = ""
    if (gameChoice == userChoice) {
        result = "Tie"
    } else if ((userChoice == "Rock") && (gameChoice == "Scissors")
        || ((userChoice == "Paper") && (gameChoice == "Rock"))
        || ((userChoice == "Scissors") && (gameChoice == "Paper"))
    ) {
        result = "You win!"
    } else {
        result = "You lose!"
    }
    println("You chose $userChoice. I chose $gameChoice. $result")


}
