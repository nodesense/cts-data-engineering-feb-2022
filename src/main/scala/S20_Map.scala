object S20_Map extends  App {
  // Maps are simialar python dict key, value map
  // immutable map, compose map using key/value pair tuple
  val countryCode =   Map[String, String] (
                          "IN" -> "India",
                          "USA" -> "United States of America",
                          ("CA", "Canada")
                          )
   // accessing map element
   println (    countryCode("USA") ) // United States of America
   println( countryCode.contains("CA") ) // true

  println( countryCode.keys)
}
