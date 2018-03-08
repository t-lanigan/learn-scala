package chapter4

import org.scalatest.FunSuite

class CalculatorTest extends FunSuite {

  test("Calculator") {
    assert(Calculator.+(Success(3), 1) == Success(4))
    assert(Calculator.-(Success(1), 1) == Success(0))
    assert(Calculator.+(Failure("Badness"), 1) == Failure("Badness"))

    assert(Calculator./(Success(4), 2) == Success(2))
    assert(Calculator./(Success(4), 0) == Failure("Division by zero"))
    assert(Calculator./(Failure("Badness"), 0) == Failure("Badness"))
  }
}
