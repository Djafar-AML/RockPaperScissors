package collections

class ListTrain {
    val mShopping = mutableListOf("Card", "Bag", "Pencil", "Milk")
    val toRetain = listOf("Milk", "Sugar", "Bag")

}

class SetTrain {

    val friendSet = setOf("Cefer :?", "Mohemmed :)", "Yasin!", "Cefer :?")
}

class MapTrain {
    val mRecipeMap = mutableMapOf<String, String>("First" to "first value", "Second" to "second value")
}

fun main() {

    val listTrain = ListTrain()

    for (item in listTrain.mShopping) {
        println(item)
    }

    listTrain.mShopping.retainAll(listTrain.toRetain)

    println("*****************")

    for (item in listTrain.mShopping) {
        println(item)
    }
    println("************Set**************")

    val setTrain = SetTrain()

    for (item in setTrain.friendSet) {
        println(item)
    }

    println("****************Map*****************")

    val mapTrain = MapTrain()
    val listOfMap = mapTrain.mRecipeMap.toList()

    for (item in listOfMap) {
        println(item)
    }


    println("**********Changed map**********")

    val originalValue = mapTrain.mRecipeMap.put("First", "CefEr changed")
    println("Original value was - $originalValue")

    for (item in mapTrain.mRecipeMap.toList()) {
        println(item)
    }

}