package euler

import org.scalatest.{FlatSpec, Matchers}

class Problem3Spec extends FlatSpec with Matchers {

  "A Problem3 Solution" should "be correct for the simple case" in {
    Problem3.get_largest_prime_factor(10L, 2L) should be(5)
  }

  it should "be correct for the advanced case" in {
    Problem3.get_largest_prime_factor(13195L, 2L) should be(29)
  }


}