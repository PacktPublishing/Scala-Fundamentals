package com.rockthejvm.part1basics

object Functions {

  // function = mini-program/reusable piece of code that you can parameterize
  def aFunction(a: String, b: Int): String =
    // always a single instruction
    a + " " + b

  // invocation
  val anInvocation = aFunction("Scala", 999) // "Scala 999"

  // functions returning Unit
  // Unit == "void" in other languages e.g. Java, C, C++
  def aVoidFunction(aString: String): Unit =
    println(aString)

  // can do a lot inside the impl of a function
  def functionWithSideEffects(aString: String): String = {
    println(aString) // side effects
    aString + " " + aString // last expression gets "returned"
  }

  // can define smaller functions inside bigger ones
  def aBigFunction(n: Int): Int = {
    // can define smaller functions
    def aSmallerFunction(a: Int, b: Int) = a + b

    // can call smaller functions just inside this code block
    aSmallerFunction(n, n + 1)
  }


  def main(args: Array[String]): Unit = {

  }
}
