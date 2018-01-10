package ii_collections

fun example() {

    val result = listOf("abc", "12").flatMap { it.toList() }

    result == listOf('a', 'b', 'c', '1', '2')
}

val Customer.orderedProducts: Set<Product> get() {
    return this.orders.flatMap { order -> order.products }.toSet()
}

val Shop.allOrderedProducts: Set<Product> get() {
    return this.customers.flatMap { customer -> customer.orderedProducts }.toSet()
}
