//Using polymorphism and then using pattern matching implement a method called next which
// returns the next TrafficLight in the standard Red -> Green -> Yellow -> Red cycle.
// Do you think it is better to implement this method inside or outside the class?
// If inside, would you use pattern matching or polymorphism? Why?

// polymorphism abstract function in trait
//sealed trait TrafficLight {
//  def next: TrafficLight
//}
//case object Red extends TrafficLight {
//  def next: TrafficLight =
//    Green
//}
//case object Green extends TrafficLight {
//  def next: TrafficLight =
//    Yellow
//}
//case object Yellow extends TrafficLight {
//  def next: TrafficLight =
//    Red
//}


// Pattern matching function in subclass
sealed trait TrafficLight {
  def next: TrafficLight =
    this match {
      case Red => Green
      case Green => Yellow
      case Yellow => Red
    }
}
case object Red extends TrafficLight
case object Green extends TrafficLight
case object Yellow extends TrafficLight

Red.next


//We’re now going to write some methods that use a Calculation to perform a larger calculation.
// These methods will have a somewhat unusual shape—this is a precursor to things
// we’ll be exploring soon—but if you follow the patterns you will be fine.

//Create a Calculator object. On Calculator define methods + and -
// that accept a Calculation and an Int, and return a new Calculation.
// Here are some examples
sealed trait Calculation
final case class Success(result: Int) extends Calculation
final case class Failure(reason: String) extends Calculation

object Calculator {
  def +(calc: Calculation, operand: Int): Calculation =
    calc match {
      case Success(result) => Success(result + operand)
      case Failure(reason) => Failure(reason)
    }
  def -(calc: Calculation, operand: Int): Calculation =
    calc match {
      case Success(result) => Success(result - operand)
      case Failure(reason) => Failure(reason)
    }
  def /(calc: Calculation, operand: Int): Calculation =
    calc match {
      case Success(result) =>
        operand match {
          case 0 => Failure("Division by zero")
          case _ => Success(result / operand)
        }
      case Failure(reason) => Failure(reason)
    }
}


assert(Calculator.+(Success(3), 1) == Success(4))
assert(Calculator.-(Success(1), 1) == Success(0))
assert(Calculator.+(Failure("Badness"), 1) == Failure("Badness"))

assert(Calculator./(Success(4), 2) == Success(2))
assert(Calculator./(Success(4), 0) == Failure("Division by zero"))
assert(Calculator./(Failure("Badness"), 0) == Failure("Badness"))


//define a method length that returns the length of the list. There is test data below
// you can use to check your solution. For this exercise it is best to use pattern matching
// in the base trait

sealed trait IntList {
  def length: Int =
    this match {
      case End => 0
      case Pair(hd, tl) => 1 + tl.length
    }
  def product: Int =
    this match {
      case End => 1
      case Pair(hd, tl) => hd * tl.product
    }
  def double: IntList =
    this match {
      case End => End
      case Pair(hd, tl) => Pair(hd * 2, tl.double)
    }
}
case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList


val example = Pair(1, Pair(2, Pair(3, End)))

assert(example.length == 3)
assert(example.tail.length == 2)
assert(End.length == 0)

//Define a method to compute the product of the elements in an IntList. Test cases are below.
assert(example.product == 6)
assert(example.tail.product == 6)
assert(End.product == 1)

//Define a method to double the value of each element in an IntList, returning a new IntList.
// The following test cases should hold:

assert(example.double == Pair(2, Pair(4, Pair(6, End))))
assert(example.tail.double == Pair(4, Pair(6, End)))
assert(End.double == End)