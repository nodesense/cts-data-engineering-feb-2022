object S017_Options extends  App {
  // Scala - handling errors and exceptions

  // try to get a ticket
        // Some Ticket at hand
        // None - no ticket

  // Option is built in class
  // Represent a some value or None

  def toInt(s: String):Option[Int] = {
    // convert string to int and return int
    // handle exception
    try {
     Some( s.toInt ) // Some Int value  - Some ticket
    } catch {
      case _ => None // no ticket
    }
  }

  val n: Option[Int] = toInt("100") // 100 as output
  println(n)
  if (n.isDefined) {
    // n.get get the output value 100
    println("We got the result ", n.get)
  }

  val m: Option[Int] = toInt("INF+")
  println(m)

  if (m.isEmpty) {
    println("Sorry, m is empty")
  }

  println("-----")
  val v = Some(10)
  val x = None
  println(v)
  println(x)
  println("Done")

  // for loop, for comprehension can be used with option
  // if the option[int] is defined, then value shall be 200
  for { value <- toInt("200") }
    println("Value is ", value)

  // toInt return None, for comprehension will not print any value
  for { value:Int <- toInt("-Inf") }
    println("-Inf Value ", value) // won't execute

}
