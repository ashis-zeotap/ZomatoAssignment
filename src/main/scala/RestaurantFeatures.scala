import Configure.configure

object RestaurantFeatures {
  val restaurantFeatures : Map[Int,RestaurantFeatures] = configure()

  case class RestaurantFeatures(
                               restaurantName: String,
                               rating: Double,
                               numberOfVotes: Int,
                               location: String,
                               restaurantType: List[String],
                               dishesLiked: List[String],
                               typesOfCuisines: List[String],
                               costForTwo: Double)
}
