import RestaurantFeatures.RestaurantFeatures

object Configure {
  def configure(): Map[Int, RestaurantFeatures] = {
    val dataSource = io.Source.fromFile("sampleData/zomato_cleaned - zomato_cleaned.csv")
    var zomatoData: Map[Int, RestaurantFeatures] = Map()

    for (row <- dataSource.getLines()) {
      val curRow = parseCurRow(row)
      val curId = curRow.head.toInt
      val restaurantFeatures = RestaurantFeatures(
        curRow(1),
        if (curRow(2).contains('/')) curRow(2).split('/').head.toDouble else 0,
        curRow(3).toInt,
        curRow(4),
        curRow(5).split(',').toList,
        curRow(6).split(',').toList,
        curRow(7).split(',').toList,
        curRow(8).toDouble
      )
      zomatoData += (curId -> restaurantFeatures)
    }
    dataSource.close()
    zomatoData
  }

  def parseCurRow(curRow: String): List[String] = {
    curRow.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1).toList
  }
}
