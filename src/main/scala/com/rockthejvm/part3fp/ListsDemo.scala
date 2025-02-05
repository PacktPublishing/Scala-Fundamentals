package com.rockthejvm.part3fp

object ListsDemo {

  // singly linked list
  val aList: List[Int] = List.apply(1,2,3)
  // first element (head), rest of the list (tail)
  val firstElement: Int = aList.head
  val rest = aList.tail
  // add (prepend) an element to a list
  val biggerList = 0 :: aList // [0,1,2,3] - returns a new list
  // add (append) an element at the end of the list
  val biggerList_v2 = aList :+ 4 // [1,2,3,4]

  // utility methods
  val scalax5 = List.fill(5)("Scala") // ["Scala","Scala","Scala","Scala","Scala"]
  // reverse a list
  val reversedList = aList.reverse // new list [3,2,1]
  // concatenate with another list
  val concatenation = aList ++ List(4,5,6) // new list [1,2,3,4,5,6]
  // format the collection
  val stringRep = aList.mkString("|") // "1|2|3"
  val stringRep_v2 = aList.mkString("[", ",", "]") // "[1,2,3]"
  // combine all elements in a list
  val total = aList.reduce(_ + _)

  // map - transforms a list by applying a function on every element
  val tenxList = aList.map(x => x * 10) // [10,20,30]
  val scalaList = aList.map(x => s"Scala $x") // ["Scala 1", "Scala 2", "Scala 3"]

  // filter - transforms a list by just keeping the items satisfying a boolean function
  val evenNumbers = aList.filter(x => x % 2 == 0) // [2] - a new list, the old one is intact

  // higher-order functions = take other functions as arguments/return functions as results
  // flatMap - transforms a list by applying the function to every element + combining the mini-lists obtained into one big list
  val expandedList = aList.flatMap(x => List(x, x + 1))

  /**
   * Exercises
   * 1. Take a list of numbers, return a list of "scala" repeated that many times
   *  e.g. [1,2,3] -> ["scala", "scalascala", "scalascalascala"]
   * 2. Generate the first n numbers, in a list, with a recursive function.
   * 3. From that list, return just the prime numbers.
   * 4. Take a list of numbers, return a list of all the digits of those numbers
   *  e.g. [13, 24, 987] -> [1,3,2,4,9,8,7]
   */
  // auxiliary functions
  def concatenateN(string: String, n: Int): String =
    if (n <= 0) ""
    else string + concatenateN(string, n - 1)

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

  def digits(n: Int): List[Int] = {
    // 123 => [3,2,1]
    def getDigits(number: Int): List[Int] =
      if (number <= 0) List()
      else {
        val lastDigit = number % 10
        val quotient = number / 10
        lastDigit :: getDigits(quotient)
      }

    if (n < 0) List()
    else if (n == 0) List(0)
    else getDigits(n).reverse // [1,2,3]
  }

  // 1
  def repeatScala(numbers: List[Int]): List[String] =
    numbers.map(n => concatenateN("Scala", n))

  // 2
  // generate(5) => [1,2,3,4,5]
  def generateN(n: Int): List[Int] =
    if (n <= 0) List()
    else generateN(n - 1) :+ n

  // 3
  def primesN(n: Int): List[Int] =
    generateN(n).filter(x => isPrime(x))

  // 4
  // [12, 987] => [[1,2], [9,8,7]] -> [1,2,9,8,7]
  def listOfDigits(numbers: List[Int]): List[Int] =
    numbers.flatMap(n => digits(n))

  // example
  val numbers = List(1,2,3,4)
  val colors = List("black", "white", "blue")
  // ["1-black", "1-white", "1-blue", "2-black", "2-white" ....]
  val combinations = numbers.flatMap(n => colors.map(c => s"$n-$c"))
  // for comprehensions
  val combinations_v2 = for {
    n <- numbers // <-- generator
    c <- colors
  } yield s"$n-$c" // exactly the same as the above

  // for comprehensions are not loops, they are expressions!

  /**
   * Exercise - generate a "checkerboard" from the numbers 1 to 8 and the letters A-H
   * [A1, A2, A3, ... A8, B1, B2, ... B8, ... H8]
   */

  val chessboard = for {
    letter <- ('A' to 'H').toList
    number <- (1 to 8).toList
  } yield s"$letter$number"

  def main(args: Array[String]): Unit = {
    println(aList)
    println(biggerList)
    println(biggerList_v2)
    println(stringRep)
    println(stringRep_v2)
    println(total)
    println(tenxList)
    println(scalaList)
    println(expandedList)
    // exercises
    println(repeatScala(List(1,2,5)))
    println(generateN(100))
    println(primesN(100))
    println(listOfDigits(List(12, 987)))
    // for comprehensions
    println(combinations)
    println(chessboard)
  }
}
