import RestaurantFeatures.restaurantFeatures

object Main {
  def topNRestaurantsByRating(n: Int): List[Int] = {
    if (n < 0) throw new IllegalArgumentException("Not possible")
    if (n == 0) println("No record needed")

    val ans = restaurantFeatures.map(key => (key._1, key._2.rating)).toList.sortBy(target => -target._2)

    if (ans.size < n) throw new IllegalArgumentException("Not sufficient records present")
    else ans.map(key => key._1).slice(0, n)
  }

  def topNRestaurantsByLocationAndType(n: Int, location: String, restaurantType: List[String]): List[Int] = {
    if (n < 0) throw new IllegalArgumentException("Not possible")
    if (n == 0) println("No record needed")

    val filter = restaurantFeatures.filter(key => key._2.location == location && key._2.restaurantType == restaurantType)
    if (filter.size <= 0) throw new IllegalArgumentException("No restaurants satisfy the given condition")

    val ans = filter.map(key => (key._1, key._2.rating)).toList.sortBy(target => -target._2)
    if (ans.size < n) throw new IllegalArgumentException("Not sufficient records present")
    else ans.map(key => key._1).slice(0, n)
  }

  def topNRestaurantsByVotesAndLocation(n: Int, location: String): List[Int] = {
    if (n < 0) throw new IllegalArgumentException("Not possible")
    if (n == 0) println("No record needed")

    val filter = restaurantFeatures.filter(key => key._2.location == location && key._2.numberOfVotes != 0)
    if (filter.size <= 0) throw new IllegalArgumentException("No restaurants satisfy the given condition")

    val ans = filter.map(key => (key._2.numberOfVotes, key._2.rating, key._1)).toList.sortBy(target => (target._1, -target._2))
    if (ans.size < n) throw new IllegalArgumentException("Not sufficient records present")
    else ans.map(key => key._3).slice(0, n)
  }

  def noOfDishesLiked(): Map[Int, Int] = {
    restaurantFeatures.map(key => key._1 -> key._2.dishesLiked.length)
  }

  def noOfDistinctLocation(): Int = {
    restaurantFeatures.map(key => key._2.location).toList.distinct.length
  }

  def noOfDistinctCuisinesAtLocation(location: String): Int = {
    restaurantFeatures.filter(key => key._2.location == location).map(key => key._2.typesOfCuisines).toList.distinct.length
  }

  def noOfDistinctCuisines(): Map[String, Int] = {
    restaurantFeatures.map(key => key._2.location -> key._2.typesOfCuisines.distinct.length)
  }

}
