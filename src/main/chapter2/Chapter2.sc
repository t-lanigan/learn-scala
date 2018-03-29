
object Oswald {
  val color: String = "black"
  val food: String = "milk"
}

object Henderson {
  val color: String = "ginger"
  val food: String = "chips"

}

Oswald.color

// Define an object called calc with a method square that accepts a Double as an argument
// and… you guessed it… squares its input. Add a method called cube that cubes its input
// calling square as part of its result calculation.


object calc {
  val name: String = "The Calculator"
  def square(n: Double) = {
    n*n
  }

  def cube(n: Double) = {
    n*n*n
  }
}

object calc2 {
  val name: String = "The Calculator"
  def square(n: Double) = n*n
  def cube (n: Double) = n*n*n
  def square(n: Int) = n*n
  def cube (n: Int) = n*n*n
}

calc2.name
calc2.square(2)
calc2.cube(3)
calc2.square(2.0)
calc2.cube(3.0)


//Define an object called person that contains fields called firstName and lastName.
// Define a second object called alien containing a method called greet that takes your
// person as a parameter and returns a greeting using their firstName.

object person  {
  val firstName: String = "Tyler"
  val lastName: String = "Lanigan"
}

object alien {
  def greet(p: person.type) =
    "Greetings, " + p.firstName + " " + p.lastName
}


alien.greet(person)

def square(in: Double): Double =
  in*in

square(2)

assert(square(2.0) == 4.0)
assert(square(3.0) == 9.0)
assert(square(-2.0) == 4.0)



