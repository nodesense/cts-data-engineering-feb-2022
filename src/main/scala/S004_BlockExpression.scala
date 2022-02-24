object S004_BlockExpression extends App {
  // single line expression , compute and return result
  val r = 20
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
  // what is value of t = 110
  val t = {
    10 + 20
    50 + 60 // last expression result = 110
  }

  val gr = {
     val a = 60
    val b = 40
    val c = 50

    // output of if statement is value a ie 60, that will be returned
    val result = if (a > b && a > c) {
      a
    } else if (b > c) b
    else {
     c
    }
    result
  }

  println(gr)

  val gr2 = {
    val a = 60
    val b = 40
    val c = 50

    // what is value of result? Unit
    val result = if (a > b && a > c) {
        println("A is greater") // return Unit
    } else if (b > c) println("B is greater")
    else {
      println("C is greater")
    }

    result // Unit
  }

  println(gr2) // what will be printing ()

}
