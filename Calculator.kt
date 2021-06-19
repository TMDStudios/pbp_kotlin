import java.lang.Exception

class Calculator {
    init {
        println("Starting Calculator")
        start()
        println("Press 'Enter' to continue")
        readLine()
    }

    private fun calculate(num1: Float, operator: Char, num2: Float) : Float{
        return when(operator){
            '+' -> num1 + num2
            '-' -> num1 - num2
            '*' -> num1 * num2
            else -> num1 / num2
        }
    }

    private fun numCheck(num: String): Boolean{
        try {
            num.toFloat()
            return true
        } catch (e:Exception){
            println("Please enter numbers only")}
        return false
    }

    private fun start(){
        while (true){
            print("Enter first number: ")
            val number1 = readLine()
            if(numCheck(number1!!)){
                println(number1)
                print("Enter operator: ")
                val op = readLine()
                if(op=="+"||op=="-"||op=="*"||op=="/"){
                    println(number1+op)
                    print("Enter second number: ")
                    val number2 = readLine()
                    if(numCheck(number2!!)) {
                        if(number2.toFloat() == 0f && op == "/"){
                            println("You cannot divide by 0")
                        }else{
                            println("$number1 $op $number2 = ${calculate(number1.toFloat(), op[0], number2.toFloat())}")
                            break
                        }
                    }
                }else{
                    println("Invalid Operator")
                }
            }
        }
    }
}