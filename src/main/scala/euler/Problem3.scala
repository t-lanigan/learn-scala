package euler

import scala.annotation.tailrec

/**
    *The prime factors of 13195 are 5, 7, 13 and 29.
    *What is the largest prime factor of the number 600851475143 ?
  **/

object Problem3 {

  @tailrec
  def get_largest_prime_factor(n :Long, a :Long) :Long = {
    if (a % n == 0) get_largest_prime_factor(2, a/n)
    else if (n > math.sqrt(a)) a
    else get_largest_prime_factor(n+1, a)
  }


}