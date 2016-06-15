package week1

import scala.annotation.tailrec

object lecture1_5 {
  def abs(x: Double) = if (x < 0) -x else x

  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess else sqrtIter(improve(guess, x), x)

  def improve(guess: Double, x: Double) = (guess + x / guess) / 2

  def isGoodEnough(guess: Double, x: Double): Boolean = abs(guess * guess - x) / x < 0.001

  def sqrt(x: Double) = sqrtIter(1.0, x)
  
  sqrt(2)
  sqrt(1e-60)
  sqrt(1e60)
  
  @tailrec
  def factorial(x: Int) = {
  	def iterFactorial(y: Int, acc: Int): Int = {
  		if (y == 1) acc else iterFactorial(y - 1, acc * y)
  	}
  	iterFactorial(x, 1)
  }
}