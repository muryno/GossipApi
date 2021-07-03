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


    fun getUmbrellas(requirement: Int, sizes: IntArray): Int {
        var min = 1000 // we give the max value to it for comparison
        var flag = 0
        var req = 0
        for (i in sizes.indices) {
            if (requirement % sizes[i] == 0) {   // condition to check if exact umbrellas present
                req = requirement / sizes[i]
                flag = 1 // sets value to 1 for later checking
            }
            if (req < min) {  // if more than 1 umbrellas completely fill the requirement, the min is taken
                min = req
            }
        }
        val data = intArrayOf(1, 2, 3, 1, 4, 6, 6, 7, 8, 9, 5, 6, 2, 6, 1, 8, 1, 1, 4, 9, 9)

        for(i in data.indices){

        }

        return if (flag == 1) {  // checks if there is result present, if not, returns -1
            min
        } else {
            -1
        }
    }


    companion object{

        fun recursionFromBackKotlin(){
            val data: IntArray = intArrayOf(3,4,6,2,9)
            val numberOfRotation = 3

            for(i in 0 until  numberOfRotation){
                val first = data[0]

                for(i in 1 until data.size ){
                    data[i-1 ] = data[i]
                }
                data[data.size - 1] = first
            }

            print(data.contentToString())
        }


        fun recursionFromFrontKotlin(){
            val data : IntArray = intArrayOf(3,4,6,2,9)
            val numberIteration = 3
            val lastvalue  = data.size - 1

            for (i in 0 until numberIteration){
                val lastVal = data[data.size - 1]


                print(lastVal)
            }


        }
    }

    private fun recursionFromBackToFront() {
        val a = intArrayOf(2, 3, 4, 2, 1)
        val row = 3
        for (i in 0 until row) {
            val last = a[a.size - 1]
            val k = a.size - 1
            for (j in k downTo 1) {
                a[j] = a[j - 1]
            }
            a[0] = last


//            System.out.print(Arrays.toString(a));
//            System.out.println("first");
        }
        println(Arrays.toString(a))
    }









}

