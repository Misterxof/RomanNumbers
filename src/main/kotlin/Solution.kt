class Solution {
    fun romanToInt(s: String): Int {
        val ar = parseStringToArrayInt(s)
        var result = 0
        ar.forEach {
            result += it
        }
        return result
    }

    fun parseStringToArrayInt(s: String): Array<Int> {
        val ar = s.toCharArray()
        val res: Array<Int> = Array(ar.size) { 0 }
        var isEnd = false
        var i = 0

        while (!isEnd) {
            if (i + 1 <= ar.indices.last) {
                val str = "${ar[i]}${ar[i + 1]}"
                val special = getRomanSpecialInt(str)

                if (special != null) {
                    res[i] = special

                    if (i + 1 == ar.indices.last)
                        isEnd = true
                    else
                        i += 2
                } else {
                    res[i] = getRomanInt(ar[i])!!
                    i++
                }
            } else {
                res[i] = getRomanInt(ar[i])!!
                isEnd = true
            }
        }
        return res
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

