package chapter4

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