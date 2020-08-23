package restaurant

import scala.collection.mutable.{ArrayBuffer, SortedMap}


class Order {
    val items = ArrayBuffer[Item]()

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

object Order {
    def apply(inputItems: Item*): Order = {
        val o = new Order
        for (t <- inputItems) yield o.items += t
        o
    }
}
