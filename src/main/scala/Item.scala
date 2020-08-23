package restaurant

import scala.collection.mutable.Map


class Item {
    var name: String = ""
    var itemId: Int = 0
    var description: String = ""
    var price: Double = 0.0

    // Returns the infoMap
    def info(): Map[String, Any] = {
        // Creates the map containing the item's informations
        val infoMap = Map(
            "Name" -> name,
            "Item ID" -> itemId,
            "Description" -> description,
            "Price" -> price
        )

        infoMap
    }
}

object Item {
    def apply(name: String, itemId: Int, description: String, price: Double): Item = {
        val i = new Item
        i.name = name
        i.itemId = itemId
        i.description = description
        i.price = price
        i
    }
}
