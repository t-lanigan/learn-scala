
//Define a class Cat and then create an object for each cat in the table above.

//class Cat (val name: String, val food: String, val color: String)
//
//
//var oswald = new Cat(name="oswald", food="milk", color="black")
//var henderson = new Cat(name="hern", food="Chips", color="blagfck")
//var quentin = new Cat(name="ofe", food="migfdslk", color="blacerk")
//
////Define an object ChipShop with a method willServe. This method should accept a Cat
//// and return true if the cat’s favourite food is chips, and false otherwise.
//
//object ChipShop {
//  def willServe(cat: Cat): Boolean = {
//    if (cat.food == "Chips") true else false
//  }
//}
//
//ChipShop.willServe(henderson)

//Write two classes, Director and Film, with fields and methods as follows:
//
//  Director should contain:
//a field firstName of type String
//a field lastName of type String
//a field yearOfBirth of type Int
//a method called name that accepts no parameters and returns the full name
//Film should contain:
//  a field name of type String
//a field yearOfRelease of type Int
//a field imdbRating of type Double
//a field director of type Director
//a method directorsAge that returns the age of the director at the time of release
//a method isDirectedBy that accepts a Director as a parameter and returns a Boolean
//  Copy-and-paste the following demo data into your code and adjust your
//  constructors so that the code works without modification:

//class Director(val firstName: String,
//               val lastName: String,
//               val yearOfBirth: Int){
//  def name: String = {
//    firstName + " " + lastName
//  }
//
//  def copy(
//    firstName: String = this.firstName,
//    lastName: String = this.lastName,
//    yearOfBirth: Int = this.yearOfBirth): Director =
//    new Director(firstName, lastName, yearOfBirth)
//}
//
//class Film(val name: String,
//           val yearOfRelease: Int,
//           val imdbRating: Double,
//           val director: Director){
//  def directorsAge: Int = {
//    yearOfRelease - director.yearOfBirth
//  }
//  def isDirectedBy(d: Director): Boolean = {
//    if (d.firstName == director.firstName)
//      true
//    else
//      false
//  }
//
//  def copy(
//    name: String = this.name,
//    yearOfRelease: Int = this.yearOfRelease,
//    imdbRating: Double = this.imdbRating,
//    director: Director = this.director): Film =
//    new Film(name, yearOfRelease, imdbRating, director)
//}
//
//val eastwood          = new Director("Clint", "Eastwood", 1930)
//val mcTiernan         = new Director("John", "McTiernan", 1951)
//val nolan             = new Director("Christopher", "Nolan", 1970)
//val someBody          = new Director("Just", "Some Body", 1990)
//
//val memento           = new Film("Memento", 2000, 8.5, nolan)
//val darkKnight        = new Film("Dark Knight", 2008, 9.0, nolan)
//val inception         = new Film("Inception", 2010, 8.8, nolan)
//
//val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
//val outlawJoseyWales  = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
//val unforgiven        = new Film("Unforgiven", 1992, 8.3, eastwood)
//val granTorino        = new Film("Gran Torino", 2008, 8.2, eastwood)
//val invictus          = new Film("Invictus", 2009, 7.4, eastwood)
//
//val predator          = new Film("Predator", 1987, 7.9, mcTiernan)
//val dieHard           = new Film("Die Hard", 1988, 8.3, mcTiernan)
//val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
//val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)
//
//eastwood.yearOfBirth         // should be 1930
//dieHard.director.name        // should be "John McTiernan"
//invictus.isDirectedBy(nolan) // should be false


//class Adder(amount: Int) {
//  def add(in: Int): Int = in + amount
//  def apply(in: Int): Int = in + amount
//}
//class Counter(val count: Int) {
//  def dec: Counter = dec()
//  def inc: Counter = inc()
//  def dec(amount: Int = 1): Counter = new Counter(count - amount)
//  def inc(amount: Int = 1): Counter = new Counter(count + amount)
//  def adjust(adder: Adder) =
//    new Counter(adder.add(count))
//}
//
//
//
//val c = new Counter(10).inc.dec(10).count

//val add3 = new Adder(3)
//// add3: Adder = Adder@1d4f0fb4
//
//add3(2) // shorthand for add3.apply(2)
//add3.add(2)

class Timestamp(val seconds: Long)
object Timestamp {
  def apply(hours: Int, minutes: Int, seconds: Int): Timestamp =
    new Timestamp(hours*60*60 + minutes*60 + seconds)
}

Timestamp(1, 1, 1).seconds


//Implement a companion object for Person containing an apply method that accepts a
// whole name as a single string rather than individual first and last names.

//class Person(val firstName: String, val lastName: String)
//
//
//object Person {
//  def apply(name: String): Person = {
//    val parts = name.split(" ")
//    new Person(parts(0), parts(1))
//  }
//}
//
//val t = Person("Tyler Lanigan")
//t.firstName
//t.lastName


case class Director(
  firstName: String,
  lastName: String,
  yearOfBirth: Int) {

  def name: String =
    s"$firstName $lastName"

}

object Director {

  def older(director1: Director, director2: Director): Director =
    if (director1.yearOfBirth < director2.yearOfBirth) director1 else director2
}

case class Film(
  name: String,
  yearOfRelease: Int,
  imdbRating: Double,
  director: Director) {

  def directorsAge : Int = director.yearOfBirth - yearOfRelease

  def isDirectedBy(director: Director): Boolean = this.director == director}
