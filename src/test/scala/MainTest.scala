import org.scalatest.FunSuite

class MainTest extends FunSuite {

  test("Illegal Argument Exception") {
    assertThrows[IllegalArgumentException](Main.topNRestaurantsByRating(-51))
  }

  test("Number of dishes liked with id 10") {
    assert(Main.noOfDishesLiked()(10) === 7)
  }

  test("Top negative restaurants by rating") {
    assertThrows[IllegalArgumentException](Main.topNRestaurantsByRating(-10))
  }

}