import java.util.*

class UsernameAndPassword {
    private var users: Array<String> = arrayOf("Sam", "Frank", "Jane")
    private val specialCharacters: Array<Char> = arrayOf('!', '@', '#', '$')
    private var nameCheck = false

    private var username = ""
    private var password = ""

    init {
        println("Starting Username and Password")

        fun nameAvailable(name: String): Boolean{
            if(name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() } in users){
                return false
            }
            return true
        }

        fun numberFound(name: String): Boolean{
            for(i in name){
                if(i.isDigit()){return true}
            }
            return false
        }

        fun capsFound(pw: String): Boolean{
            for(letter in pw){
                if(letter.isUpperCase()){return true}
            }
            return false
        }

        fun specialFound(pw: String): Boolean{
            for(c in pw){
                if(c in specialCharacters){return true}
            }
            return false
        }

        while(true){
            if(!nameCheck){
                print("Enter your username: ")
                username = readLine() ?: "username"
                if(nameAvailable(username)){
                    if(!numberFound(username)){
                        if(username.length in 3..14){
                            nameCheck = true
                            users += username
                            println("Username created")
                        }else{
                            println("Username must be between 3 and 14 characters long")
                        }
                    }else{
                        println("Username cannot contain numbers")
                    }
                }else{
                    println("Please choose another username")
                }
            }else{
                print("Enter your password: ")
                password = readLine() ?: "password"
                if(capsFound(password)){
                    if(specialFound(password)){
                        if(numberFound(password)){
                            if(password.length > 7){
                                println("Your username is $username and your password is $password")
                                println("Press 'Enter' to continue")
                                readLine()
                                break
                            }else{
                                println("Password must be at least 8 characters long")
                            }
                        }else{
                            println("Password must contain a number")
                        }
                    }else{
                        println("Password must contain a special character ('!', '@', '#', '$')")
                    }
                }else{
                    println("Password must contain a capital letter")
                }
            }
        }
    }
}