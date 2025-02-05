package com.rockthejvm.part1basics

object Recursion {

  // sum(3) = 1 + 2 + 3 = 6
  // sum(10) = 1 + 2 + ... + 10 = 55
  // sum(10) = 10 + sum(9)
  // sum(9) = 9 + sum(8)
  // ...
  // sum(2) = 2 + sum(1) = 3
  // sum(1) = 1 + sum(0) = 1
  // sum(0) = 0

  def sum(n: Int): Int =
    if (n <= 0) 0
    else n + sum(n-1)

  // thinking in recursion
  def printN(string: String, n: Int): Unit =
    if (n <= 0) ()
    else {
      println(string)
      printN(string, n-1)
    }

  // more complex example
  // test all numbers from 2 to n / 2, test whether n % d == 0

  /*
    isPrime(7) =
      testDivisors(2) =
      testDivisors(3) =
      testDivisors(4) =
      true
  */
  def isPrime(n: Int): Boolean = {
    def testDivisors(d: Int): Boolean =
      if (d > n / 2) true
      else if (n % d == 0) false
      else testDivisors(d + 1)

    // last expression is the final thing
    if (n <= 0) false // don't support negative numbers
    else if (n == 1) false // 1 is not a prime (not a composed number)
    else testDivisors(2)
  }

  /**
   * Exercises
   * 1. concatenate a string a set number of times
   *    concatenateN("Scala", 3) = "ScalaScalaScala"
   * 2. Fibonacci numbers
   *    1, 2, 3, 5, 8, 13, 21, ...
   */

  def concatenateN(string: String, n: Int): String =
    if (n <= 0) ""
    else string + concatenateN(string, n - 1)

  def fibonacci(n: Int): Int =
    if (n <= 1) 1
    else if (n == 2) 2
    else fibonacci(n - 1) + fibonacci(n - 2)

  def main(args: Array[String]): Unit = {
    println(sum(10))
    printN("Scala is awesome", 20)
    println(concatenateN("Scala", 3)) // "ScalaScalaScala"
    println(fibonacci(6)) // 13
  }
}
