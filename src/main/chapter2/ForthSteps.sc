// Traits are super classes. When a class extends a trait, a function can be used on
// all classes that extend the trait.


import java.util.Date


//When we mark a trait as sealed we must define all of its subtypes in
// the same file. Once the trait is sealed, the compiler knows
// the complete set of subtypes and will warn us if a pattern
// matching expression is missing a case:

// Final disallows any more extensions.

sealed trait Visitor {
  def id: String
  def createdAt: Date
  def age: Long = new Date().getTime() - createdAt.getTime()
}

case class Anonymous(id: String, createdAt: Date = new Date()) extends Visitor

case class User(
  id: String,
  email: String,
  createdAt: Date = new Date()
) extends Visitor

def older(v1: Visitor, v2: Visitor): Boolean =
  v1.createdAt.before(v2.createdAt)

older(Anonymous("1"), User("2", "test@example.com"))



trait Feline {
  def colour: String
  def sound: String
}

trait BigCat extends Feline {
  val sound = "roar"
}

case class Lion(colour: String, maneSize: Int) extends BigCat
case class Tiger(colour: String) extends BigCat
case class Panther(colour: String) extends BigCat
case class Cat(colour: String, food: String) extends Feline {
  val sound = "meow"
}


// Shape uses Color so we define Color first:
sealed trait Color {
  // We decided to store RGB values as doubles between 0.0 and 1.0.
  //
  // It is always good practice to define abstract members as `defs`
  // so we can implement them with `defs`, `vals` or `vars`.
  def red: Double
  def green: Double
  def blue: Double

  // We decided to define a "light" colour as one with
  // an average RGB of more than 0.5:
  def isLight = (red + green + blue) / 3.0 > 0.5
  def isDark = !isLight
}

final case object Red extends Color {
  // Here we have implemented the RGB values as `vals`
  // because the values cannot change:
  val red = 1.0
  val green = 0.0
  val blue = 0.0
}

final case object Yellow extends Color {
  // Here we have implemented the RGB values as `vals`
  // because the values cannot change:
  val red = 1.0
  val green = 1.0
  val blue = 0.0
}

final case object Pink extends Color {
  // Here we have implemented the RGB values as `vals`
  // because the values cannot change:
  val red = 1.0
  val green = 0.0
  val blue = 1.0
}

// The arguments to the case class here generate `val` declarations
// that implement the RGB methods from `Color`:
final case class CustomColor(
  red: Double,
  green: Double,
  blue: Double) extends Color

// The code from the previous exercise comes across almost verbatim,
// except that we add a `color` field to `Shape` and its subtypes:
sealed trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double
  def color: Color
}

final case class Circle(radius: Double, color: Color) extends Shape {
  val sides = 1
  val perimeter = 2 * math.Pi * radius
  val area = math.Pi * radius * radius
}

sealed trait Rectangular extends Shape {
  def width: Double
  def height: Double
  val sides = 4
  val perimeter = 2 * width + 2 * height
  val area = width * height
}

final case class Square(size: Double, color: Color) extends Rectangular {
  val width = size
  val height = size
}

final case class Rectangle(
  width: Double,
  height: Double,
  color: Color) extends Rectangular

// We decided to overload the `Draw.apply` method for `Shape` and
// `Color` on the basis that we may want to reuse the `Color` code
// directly elsewhere:
object Draw {
  def apply(shape: Shape): String = shape match {
    case Circle(radius, color) =>
      s"A ${Draw(color)} circle of radius ${radius}cm"

    case Square(size, color) =>
      s"A ${Draw(color)} square of size ${size}cm"

    case Rectangle(width, height, color) =>
      s"A ${Draw(color)} rectangle of width ${width}cm and height ${height}cm"
  }

  def apply(color: Color): String = color match {
    // We deal with each of the predefined Colors with special cases:
    case Red    => "red"
    case Yellow => "yellow"
    case Pink   => "pink"
    case color  => if(color.isLight) "light" else "dark"
  }
}

// Test code:

Draw(Circle(10, Pink))
// returns "A pink circle of radius 10.0cm"

Draw(Rectangle(3, 4, CustomColor(0.4, 0.4, 0.6)))
// returns "A dark rectangle of width 3.0cm and height 4.0cm"

