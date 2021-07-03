//package com.company.a
//
//import java.util.*
//import java.util.Arrays
//import java.util.Collections
//
//
//
//
//
//
//
//class dff {
//
//
////    fun ParkingDilemma(cars: IntArray, k: Int): Int {
////        // write your code here
////        Arrays.sort(cars)
////        cars.sort()
////       var  result = cars[k-1]-cars[0]+11
////        for i in range(len(cars)-k+1):
////        result = Int(Minm(result,cars[i+k-1]-cars[i]+1))
////    }
//
//    fun levelUp(k: Int, score: Array<Int>): Int {
//        if (k <= 0) return 0
//        Collections.sort(score, Collections.reverseOrder())
//        var rank = 1
//        var res = 0
//        for (i in 0 until score.size) {
//            if (i == 0) {
//                rank = 1
//            } else if (score[i] !== score[i - 1]) {
//                rank = i + 1
//            }
//            if (rank <= k && score[i] > 0) res++ else break
//        }
//
//        val max = Float.POSITIVE_INFINITY
//
//        minmum = Math.min(max, cars[i + k - 1] - cars[i])
//
//        return res
//    }
//}
//
//fun carParkingRoof(cars: Array<Long>, k: Int): Long {
//    // Write your code here
//
//
//    Arrays.sort(cars)
//
//    val lengths = cars.size
//
//    var minmum = Double.POSITIVE_INFINITY
//
//
//    for(i in 1..lengths - k + 1 ){
//        minmum = Math.min(minmum, (cars[i + k - 1] - cars[i]).toFloat())
//    }
//
//
//    return minmum
//
//}


fun minStart(arr: Array<Int>): Long {
    // Write your code here
    var i: Int
    val n: Int = arr.size / arr[0]

    var min: Long = 10000001
    var sum: Long = 0

    {
        i = 0
        while (i < n) {
            sum = sum + arr[i]
            if (sum < min) min = sum
            i++
        }
    }
    return min * -1 + 1
    return min * -1 + 1
}
