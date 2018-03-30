
// Using case classes
case class Director(firstName: String, lastName: String, yearOfBirth: Int) {
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

  def directorsAge =
    yearOfRelease - director.yearOfBirth

  def isDirectedBy(director: Director) =
    this.director == director
}

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


// Pattern matching
object ChipShop {
  def willServe(cat: Cat): Boolean =
    cat match {
      case Cat(_, "Chips") => true
      case Cat(_, _) => false
    }
}

val eastwood = Director("clint", "eastwood", 1700)

val eastwood2 = eastwood.copy()