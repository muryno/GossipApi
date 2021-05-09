//package com.company.a
//
//import java.util.*
//import java.util.function.ToIntFunction
//import java.util.stream.Collectors
//import java.util.stream.IntStream
//
//class see {
//
//
//    fun Confly() {
//        val a = intArrayOf(2, 3, 4, 2, 1)
//        val n = 3
//        val sed = IntStream.of(*a).boxed().collect(Collectors.toList())
//        val edr = sed.stream().mapToInt { obj: Int -> obj }.toArray()
//        println(sed.toString())
//        println(Arrays.toString(edr))
//    }
//
//
//    public  int parkingdilemma(int[] cars, int k)
//    {
//        Array.Sort(cars);
//
//        int min = int.MaxValue;
//
//        for(int i=0; i< cars.Length -k+1; i++)
//        {
//            min = Math.Min(min, cars[i + k - 1] - cars[i]);
//        }
//        return min+1;
//    }
//}