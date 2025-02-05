package com.rockthejvm.part2oop

object Inheritance {

  class VideoGame {
    val gameType = "interactive"
    def play(): Unit = println("game running!")
  }

  // single-class inheritance
  class Shooter extends VideoGame {
    // can define my own fields/methods
    def multiplayer(): Unit = {
      play()
      println("boom, boom!")
    }
  }

  val crysis = new Shooter

  // inherit constructor
  class Person(val name: String, age: Int)
  class Adult(name: String, age: Int) extends Person(name, age) // MUST specify constructor arguments

  val daniel = new Adult("Daniel", 99)

  // overriding = provide a new impl for fields or methods in derived classes
  class RPG extends VideoGame {
    override val gameType = "role-playing"
    override def play(): Unit = println("level up!")
  }

  // subtype polymorphism
  val wow: VideoGame = new RPG // declare a value of a parent type, provide an instance of a derived type

  // anonymous classes
  val psychonauts = new VideoGame {
    override val gameType = "platformer"
  }

  /*
    class AnonClass$32784 extends VideoGame {
      override val gameType = "platformer"
    }

    val psychonauts: VideoGame = new AnonClass$32784
  */

  def main(args: Array[String]): Unit = {
    println(crysis.gameType)
    crysis.multiplayer()
    println(daniel.name)

    println(wow.gameType)
    wow.play()
  }
}
