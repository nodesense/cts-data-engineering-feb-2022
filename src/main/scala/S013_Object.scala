object S013_Object extends  App {

  // Object in scala known as singleton instances
  // singleton means only 1 object at any point of time
  // Main function for scala application, we can use object
  // Similar to Java/C++ Static

  // Logger is singleton and only instance
  object Logger {
    def info(msg: String) = println(" INFO " + msg)
    def error(msg: String) = println("ERROR " + msg)
  }

  Logger.info("Starting application")
  Logger.error("Could not connect to db")

  object Memory {
    var cache : String = ""
    def setCache(v: String) = cache = v
    def getCache() = cache
    var pow = (n: Int) => n * n
  }

  Memory.setCache("1 + 2 = 3")

  println (Memory.getCache())

  class Sample {
    Logger.info("Creating Sample object")
  }

  val s = new Sample()

  println(Memory.pow(10))


}
