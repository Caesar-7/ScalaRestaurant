# ScalaRestaurant

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/75230a0bdf6a4022a8dd926279a74289)](https://www.codacy.com/manual/Caesar-7/ScalaRestaurant?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Caesar-7/ScalaRestaurant&amp;utm_campaign=Badge_Grade)
![](https://img.shields.io/travis/com/Caesar-7/ScalaRestaurant)
![](https://img.shields.io/github/license/Caesar-7/ScalaRestaurant?color=blue)

ScalaRestaurant is a package that lets you create items and orders for restaurants, similar to the one in the wrappers for the Domino's API, like [PizzaPi](https://github.com/ggrammar/pizzapi).

---


## Table of content
- [Installing](#Installing)
- [How it works](#How-it-works)
- [Contributors](#Contributors)


## Installing

If you want to use this package in the Scala REPL or in your project, first download the repo:


```bash
git clone https://github.com/Caesar-7/ScalaRestaurant.git
```

Then, you can either use sbt, or just copy [Restaurant.scala](https://github.com/Caesar-7/ScalaRestaurant/blob/master/src/main/scala/Restaurant.scala) in any repository and compile it. You can import the package like this:

```scala
// Import all the classes
import restaurant._

// Import just one class
import restaurant.Item
```


## How it works

Inside the `restaurant` package there are two classes: `Item` and `Order`


The `Item` class defines an item of the menu. It has a `name (String)`, an `itemId (Int)`, a `description (String)` and a `price (Double)`.
The `Item` class also has an `info` method that returns a `Map` containing the item's informations.

```scala
// Define a new Item
val coke = new Item("Coke", 1, "A refreshing drink", 1.0)

// Print the item's informations
println(coke.info())
```


The `Order` class defines an object that contains a list of items. An order can be created with or without initial parameters.
The `Order` class has 4 methods: `addItems`, `removeItems`, `wipeOrder` and `info`. The first two method simply add or remove items from the order, `wipeOrder` removes all the items from the order, and `info` returns a string with the list of items in square brackets, and the total cost of the order.
If the order contains more than one of the same item, the `info` method will group the items (ex. [chips, chips, pizza] = [chips x2, pizza])

```scala
// Both of these statements are valid
val myOrder = new Order()
val myOrder = new Order(coke, pizza)

// Add items to an order
myOrder.addItems(pizza, chips)

// Remove items from an order
myOrder.removeItems(chips)

// Remove all the items from the order
myOrder.wipeOrder()

// Print the order's informations
println(myOrder.info) // Output: "[item, another item], cost$"
```

> **N.B.** The list of items returned by the `info` method is sorted in alphabetical order. The method will also display the dollar sign near the total cost of the order; if you want to change it or remove it you can edit the [last line of `Restaurant.scala`](https://github.com/Caesar-7/ScalaRestaurant/blob/master/src/main/scala/Restaurant.scala#L69)


## Contributors

Click on [this link](https://github.com/Caesar-7/ScalaRestaurant/graphs/contributors) to see the list of contributors who participated in this repository.
