package com.rockthejvm.part3fp

object CollectionsDemo {

  // ranges
  val first10Numbers = 1 to 10
  // repeat an action
  // convert to a collection
  val f10numbers = first10Numbers.toList

  // arrays - native arrays (JVM - stored natively on the OS)
  val anArray = Array.ofDim[Int](1000) // represented as int[]
  // mutable
  anArray.update(31, 42) // sets the value at index 31 to the value 42
  val fifthNumber = anArray(4) // anArray[4]

  // sets - collections with no duplicates (decided with the equals method), but it guarantees no order
  val aSet = Set(1,2,3,4,2,3,1,5) // [1,2,3,4,5]
  // test if an item is in the set or not
  val aSetContains3 = aSet.contains(3) // true
  val aSetContains3_v2 = aSet(3) // true
  // add or remove items from the set - return a new set
  val aBiggerSet = aSet + 99 // [1,2,3,4,5,99]
  val aSmallerSet = aSet - 4 // [1,2,3,5]
  // concatenation == union
  val anotherSet = Set(4,5,6,7,8,9)
  val muchBiggerSet = aSet.union(anotherSet) // [1,2,3,4,5,6,7,8,9]
  val muchBiggerSet_v2 = aSet ++ anotherSet // same
  val muchBiggerSet_v3 = aSet | anotherSet // same
  // difference
  val diffSet = aSet.diff(anotherSet) // [1,2,3]
  val diffSet_v2 = aSet -- anotherSet // same
  // intersection
  val intersection = aSet.intersect(anotherSet) // [4,5]
  val intersection_v2 = aSet & anotherSet // same

  // all of them have map, flatMap and filter => for comprehensions!
  val combinations = for {
    x <- Set(1,2,3,4,5,6)
    y <- Set(1,2,3,4,5,6)
  } yield x * y

  // combinations = { x * y | x in {1,2,3,4,5,6}, y in {1,2,3,4,5,6] }

  def main(args: Array[String]): Unit = {
    println(combinations)
  }
}
