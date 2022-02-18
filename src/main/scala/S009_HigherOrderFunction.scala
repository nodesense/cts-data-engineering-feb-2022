object S009_HigherOrderFunction extends  App {
  // A function that accept another function as parameter known as higher order function

  // type inference
  val square = (n: Int) => n * n
  // type declaration explicitly
  val cube: Int => Int = n => n * n * n

  // higher order function, that accept function as parameter
  // inference
  // sum functions  takes two parameter, return 1 ouput
  // first parameter f is function, that accept Int as parameter, return Int
  // n is int
  // calling f(x) means we call square or cube that passed as argument
  val highOrderFunction = ( f:Int => Int, n :Int) => f(n)

  println ( highOrderFunction(square, 5) )
  println ( highOrderFunction(cube, 5) )

  // n shall be 3
  println (highOrderFunction ( n => n * n , 3) )

  // sum of sq/cube/sqrt/anything of numbers

  val sum: (Double => Double, Double*) => Double = ( f, numbers) => {
     var s: Double = 0.0
    // for each numbers
     for ( n <- numbers) {
       s += f(n)
     }

    s // return value, last evaluated expression value returned by scala
  }

  // FIXME
  // val s: Function2[Function1[Int, Int], Seq[Double], Double] = sum;

  // IntellijSense from IntelliJ Authors
  // 1 ^2 + 2 ^ 2 = 5
  val result1 = sum ( n => n * n, 1.0, 2.0)
  println(result1)

  println (sum (n => Math.tan(n), 4.0, 6.0, 8.0))
  println (sum (n => Math.log(n), 4.0, 6.0, 8.0))

}
