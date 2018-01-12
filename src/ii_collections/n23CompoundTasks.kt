package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    return customers
            .filter { customer -> customer.orderedProducts.contains(product) }
            .toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    return orders
            .filter { order -> order.isDelivered }
            .flatMap { order -> order.products }
            .maxBy { product -> product.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
    return customers
            .flatMap { customer -> customer.orders }
            .flatMap { order -> order.products }
            .count { filteredProduct -> filteredProduct == product }
}
