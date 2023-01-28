class Solution {
//    fun romanToInt(s: String): Int {
//
//    }

    fun parseString(s: String): Int {
        val symbols: CharArray = s.toCharArray()
        var result = 0
        for (i in symbols.indices) {
            if (i + 1 <= symbols.indices.last && i + 2 <= symbols.indices.last) {
                if (i == 0) {
                    result = romanRulesThree(getRomanInt(symbols[i])!!, getRomanInt(symbols[i + 1])!!, getRomanInt(symbols[i + 2])!!)
                }
                else {
                    result = romanRules(result, getRomanInt(symbols[i + 1])!!)
                }
            } else if (i + 1 <= symbols.indices.last) {
                if (i == 0) {
                    result = romanRules(getRomanInt(symbols[i])!!, getRomanInt(symbols[i + 1])!!)
                }
                else {
                    result = romanRules(result, getRomanInt(symbols[i + 1])!!)
                }
            }
        }
        return result
    }

    fun getRomanInt(symbol: Char) = romanNumerics.find { it.first == symbol }?.second

    fun romanRules(firstValue: Int, secondValue: Int): Int {
        var result: Int = 0

        if (firstValue >= secondValue) {
            result = firstValue + secondValue
            return result
        } else {
            when (firstValue) {
                1 -> {
                    result = if (secondValue == 5) 4 else 9
                    return result
                }

                10 -> {
                    result = if (secondValue == 50) 40 else 90
                    return result
                }

                100 -> {
                    result = if (secondValue == 500) 400 else 900
                    return result
                }
            }
        }
        return result
    }

    fun romanRulesThree(firstValue: Int, secondValue: Int, thirdValue: Int): Int {
        var result: Int = 0

        if (firstValue >= secondValue) {
            result = firstValue + secondValue
            return result
        } else {
            when (firstValue) {
                1 -> {
                    result = if (secondValue == 5) 4 else 9
                    return result
                }

                10 -> {
                    result = if (secondValue == 50) 40 else 90
                    return result
                }

                100 -> {
                    result = if (secondValue == 500) 400 else 900
                    return result
                }
            }
        }
        return result
    }

    val romanNumerics: List<Pair<Char, Int>> = listOf(
        Pair('I', 1),
        Pair('V', 5),
        Pair('X', 10),
        Pair('L', 50),
        Pair('C', 100),
        Pair('D', 500),
        Pair('M', 1000),
    )
}

