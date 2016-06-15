package week2

import scala.annotation.tailrec

object lecture2_2 {
  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1 else f(a) * product(f)(a + 1, b)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int

	product(x=>x*x)(1, 3)                     //> res0: Int = 36
	
	def fact(n:Int) :Int = product(x => x)(1, n)
                                                  //> fact: (n: Int)Int
  
  fact(6)                                         //> res1: Int = 720
  
  def apply(f: Int => Int, g: (Int, Int) => Int, base : Int)(a: Int, b: Int) : Int = {
  	if (a > b) base else g(f(a), apply(f, g, base)(a+1, b))
  }                                               //> apply: (f: Int => Int, g: (Int, Int) => Int, base: Int)(a: Int, b: Int)Int

	apply(x=>x, (a,b)=>a+b, 0)(1, 10)         //> res2: Int = 55
}

	