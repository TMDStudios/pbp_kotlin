class GuessThePhrase {
    init {
        println("Starting Guess the Phrase")
        game()
        println("Press 'Enter' to continue")
        readLine()
    }

    private fun game(){
        val answer = "this is the secret phrase"

        val myAnswerDictionary = mutableMapOf<Int, Char>()
        var myAnswer = ""

        for(i in answer.indices){
            if(answer[i] == ' '){
                myAnswerDictionary[i] = ' '
                myAnswer += ' '
            }else{
                myAnswerDictionary[i] = '*'
                myAnswer += '*'
            }
        }

        var guessedLetters = ""
        var count = 0
        var multipleLetters = false

        println("Can you decipher the text?")
        println(myAnswer)

        while(count<10){
            myAnswer = ""
            if(!multipleLetters){
                print("Guess the full text: ")
                val guessAnswer = readLine()
                if(guessAnswer==answer){
                    println("You win!")
                    break
                }else{
                    println("Incorrect guess")
                }
            }
            multipleLetters = false
            print("Guess a letter: ")
            val guess = readLine()
            if(guess!!.length==1){
                for(i in answer.indices){
                    if(answer[i] == guess[0]){myAnswerDictionary[i] = guess[0]}
                }
                for(i in myAnswerDictionary){myAnswer+= myAnswerDictionary[i.key]
                }

                if(myAnswer==answer){
                    println(myAnswer)
                    println("You win!")
                    break
                }

                if(guessedLetters.isEmpty()){guessedLetters+=guess[0]}else{guessedLetters+=", "+guess[0]}

                println(myAnswer)
                println("Guessed letters: $guessedLetters")

                count++
                val guessesLeft = 10 - count
                if(count<10){println("$guessesLeft guesses remaining")}
            }else{
                println("Please enter only one letter.")
                multipleLetters = true
            }
        }
        println("The phrase was: $answer")
        println("Game Over")
    }
}