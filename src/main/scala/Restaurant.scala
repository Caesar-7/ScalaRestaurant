package restaurant

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.SortedMap

class Item(
    val name: String,
    val itemId: Int,
    val description: String,
    val price: Double
) {
    // Creates the map containing the item's informations
    val infoMap = Map(
        "Name" -> name,
        "Item ID" -> itemId,
        "Description" -> description,
        "Price" -> price
    )

    // Returns the infoMap
    def info(): Map[String, Any] = infoMap
}


class Order(val inputItems: Item*) {
    val items = ArrayBuffer[Item]()
    for (t <- inputItems) yield items += t

    // Adds items to the order
    def addItems(newItems: Item*): Unit = items ++= newItems

    // Removes item from the order
    def removeItems(newItems: Item*): Unit = items --= newItems

    // Removes all items from the order
    def wipeOrder(): Unit = items.clear()

    // Returns a string with the order's informations
    def info(): String = {
        if (items.isEmpty) {
            "The order is empty"
        } else{
            // itemsCount maps the items in the order to their quantity
            val itemsCount = SortedMap[String, Int]()
            var total = 0.0

            // Fills itemCount and calculates the total
            for (t <- items) {
                if (itemsCount.contains(t.name)) {
                    itemsCount.get(t.name) match {
                        case Some(value) => itemsCount(t.name) += 1
                        case None => throw new RuntimeException("Fatal error")
                    }
                } else{
                    itemsCount += (t.name -> 1)
                }

                total += t.price
            }

            // itemsNames is the formatted list of items
            var itemsNames = ""

            for ((name, quantity) <- itemsCount) {
                itemsNames += s"$name x$quantity, "
            }

            itemsNames = itemsNames.slice(0, itemsNames.length - 2)

            s"[$itemsNames], $total$$"
        }
    }
}
