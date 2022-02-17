object S004_BlockExpression extends App {
  // single line expression , compute and return result
  val result = 10 + 20 + 30
  println(result)
  // block - set of lines , multiple lines, using {}
  // block also an expression in scala, it returns computed value
  val result2 = {
    10 + 20 + 30 // compute the expression and return computed value that shall be assigned to result2
  }
  println(result2) // 60

  val result3: Int = {
    println("computing inside block")
    val output = 10 + 30 + 50
    println("output is ", output)
    output // output is returned, assigned to result 3
  }

  println(result3)

  val result4 = {
    // last evaluated expression output is returned from block
     println("hello") // return Unit
  }

  println(result4) // ()
}
