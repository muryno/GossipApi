package com.company.a

import java.util.*


class Parking_Dilemma {
    /**
     * @param cars:  integer array of length denoting the parking slots where cars are parked
     * @param k: integer denoting the number of cars that have to be covered by the roof
     * @return: return the minium length of the roof that would cover k cars
     */
    fun ParkingDilemma(cars: IntArray, k: Int): Int {
        // write your code here
        Arrays.sort(cars)
        val len = cars.size
        var min = cars[k - 1] - cars[0]
        for (i in 1..len - k) {
            if (min > cars[k - 1 + i] - cars[i]) {
                min = cars[k - 1 + i] - cars[i]
            }
        }
        return min
    }
}

//  int min = int.MaxValue;
//
//        for(int i=0; i< cars.Length -k+1; i++)
//        {
//            min = Math.Min(min, cars[i + k - 1] - cars[i]);
//        }