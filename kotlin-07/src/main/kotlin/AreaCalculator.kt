class AreaCalculator(val length: Int, val width: Int) {
    fun getAreaInSquareFeet(): Int  = length * width
    fun getAreaInSquareMeters(): Double = getAreaInSquareFeet() * SQ_FEET_TO_SQ_METERS_RATIO

}

const val SQ_FEET_TO_SQ_METERS_RATIO = 0.0929034