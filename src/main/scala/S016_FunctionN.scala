object S016_FunctionN extends  App {
  // FunctionN, where N represent number of parameters to Function
   // 0 - no argument
   // 1 - 1 argument to function
   //.. 22 - 22 arguments to functions
  // Scala Function , we used => , => that represent   function is known as Syntactic Sugar
  // Scala convert all => functions into FunctionN while compiling, scala will create a apply method
  // for the functions

  // takes 1 parameter Int, return 1 result Int
  // Function1
  val pow:Function1[Int, Int] = (n: Int) => n * n

  println ( pow(5) )  //25
  println ( pow.apply(5) ) // 25, calls same function
                          //[param type, return type]
  // From right, first element is Return type, rest are parameter types
  val power: Function1[Int, Int] = new Function1[Int, Int] {
    def apply(n: Int): Int = n * n
  }

  println ( power(5) ) // power.apply(5)
  println (power.apply(5))

  // add function that accept 2 paremeters a and b of Int, return Int
  val add: Function2[Int, Int, Int] = new Function2[Int, Int, Int] {
    def apply(a: Int, b: Int): Int = a + b
  }

  println ( add(10, 20) )
  println (add.apply(10, 20))

  val sub: Function2[Double, Float, Int] = new Function2[Double, Float, Int] {
    def apply(a: Double, b: Float): Int = (a - b).toInt
  }
  // f represent float
  println (sub(10.0, 5.0f))

 }
