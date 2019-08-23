class Wolf(val name: String) {
    fun eat() {
        println("$name eats meat")
    }
}

class NullSafety {
    fun getAlphaWolf(): Wolf? {
        return Wolf("AlphaWolf")
    }
}

fun main() {
    var array = arrayOf("Ji", "Cefer", null)

    for (item in array) {
        item?.let {
            println(it)
        }

    }

    NullSafety().getAlphaWolf()?.eat()

    // try and throw are expressions
    val result = try {
        array.get(1)
    } catch (e: ArrayIndexOutOfBoundsException) {
        null
    }
    println("Result of array index 1 is : $result")


}
