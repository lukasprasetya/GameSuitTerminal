class App {

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


    fun run() {
        printHeader()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App().run()
        }
    }
}