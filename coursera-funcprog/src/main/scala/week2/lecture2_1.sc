package week2

import scala.annotation.tailrec

object lecture2_1 {
  def sum(f: Int => Int, a: Int, b: Int) = {
    @tailrec
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    }
    loop(a, 0);
  }                                               //> sum: (f: Int => Int, a: Int, b: Int)Int
}

	