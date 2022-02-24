object S011_ForLoop extends App {
    val r1 =  1 to 10
    println(r1.toList)
    val r2 = 1 until 10
    println(r2.toList)

    // sinle line for loop
    for (i <- 1 to 5) println (i)

    // multiline forloop {}
    for ( i <- 11 to 15) {
        // multiline for loop
        println(i)
    }

    // using curly brace ,, single line
    for { i <- 21 to 25 } println (i)

    // multi line
    for {  i <- 26 to 30 } {
        println(i)
    }

    // for loop with if condition , guard
    // print only odd numbers
    for { i <- 31 to 40 if i % 2 == 1} println(i)

    // nested for loop
    // for loop inside another for loop
    for {
            i <- Seq("a", "b", "c")
            j <- 1 to 3
        } println ( i, j)
}

// DIY - while loop, do ... while..