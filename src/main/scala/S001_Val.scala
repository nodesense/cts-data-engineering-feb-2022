// comment single line

/*
 comment multiline
 line 2
*/

// App is trait, it has main function
object S001_Val extends App {
  // semi colon is optional
  // To run the app, Right Click, Select Run S001_Val
  println("Hello Scala")

  // Value/Immutable/unchangable/const
  val name: String = "Scala"
  //  name = "Spark" // error, it won't compile, we cannot change name value
  println(name)

  // Type inference
  // no need to mention the type while defining var/val
  // compiler will take from expression on right side
  // compiler assume framework is a string type - this is called inference
  val framework = "Spark"
  // k shall be Int
  val k = 10

  println(framework)
  println(k)
  println(framework.toUpperCase())
}
