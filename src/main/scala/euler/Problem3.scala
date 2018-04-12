package euler

import scala.annotation.tailrec
/**
    The prime factors of 13195 are 5, 7, 13 and 29.
    What is the largest prime factor of the number 600851475143 ?
  **/


object Problem3 {

  def get_largest_prime_factor(n: Int): Int = get_prime_factors(n).max

  @tailrec
  def get_prime_factors(x: Int, a: Int = 2, list: List[Int] = Nil): List[Int] = a*a > x match {
    case false if x % a == 0 => get_prime_factors(x / a, a    , a :: list)
    case false               => get_prime_factors(x    , a + 1, list)
    case true                => x :: list
  }
}