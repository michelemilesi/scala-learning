package recfun

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else {
      pascal(c - 1, r - 1) + pascal(c, r - 1)
    }
  }

  /**
   * Exercise 2
   */

  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def iterBalance(level: Int, chars: List[Char]): Int = {
      if (level < 0 || chars.isEmpty) level
      else (chars.head) match {
        case '(' => iterBalance(level + 1, chars.tail)
        case ')' => iterBalance(level - 1, chars.tail)
        case _ => iterBalance(level, chars.tail)
      }
    }
    iterBalance(0, chars) == 0
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def loopCoins(money: Int, coins: List[Int]): Int = {
      if (coins.isEmpty || money < 0) 0
      else if (money == 0) 1
      else loopCoins(money, coins.tail) + loopCoins(money - coins.head, coins)
    }
    loopCoins(money, coins)
  }
}
