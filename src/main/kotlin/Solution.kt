class Solution {
//    fun romanToInt(s: String): Int {
//
//    }

    fun parseString(s: String): Int {
        val ar = parseStringToArrayInt(s)
        var result = 0
        ar.forEach {
            result += it
        }
        return result
    }
    fun parseStringToArrayInt(s: String): Array<Int> {
        val ar = s.toCharArray()
        val res: Array<Int> = Array(ar.size){0}
        var isEnd = false
        var i: Int = 0
        while (!isEnd){
            if  (i + 1 <= ar.indices.last){
                val str = "${ar[i]}${ar[i+1]}"
                val special = getRomanSpecialInt(str)
                println("${ar[i]} special $special")
                if (special != null) {
                    res[i] = special
                    println("res[$i] = $special")
                    if (i + 1 == ar.indices.last)
                        isEnd = true
                    else
                        i += 2
                } else {
                    res[i] = getRomanInt(ar[i])!!
                    println("res[$i] = ${getRomanInt(ar[i])!!}")
                    i++
                }
            } else {
                res[i] = getRomanInt(ar[i])!!
                println("res[$i] = ${getRomanInt(ar[i])!!}")
                isEnd = true
            }
        }
//        for (i in ar.indices) {
//            if  (i + 1 <= ar.indices.last){
//                val str = "${ar[i]}${ar[i+1]}"
//                val special = getRomanSpecialInt(str)
//                println("${ar[i]} special $special")
//                if (special != null) {
//                    res[i] = special
//                    println("res[$i] = $special")
//                } else {
//                    res[i] = getRomanInt(ar[i])!!
//                    println("res[$i] = ${getRomanInt(ar[i])!!}")
//                }
//            } else {
//                res[i] = getRomanInt(ar[i])!!
//                println("res[$i] = ${getRomanInt(ar[i])!!}")
//            }
//        }
    return res
    }
    fun parseString2(s: String): Int {
        val symbols: CharArray = s.toCharArray()
        var result = 0
        for (i in symbols.indices) {
            if (i + 1 <= symbols.indices.last && i + 2 <= symbols.indices.last) {
                if (i == 0) {
                    result = romanRules(
                        getRomanInt(symbols[i])!!,
                        getRomanInt(symbols[i + 1])!!,
                    )
                } else {
                    result = romanRules(result, getRomanInt(symbols[i + 1])!!)
                }
            }
        }
        return result
    }

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

    fun getRomanInt(symbol: Char) = romanNumerics.find { it.first == symbol }?.second

    fun getRomanSpecialInt(str: String) = romanSpecial.find { it.first == str }?.second

    val romanNumerics: List<Pair<Char, Int>> = listOf(
        Pair('I', 1),
        Pair('V', 5),
        Pair('X', 10),
        Pair('L', 50),
        Pair('C', 100),
        Pair('D', 500),
        Pair('M', 1000),
    )
    val romanSpecial: List<Pair<String, Int>> =
        listOf(Pair("IV", 4), Pair("IX", 9), Pair("XL", 40), Pair("XC", 90), Pair("CD", 400), Pair("CM", 900))
}

