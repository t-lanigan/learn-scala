package euler

import scala.language.postfixOps

object Problem2 {
  val fibs: Stream[Int] = 0 #:: fibs.scanLeft(1)((b,a) => b + a)
  def sum_even_fibs_less_than_n(n: Int): Int = fibs.takeWhile(x => x < n).toList.filter(x => x % 2 == 0).sum
}
