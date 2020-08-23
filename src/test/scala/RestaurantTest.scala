import restaurant._
import org.scalatest.FunSuite


class ItemTest extends FunSuite {
    test("info() method works") {
        val coke = Item("Coke", 1, "", 1.0)
        assert(coke.info() == Map(
            "Name" -> "Coke",
            "Item ID" -> 1,
            "Description" -> "",
            "Price" -> 1.0
        ))
    }
}


class OrderTest extends FunSuite {
    val coke = Item("coke", 1, "", 1.0)
    val pizza = Item("pizza", 2, "tomato, mozzarella, basil", 2.0)
    val chips = Item("chips", 3, "", 2.0)

    val myOrder = Order(coke)

    test("addItems() works") {
        myOrder.addItems(coke, pizza, chips)
        assert(myOrder.info() == "[chips x1, coke x2, pizza x1], 6.0$")
    }

    test("removeItems() works") {
        myOrder.removeItems(coke, pizza)
        assert(myOrder.info() == "[chips x1, coke x1], 3.0$")
    }

    test("Multiple element group") {
        myOrder.addItems(chips, chips, pizza, pizza)
        assert(myOrder.info() == "[chips x3, coke x1, pizza x2], 11.0$")
    }

    test("wipeOrder() works") {
        myOrder.wipeOrder()
        assert(myOrder.info() == "The order is empty")
    }
}
