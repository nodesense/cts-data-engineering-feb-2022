object S003_If extends  App {
  // java, c/c++/c# - if condition is statement, won't return result
  // Scala - if condition is a expression, ie it will return result
  // if the condition is true, "Even" is returned otherwise "Odd" will be returned
  val result: String = if ( 11 % 2 == 0 ) "Even" else "Odd"
  println(result)

  val result2: String = if (11 % 2 == 0) {
                            println("Even number")
                            "Even" // output value
                          } else {
                            println("Odd number")
                            "Odd" // output value
                          }

  println(result2)
}
