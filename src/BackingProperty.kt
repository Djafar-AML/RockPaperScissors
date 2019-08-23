class BackingProperty {
    var setterVisibility = "setter is private!!!"
        private set

    fun t() {
        setterVisibility = "the value of setterVisibility has changed!"
//        println(setterVisibility)
    }

    private var _setterBack = "the setter is private"
    val setterBack
        get() = _setterBack

}

fun main() {
    val backingProperty = BackingProperty()

    println(backingProperty.setterBack)

    println(backingProperty.setterVisibility)

    backingProperty.t()

    println(backingProperty.setterVisibility)

}
