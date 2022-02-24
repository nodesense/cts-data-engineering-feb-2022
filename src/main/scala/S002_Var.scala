object S002_Var extends App {
  // variable - value can be changed
  var k : Int = 10
  println(k)
  k = 20
  println(k)

  k += 1
  println(k)
  k = k + 1
  println(k)


 // type inference
 // name is string
 var name = "Scala"
 println(name)
  // name = 100 // compilation error
 println(name.getClass())
}
