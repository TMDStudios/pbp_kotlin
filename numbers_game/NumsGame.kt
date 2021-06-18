import java.lang.Exception
import kotlin.random.Random

class NumsGame {

    init {
        println("Starting Numbers Game")
        game()
    }

    private fun game(){
        val answer = Random.nextInt(10)
        var count = 0
        while(count<3){
            print("Guess a number between 0 and 10: ")
            val guess = readLine()
            try {
                if(guess!!.toInt() == answer){
                    println("You got it!")
                    break
                }else{
                    if(count==2){
                        println("You lose. The number was $answer.")
                        break
                    }else{
                        println("Try again")
                    }
                }
                count++
                println("You have guessed $count time(s).")
            }catch (e: Exception){
                println("Please enter numbers only.")
            }
        }
        println("Game Finished")
    }
}