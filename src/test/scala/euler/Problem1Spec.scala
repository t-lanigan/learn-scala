package euler

import org.scalatest.{FlatSpec, Matchers}


class Problem1Spec extends FlatSpec with Matchers {
  "A Problem1 Solution" should "be correct for the simple case" in {
    Problem1.mult35(10) should be (23)
  }

  it should "be correct for the advanced case" in {
    Problem1.mult35(1000) should be (233168)
  }
}
