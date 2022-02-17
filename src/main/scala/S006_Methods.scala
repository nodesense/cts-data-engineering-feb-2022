object S006_Methods extends App {
  // reusable code , functions

  // a method, that doesn't take any parameter, doesnt' return output
  // : Unit => return type of method
  def greeting(): Unit = println("Good Morning")

  greeting()
  greeting()

  // a method that takes 1 parameter, doesn't return output
  def greet(msg: String): Unit = println("Good Morning ", msg)

  greet("Venkat")
  greet("Joe")

  // a method, that takes 1 parameter, return a result
  def pow(n : Int): Int = n * n

  println( pow(5) )

  // create a method called add , that takes a and b as int, return int, a + b as output
  def add(a: Int, b: Int): Int = a + b

  println( add(10, 20) ) // a = 10, b = 20

  // named/keyword argument

  println (   add(b = 100, a = 20)    ) // a = 20, b = 100

  // default values for parameters
  def sum(a : Int = 0, b: Int = 0) : Int = a + b

  println( sum () ) // a =0, b = 0
  println( sum (10) ) // a =10, b = 0
  println( sum (10, 20) ) // a =10, b = 20
  println( sum (b = 20) ) // a = 0, b = 20

  // variable number of arguments
  // * represent 0, 1 or more arguments
  // names.foreach(println) , print all the names
  def printNames(names:String*): Unit = names.foreach(println)

  printNames() // not passing any arguments
  printNames("Scala") // Scala shall be printed
  printNames("Scala", "Python") // "Scala", "Python" shall be printed
  printNames("Scala", "Python", "Spark", "Kafka") // "Scala", "Python", "Spark", "Kafka" shall be printed

  // multiline code using {} block
  // no need to use return keyword
  def sub(a : Int, b: Int) : Int = {
    println("A is", a, "B is ", b)
    // the last evaluatd expression result returned automatically
    a - b // return value
  }

  println ( sub( 20, 10 ) ) // 10
  println ( sub (10, 20) ) // -10

}
