package com.rockthejvm.part1basics

object StringOperations {

  // string
  val aString = "Scala Rocks" // 0-indexed
  // functions attached to them (methods)
  val length = aString.length
  val checkEmpty = aString.isEmpty
  val startsWithScala = aString.startsWith("Scala")
  val combine = aString + " very much!"
  val findIndex = aString.indexOf("Astronaut")

  // interpolation - inject values or expressions inside a string
  val name = "Alice"
  val age = 12
  val greeting = "Hi, my name is " + name + " and I am " + age + " years old."
  val greeting_v2 = s"Hi, my name is $name and I am $age years old." // s-interpolated string
  val greeting_v3 = s"Hi, my name is $name and I will be turning ${age + 1} years old."

  def main(args: Array[String]): Unit = {
    println(aString.length)
    println(findIndex)
    println(greeting_v3)
  }
}
