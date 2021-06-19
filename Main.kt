
fun main(){
    var exit = false

    while(!exit){
        printWelcome()
        when(readLine() ?: "0"){
            "1" -> NumbersGame()
            "2" -> Calculator()
            "3" -> GuessThePhrase()
            "4" -> UsernameAndPassword()
            "5" -> exit = true
        }
    }
    println("Closing Program")
}

fun printWelcome(){
    val message = "This is a collection of select Project Based Python projects."
    for(i in message.indices){print("*")}
    println()
    println(message)
    for(i in message.indices){print("*")}
    println()
    println("Choose from the following menu:")
    println("1 => Numbers Game")
    println("2 => Calculator")
    println("3 => Guess the Phrase")
    println("4 => Username and Password")
    println("5 => Quit")
    print(">>")
}