package structural.decorator

import java.math.BigDecimal
import java.math.BigDecimal.*

// Abstract Component
abstract class Beverage(val description: String, val cost: BigDecimal)

// Concrete Component
class StandardCoffee(description: String = "Standard cofee", cost: BigDecimal = ONE) : Beverage(description, cost)

// Decorator
abstract class AddOnBeverageDecorator(val beverage: Beverage, description: String, cost: BigDecimal) : Beverage(description, cost)

class Caramel(beverage: Beverage) : AddOnBeverageDecorator(beverage, description = "Caramel", cost = beverage.cost.plus(2.toBigDecimal()))

class Chantilly(beverage: Beverage) : AddOnBeverageDecorator(beverage, description = "Caramel", cost = beverage.cost.plus(3.toBigDecimal()))

fun main() {
    val bev1 = StandardCoffee()

    println(bev1.cost)

    val bev1WithCaramel = Caramel(bev1)

    println(bev1WithCaramel.cost)

    val bev1WithCaramelWithChantilly = Chantilly(bev1WithCaramel)

    println(bev1WithCaramelWithChantilly.cost)
}

/**
 * The goal of this pattern is to add behavior to an object (called component) in runtime instead of compile timem, through a wrapper (the decorator).
 * Also we don't need to change the original class. This conforms to the SRP.
 * To achieve this we need to wrap the original object with another object, which will interact with the inner object.
 * The decorator IS the same type of the component, so it can work interchangeable with the component by its clients,
 * and HAS an object (component) so we can send the message downwards.
 * This pattern provides an alternative to subclassing, since we can compose behavior dynamically
 */