package com.rockthejvm.part3fp

object FPBasics {

  // apply
  case class Person(name: String, favMovie: String) {
    def apply(n: Int): String =
      s"$name watched $favMovie $n times"
  }

  val daniel = Person("Daniel", "Interstellar")
  val danielStatement = daniel.apply(4)
  val danielStatement_v2 = daniel(4) // same

  // we can create "function" types
  trait SimpleMathFunction {
    def apply(n: Int): Int
  }

  val doubler: SimpleMathFunction = new SimpleMathFunction {
    override def apply(n: Int) = n * 2
  }

  val six = doubler(3)

  trait MyFunction[A, B] {
    def apply(arg: A): B
  }

  val doubler_v2 = new MyFunction[Int, Int] {
    override def apply(arg: Int) = arg * 2
  }

  val six_v2 = doubler_v2(3)

  // in FP, we work with functions as "first class" elements of the language
  // we can pass functions as arg, we can return them as results
  // Int => Int can be expressed as a trait that has an apply(Int): Int
  // (String, Int) => String can be expressed as a trait that has an apply(String, Int): Int

  trait MyStringIntFunction {
    def apply(s: String, i: Int): String
  }

  val myCombinator = new MyStringIntFunction {
    override def apply(s: String, i: Int) =
      s"$s, ($i)"
  }

  // Scala already has Function traits
  val doubler_v3 = new Function1[Int, Int] {
    override def apply(arg: Int) = arg * 2
  }

  val myCombinator_v2 = new Function2[String, Int, String] {
    override def apply(s: String, i: Int) =
      s"$s, ($i)"
  }

  val superfunction = new Function4[Int, String, Double, Boolean, Int] {
    override def apply(v1: Int, v2: String, v3: Double, v4: Boolean) = v1 * 10
  }

  // all function values in Scala are instances of FunctionN traits with apply methods

  def main(args: Array[String]): Unit = {
    println(danielStatement)
    println(danielStatement_v2)
    println(six)
    println(six_v2)
    println(myCombinator("Scala", 99))
    println(myCombinator_v2("Scala", 99))
    println(superfunction(4, "Scala", 3.14, true))
  }
}
