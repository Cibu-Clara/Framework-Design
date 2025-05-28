import kotlin.math.roundToInt

fun computeHydrationPercent(quantity: Float, goal: Float): Int {
    return ((quantity / goal) * 100).roundToInt()
}

fun computeHydrationLevel(percent: Int, height: Int) : Float {
    return (percent.toFloat() / 100) * height
}