object Film {

  def newer(film1: Film, film2: Film): Film =
    if (film1.yearOfRelease < film2.yearOfRelease) film1 else film2

  def highestRating(film1: Film, film2: Film): Double = {
    val rating1 = film1.imdbRating
    val rating2 = film2.imdbRating
    if (rating1 > rating2) rating1 else rating2
  }

  def oldestDirectorAtTheTime(film1: Film, film2: Film): Director =
    if (film1.directorsAge > film2.directorsAge) film1.director else film2.director
}

val eastwood          = new Director("Clint", "Eastwood", 1930)
val mcTiernan         = new Director("John", "McTiernan", 1951)
val nolan             = new Director("Christopher", "Nolan", 1970)
val someBody          = new Director("Just", "Some Body", 1990)

val memento           = new Film("Memento", 2000, 8.5, nolan)
val darkKnight        = new Film("Dark Knight", 2008, 9.0, nolan)
val inception         = new Film("Inception", 2010, 8.8, nolan)

val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
val outlawJoseyWales  = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
val unforgiven        = new Film("Unforgiven", 1992, 8.3, eastwood)
val granTorino        = new Film("Gran Torino", 2008, 8.2, eastwood)
val invictus          = new Film("Invictus", 2009, 7.4, eastwood)

val predator          = new Film("Predator", 1987, 7.9, mcTiernan)
val dieHard           = new Film("Die Hard", 1988, 8.3, mcTiernan)
val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

eastwood.yearOfBirth         // should be 1930
dieHard.director.name        // should be "John McTiernan"
invictus.isDirectedBy(nolan) // should be false

// What we get in a case class:
// 1. A field for each constructor argument—we don’t even need to write val
//    in our constructor definition, although there’s no harm in doing so.


//A default toString method that prints a sensible constructor-like representation of the class
// (no more @ signs and cryptic hex numbers):


//A copy method that creates a new object with the same field values as the current one:

// Sensible equals, and hashCode methods that operate on the field values in the object.

//The copy method actually accepts optional parameters matching each of the constructor parameters.
// If a parameter is specified the new object uses that value instead of the existing value from the
// current object. This is ideal for use with keyword parameters to let us copy an object while changing
// the values of one or more fields:

//The companion object contains an apply method with the same arguments as the class constructor.
// Scala programmers tend to prefer the apply method over the constructor for the brevity of omitting new,
// which makes constructors much easier to read inside expressions:

// Finally, the companion object also contains code to implement an extractor pattern for use in
// pattern matching. We’ll see this later this chapter.



val t =  new Person("tyler", "lanigan") // or val t =  Person("tyler", "lanigan")

//In this exercise we’re going to write a simulator of my Dad, the movie critic.
// It’s quite simple: any movie directed by Clint Eastwood gets a rating 10.0,
// any movie directed by John McTiernan gets a 7.0, while any other movie gets a 3.0.
// Implement an object called Dad with a method rate which accepts a Film and returns a
// Double. Use pattern matching.


// Case class for cat

case class Cat2(color: String, food: String)

val h = Cat2("black", "pizza")
val h2 = h.copy(color = "white")
h2.food
h2.color
 // Case class for counter

case class Counter(value: Int) {
  def inc(n: Int): Counter = copy(value+n)
  def dec(n: Int): Counter = copy(value-n)
  def inc: Counter = copy(value+1)
  def dec: Counter = copy(value-1)
}

val c = Counter(0)
c.inc.dec.inc(10).dec(5)
Counter(1).inc.dec == Counter(1).dec.inc


case class Person(firstName: String, lastName: String) {
  def name: String = firstName + " " + lastName
}

object Person {
  def apply(name: String): Person = {
    val parts = name.split(" ")
    apply(parts(0), parts(1))
  }
}


object Stormtrooper {
  def inspect(person: Person): String =
    person match {
      case Person("Luke", "Skywalker") => "Stop, rebel scum!"
      case Person("Han", "Solo") => "Stop, rebel scum!"
      case Person(first, last) => s"Move along, $first"
    }
}

Stormtrooper.inspect(Person("Noel Welsh"))


//Define an object ChipShop with a method willServe. This method should accept a Cat and return true if
// the cat’s favourite food is chips, and false otherwise. Use pattern matching.

object ChipShop {
  def willServe(cat: Cat2): Boolean = {
    cat match{
      case Cat2(_,"chips") => true
      case Cat2(color, food) => false
    }
  }
}

val y = Cat2("white", "chipfds")
ChipShop.willServe(y)

//In this exercise we’re going to write a simulator of my Dad, the movie critic. It’s quite simple:
// any movie directed by Clint Eastwood gets a rating 10.0, any movie directed by John McTiernan gets a 7.0,
// while any other movie gets a 3.0. Implement an object called Dad with a method rate which accepts a Film
// and returns a Double. Use pattern matching.


object Dad {
  def rate(film: Film): Double =
    film match {
      case Film(_, _, _, Director("Clint", "Eastwood", _)) => 10.0
      case Film(_, _, _, Director("John", "McTiernan", _)) => 7.0
      case _ => 3.0
    }
}

Dad.rate(highPlainsDrifter)
Dad.rate(predator)


