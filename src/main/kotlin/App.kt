import model.PlayerDataModel
import utils.IOUtils

class App {

    private val rock = "ROCK"
    private val scissor = "SCISSOR"
    private val paper = "PAPER"
    private var result = ""

    private val playersData = mutableListOf<PlayerDataModel>()

    private fun printHeader() {
        println(
            """
            ======================================
            GAME SUIT TERMINAL VERSION
            ======================================
            - ROCK
            - SCISSOR
            - PAPER
            ======================================
            Choose Your Choice : ROCK, SCISSOR, PAPER
            ======================================
   """.trimIndent()
        )
    }

    private fun inputPlayer() {
        for (index in 0..1) {
            val player = index.plus(1)
            println("Input Player $player Name: ")
            val playerName = IOUtils.readString()
            println("Input Player $player Choice: ")
            var playerChoice = IOUtils.readString().uppercase()

            while (!playerChoiceValidation(playerChoice)) {
                println("--------------------------------")
                println("Input only ROCK, SCISSOR, PAPER")
                println("Please input your choice again : ")
                playerChoice = IOUtils.readString().uppercase()
            }
            playersData.add(PlayerDataModel(playerName, playerChoice))
        }
    }

    fun playerChoiceValidation(playerInput: String): Boolean {
        var result = false
        if (playerInput == rock || playerInput == scissor || playerInput == paper) {
            result = true
        }
        return result
    }

    private fun checkResult() {
        val player1Input = playersData[0].playerChoice
        val player2Input = playersData[1].playerChoice

        if (player1Input == player2Input) {
            result = "DRAW!!!"
        } else if ((player1Input == rock && player2Input == scissor) ||
            (player1Input == scissor && player2Input == paper) ||
            (player1Input == paper && player2Input == rock)
        ) {
            result = "${playersData[0].playerName} Win!!!"
        } else if ((player1Input == scissor && player2Input == rock) ||
            (player1Input == paper && player2Input == scissor) ||
            (player1Input == rock && player2Input == paper)
        ) {
            result = "${playersData[1].playerName} Win!!!"
        } else {
            println("error")
        }
    }

    fun printResult() {
        checkResult()
        println()
        println("======================================")
        println("The Result is : $result")
        println("======================================")
    }

    fun run() {
        printHeader()
        inputPlayer()
        printResult()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App().run()
        }
    }
}