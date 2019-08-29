package higherorderfuctions

data class Grocery(
    val name: String, val category: String,
    val unit: String, val unitPrice: Double,
    val quantity: Int
)

fun main() {
    val groceries = listOf(
        Grocery("Tomatoes", "Vegetable", "kg", 4000.0, 3),
        Grocery("Mushrooms", "Vegetable", "kg", 3000.0, 1),
        Grocery("Bagels", "Bakery", "pack", 5000.0, 2),
        Grocery("Olive oil", "Pantry", "bottle", 6000.0, 1),
        Grocery("Ice cream", "Frozen", "pack", 4000.0, 2)
    )

    // sort groceries
    val highestUnitPrice = groceries.maxBy { it.unitPrice }
    println(highestUnitPrice)
    val lowestPriceUnit = groceries.minBy { it.unitPrice }
    println(lowestPriceUnit)

    val sumQuantity = groceries.sumBy { it.quantity }
    println(sumQuantity)

    val totalPrice = groceries.sumByDouble { it.unitPrice * it.quantity }
    println(totalPrice)

    val vegetables = groceries.filter { it.category == "Vegetable" }
    println(vegetables)

    val unitPriceOver = groceries.filter { it.unitPrice > 3000 }
    println(unitPriceOver)

    val notFrozen = groceries.filterNot { it.category == "Frozen" }
    println(notFrozen)

    val ints = listOf(1, 2, 3, 4)
    println(ints)
    val doubleInts = ints.map { it.times(2) }
    println(doubleInts)

    val groceriesName = groceries.map { it.name }
    println(groceriesName)

    val newPrices = groceries.filter { it.unitPrice > 3000.0 }.map { it.name }
    println(newPrices)

    // foreach lambda’s body has a Unit return value. This means that you can’t use forEach to return the result of some calculation
    var itemNames = ""
    groceries.forEach { itemNames += "  ${it.name}" }
    println("itemNames : $itemNames")

    // groupBy returns a map!
    val groupByCategory = groceries.groupBy { it.category }
    println(groupByCategory)
    groupByCategory.forEach {
        println(it.key)
        it.value.forEach { println("    ${it.name}") }
    }

    // kotlin fold function
    val sumOfInts = ints.fold(1) { runningSum, item -> runningSum * item }
    println("\nsum of ints : $sumOfInts")

    val concatenateNames = groceries.fold("") { string, item -> string + " ${item.name}" }
    println("concatenated names : $concatenateNames")

    val changeFrom50 = groceries.fold(50000.0) { change, item -> change - (item.unitPrice * item.quantity) }
    println("changeFrom50 : $changeFrom50")

//    This function works in a similar way to fold, except that you don’t have to specify the initial value. It automatically uses the first item in the collection as the initial value.
    val sumOfIntsWithReduce = ints.reduce { runningSum, item -> runningSum + item }
    println("sumOfIntsWithReduce : $sumOfIntsWithReduce")

    //Write the code below to find out how much will be spent on vegetables.
    val vegetablesSpentMoney =
        groceries.filter { it.category == "Vegetable" }.sumByDouble { it.quantity * it.unitPrice }
    println("vegetablesSpentMoney : $vegetablesSpentMoney")

    //Create a List containing the name of each item whose total price is less than 5.0
    val lessThan5 = groceries.filter { it.unitPrice < 5000.0 }.map { it.name }
    println("\nlessThan5 $lessThan5")


    groupByCategory.forEach { it ->
        println("${it.key} total cost for this category is: ${it.value.sumByDouble { it.unitPrice * it.quantity }}")
    }
}