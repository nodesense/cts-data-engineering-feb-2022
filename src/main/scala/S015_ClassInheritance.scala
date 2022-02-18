object S015_ClassInheritance extends  App {
  // Shape - Abstraction
      // some properties might be common
      // color
      // area - abstract
    // Square is a Shape - concrete class
    // Rectangle is a shape
    // Triangle is a shape
  // Animal - Abstraction
     // color, weight ....
    // Lion is an Animal
   // Cow is an Animal

  // Vechicle is an abstraction
  // Car is concrete class
  // abstract means we cannot create object
  // incomplete class, not suitable to create object
  abstract class Shape(val color: String) {
    // ??? - not implemented, throw exception
    def area(): Double = ???

    def getColor() = color
  }

  // c is color attribute
  // we are passing color c to parent class Shape
  // Inheritance, we derive class Square from Shape
  // Square is not abstract, since there is shape called square
  // Square is concrete class, suitable to create objects
  class Square (val side: Double, c: String  ) extends  Shape(c) {
    // area method override [erase parent method, bring its own area method]
    override def area(): Double = side * side

    def getSide() = side
  }

  // concrete class
  class Rectangle(val width: Double, val length: Double, c: String) extends  Shape(c) {
    override def area(): Double = width * length
    // when getWidth called, it returns width of rectangle
    def getWidth () = width

    def getLength ()  = length
  }

  // Circle: radius

  val s1 = new Square(4, "red")

  // getColor is from Shape which is parent class, we are reusing it
  println (s1.getColor()) // red
  println(s1.getSide()) // 4.0
  println(s1.area()) // 16.0

  val r1 = new Rectangle(6, 4, "green")

  println (r1.getColor()) // green
  println(r1.getWidth(), r1.getLength()) // 6.0, 4.0
  println(r1.area()) // 24.0
}
