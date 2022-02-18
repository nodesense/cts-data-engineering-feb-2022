object S018_List extends  App {
   // List is immutable collection class
  // List of string
  val names = List("Scala", "Python", "Spark", "Kafka", "AWS", "Hive")
  val prices = List(10.3,10.5,10.7, 10.9)

  println(names)
  for (name <- names) println(name)
  println("---")
  names.foreach(println)

  // higher order function using map
  // map is higher order function
  val namesUpper = names.map(name => name.toUpperCase())
  println("-----")
  namesUpper.foreach(println)


}
