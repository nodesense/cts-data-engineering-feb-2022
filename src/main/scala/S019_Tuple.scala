object S019_Tuple extends  App {
  // tuple is immutable collection will be defined using (
  // tuple has members starting from _1, ..
  // members are checked at compile time, strongly typed
  val stock = ("INFY", 1600.0, 1580.3, 1620.5, 1000000)


  println(stock._1) // INFY
  println(stock._4) // 1620.5
  println(stock._5) // 1000000

  val pair = ("IN", "India") // Tuple 2, _1, _2
  println(pair._1, pair._2)

  // Tuple , works only for 2 element pair
  // generally used for key/value pair in map/dictionary
  val pair2 = "IN" -> "India"
  println(pair2._1, pair2._2)

}
