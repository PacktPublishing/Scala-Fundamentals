package com.rockthejvm.part2oop

object AbstractDataTypes {

  // Abstract classes
  abstract class VideoGame {
    // fields or methods without impl = abstract
    val gameType: String
    def play(): Unit

    // can provide "normal" fields or methods
    def runningPlatform: String = "PS5"
  }

  // cannot be instantiated
  //  val videoGame: VideoGame = new VideoGame // - cannot instantiate VideoGame on its own

  // derived classes must be either A) abstract or B) with an impl for gameType
  class Shooter extends VideoGame {
    override val gameType = "FPS"
    override def play(): Unit = println("fire!")
  }

  // Traits
  trait ThirdPerson {
    def showPerspective(game: VideoGame): Unit
  }

  // traits can extend other traits
  trait OpenWorld extends ThirdPerson {
    override def showPerspective(game: VideoGame): Unit =
      println("I see myself from the back and also see an open world.")
  }

  // abstract classes vs traits
  // a class can extend ONE class, but multiple traits

  trait Storyline {
    def mainCharacter: String
  }

  class MassEffect extends VideoGame with OpenWorld with Storyline {
    // gameType, play, mainCharacter
    override val gameType = "open-world story"
    override def play(): Unit = println("saving the galaxy")
    override def mainCharacter = "commander Shepard"
  }


  def main(args: Array[String]): Unit = {
    val cs = new Shooter
    println(cs.runningPlatform)
  }
}
