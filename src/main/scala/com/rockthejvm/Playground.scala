package com.rockthejvm

object Playground {

  class Animal
  class Cat extends Animal

  trait AnimalShow[+T] {
    def show: String
  }

  implicit val GeneralAnimalShow: AnimalShow[Animal] = new AnimalShow[Animal] {
    override def show = "animals everywhere"
  }

  implicit val CatsShow: AnimalShow[Cat] = new AnimalShow[Cat] {
    override def show = "so many cats!"
  }

  def organizeShow[T](implicit event: AnimalShow[T]): String = event.show
  // rule 2: covariant TCs will always use the more specific TC instance for that type
  // but may confuse the compiler if the general TC is also present

  // rule 3: you can't have both benefits
  // Cats uses INVARIANT TCs

  def main(args: Array[String]): Unit = {
    println(organizeShow[Cat]) // ok - the compiler will inject CatsShow as implicit
     println(organizeShow[Animal]) // will not compile - ambiguous values
  }

  //  def main(args: Array[String]): Unit = {
//    println("Rock the JVM!")
//  }
}
