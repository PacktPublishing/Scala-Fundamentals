package com.rockthejvm.part2oop

object OOBasics {

  // classes and instances
  class Person(val name: String, age: Int) { // class definition also contains the definition of its CONSTRUCTOR
    // fields (val or var)
    val allCaps = name.toUpperCase()

    // methods = functions
    def greet(someone: String): String =
      s"$name says: Hi $someone"

    // can define multiple methods with the same name (overloading), if we have a different signature
    def greet(): String =
      s"Hi everyone, I'm $name"
  }

  val daniel = new Person("Daniel", 99) // daniel is an instance of Person (instantiation)
  val danielName = daniel.name // constructor arg is not (necessarily) a field

  /**
    *  Exercises: imagine we're doing an app for car registration
    *  Create a Car and a Driver class
    *
    *  Driver: first name, last name, year of birth
    *    - method full name
    *
    *  Car: make, model, year of release, owner
    *    - method ownerAge
    *    - method isOwnedBy(driver: Driver) - boolean if the driver is the same as the owner
    *    - copy (newYearOfRelease) - returns a new Car instance with the same data except the new year of release
    */
  class Driver(firstName: String, lastName: String, val yearOfBirth: Int) {
    def fullName: String =
      s"$firstName $lastName"
  }

  class Car(make: String, model: String, yearOfRelease: Int, owner: Driver) {
    def ownerAge(): Int =
      yearOfRelease - owner.yearOfBirth

    def isOwnedBy(driver: Driver): Boolean =
      driver == owner

    def copy(newYearOfRelease: Int): Car =
      new Car(make, model, newYearOfRelease, owner)
  }

  def main(args: Array[String]): Unit = {
    println(daniel.allCaps)
    println(daniel.greet("Alice"))
    println(daniel.greet())
    // test the exercise
    val driver = new Driver("Michael", "Schumacher", 1969)
    val driverImpostor = new Driver("Michael", "Schumacher", 1969)

    val car = new Car("Ferrari", "F1", 2004, driver)

    println(driver.fullName)
    println(car.ownerAge())
    println(car.isOwnedBy(driver)) // true
    println(car.isOwnedBy(driverImpostor)) // false
    println(car.copy(2005).ownerAge())
  }
}
