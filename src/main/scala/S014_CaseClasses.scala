object S014_CaseClasses extends  App {
  // case classes known as domain object
  // case class objects are immutable*
  // domain object, in inventory based application
  // Stock, Inventory, Product, Shelf, Order
  // case classes are useful to create object that represent a fact/event that occured
  // represent database data model
  // id, amount, name are member variables, of value type
  case class Order(  id: Int, amount: Double)
  case class Brand(id: Int, name: String)

  val order1 = new Order(1, 100)
  // new keyword is optional for case classes
  val order2 = Order(2, 200) // create new object,

  val b = Brand(1, "Apple")
  val b2 = Brand(1, "Samsung")

  println(order1)
  println(order2)

  println(b)
  println(b2)

  // access case class instance members
  println(b.name, b.id)

}
