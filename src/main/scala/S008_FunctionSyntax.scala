object S008_FunctionSyntax extends  App {

  // syntax for function declartion
  // name is identifier, : delimiter for type, String is type
  val name: String = "Venkat"
  // function syntax for a function that takes 0 parameter, return no output
  // greeing is a function
  // () => Unit is a Function type, that takes 0 parameter, return no output
  // () => println("Good Afternoon") function implementation
  val greeting: () => Unit = () => println("Good Afternoon")

  greeting()

  // a function that takes 1 parameter, return no result
  val greet: (String) => Unit = (name) => println("Good Afternoon", name)

  greet("Venkat")

  // a function takes 1 parameter, return 1 result
  val pow: Int => Int = n => n * n

  // a function takes 2 parameter, return 1 result
  // for more than 1 parameter, ( is mandatory
  val add: (Int, Int) => Int = (a, b) => a + b

  val add2: Function2[Int, Int, Int]   = (a, b) => a + b

  println (pow(5) )
  println( add(10, 20))
}
