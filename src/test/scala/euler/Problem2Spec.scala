package euler

import org.scalatest.{FlatSpec, Matchers}

class Problem2Spec extends FlatSpec with Matchers{

  "A Problem 2 Solution" should "be correct in (4000000) should be (4613732)" in {
    Problem2.sum_even_fibs_less_than_n(4000000) should be (4613732)
  }

}
