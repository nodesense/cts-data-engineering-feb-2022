object S012_MatchCase extends  App {

  // c, c++, java, c#, .. switch, case , default , switch case is statement, it doesn't return output
  // scala doesn't support switch case instead we have match and case
  // match and case are expression, return output

  val result = (11 % 2 == 0) match {
    case true => "Even" // return value assigned to result
    case false => "Odd" // return value assigned to result
  }

  println(result)

  val result2 = (12 % 4) match {
    case 0 => "Zero"
    case 1 => "One"
    // 2 & 3 default
    case _ => "Unknown" // default case, if 0 or 1 is not matched
  }

  println(result2)

  // match case with if condition
  val price: Double =  50.0 // 100.0  90 70

  val discount = price match {
    case p: Double if p >= 100 => 10.0 // return value
    case p: Double if (p >= 80 && p < 100) => 5.0 // return value
    case p: Double if (p >= 60 && p < 80) => 2.0
    case _ => 0.0 // default case
  }

  println(discount)


  val r = (if (10 < 5) 1 else 0)
  val result3 = r  match {
    case 0 => "Zero"
    case 1 => "One"
    // 2 & 3 default
    case _ => "Unknown" // default case, if 0 or 1 is not matched
  }

  println(result2)

}
