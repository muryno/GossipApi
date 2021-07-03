package com.company;


import com.company.a.Parking_Dilemma;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {


    public static void main(String[] args) {
//        letftToRight();
//        rightToLeft();
//
//        ConvertIntToList();
//
//        reversSort();

       // test();
        // finabas();
        //formateDate();
//        recursionFromBackToFront();
//        recursionFromFrontToBack();


        //Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
        //You may assume that each input would have exactly one solution, and you may not use the same element twice.
        //Input: nums = [2,7,11,15], target = 9
        //Output: [0,1]
//            int[] myArrays = {2 , 7 ,11, 15};
//            int[] outPutResult = getTheIndices(myArrays,9);
//
//            if(outPutResult != null){
//                System.out.println(outPutResult[0] + "  " + outPutResult[1]);
//            }
       // getThe();

        Parking_Dilemma.Companion.recursionFromFrontKotlin();

        }


    public static void getThe(){
        int[] data = {1,2,3,1,4,6,6,7,8,9,5,6,2,6,1,8,1,1,4,9,9};


         Arrays.sort(data);
        System.out.println(Arrays.toString(data));

        int lowestCount = 0;
        int highestCount = 0;
        int lowestValue = data[0];
        int lastIndex= data.length - 1;
        int highestValue = data[lastIndex];


        for(int i= 0; i<data.length; i++){
            if(data[0] == data[i]){
                lowestCount +=1;
            }
            if(data[lastIndex] == data[i]){
                highestCount += 1;
            }
        }

        System.out.println("{" +lowestValue + " : "+ lowestCount + ", "+ highestValue+ " : "+ highestCount );

    }


        public static int[] getTheIndices(int[] arr, int tar){
            int [] results = new int[2];
            for(int i = 0; i<arr.length; i++){
                for(int j = i + 1; j< arr.length; j++){
                    if(arr[i] + arr[j] == tar){
                        results[0]  = i;
                        results[1]  = j;

                        return  results;
                    }
                }
            }
            //else
            return null;
        }



        static private void finabas() {


        int count = 0;
        int n1 = 0;
        int n2 = 1;
        int n3;
        while (count < 50) {
            count++;
            n3 = n1 + n2;

            n1 = n2;
            n2 = n3;

            System.out.print(n3 + ",");


        }

    }

    static private void recursionFromBackToFront() {
        int[] a = {2, 3, 4, 2, 1};

        int row = 3;

        for (int i = 0; i < row; i++) {
            int last = a[a.length - 1];

            int k = a.length - 1;

            for (int j = k; j > 0; j--) {
                a[j] = a[j - 1];


            }
            a[0] = last;



//            System.out.print(Arrays.toString(a));
//            System.out.println("first");
        }

        System.out.println(Arrays.toString(a));
    }

    static private void recursionFromFrontToBack() {
        int[] a = {2, 3, 4, 2, 1};

        int row = 3;

        for (int i = 0; i < row; i++) {
            int first = a[0];


            for (int j = 1; j < a.length; j++) {
                a[j - 1] = a[j];
            }
            a[a.length - 1] = first;
        }
        System.out.println(Arrays.toString(a));
    }

    static void formateDate() {
        String myDate = "";

        try {
//           DateFormat inFormat = new SimpleDateFormat( "HH:mm:ss aa");
//           DateFormat outFormat = new SimpleDateFormat( "hh:mm:ss aa");
//           Date date = inFormat.parse("07:05:45PM ");
//           myDate =   outFormat.format(date);
//           System.out.println("see me"+myDate);
//
//           String myDate = "";

            Date myOld;
            DateFormat oldFormat = new SimpleDateFormat("hh:mm:ssaa");
            DateFormat newTim = new SimpleDateFormat("HH:mm:ss ");

            myOld = oldFormat.parse("07:05:45PM ");


            myDate = newTim.format(myOld);
            System.out.println("My date is :" + myDate);
        } catch (Exception e) {
            System.out.println(e);
        }

        //Arrays.sort();


    }


    static void hashing() {
        Map<Integer, String> ade = new HashMap<>();
        ade.put(1, "eee");

        for (Map.Entry<Integer, String> entry : ade.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            // ...
        }
        ade.size();

        System.out.println(ade.size());
//       Set<Integer> myset =new  TreeSet<Integer>();
//
//       if(myset.contains(1)){
//
//       }


        int count = 0;
        int result = 0;

        int whenToFire = 0;

        int countResult = 0;
        int used = 0;

        int x = 0;
        int y = 0;

        Set<Integer> myAde = new TreeSet<Integer>();
//        for (int a = 0; a < n; a++) {
//            for (int i = 0; i < friendships.length; i++) {
//
//                for (int j = 0; j < friendships[i].length; j++) {
//                    whenToFire += 1;
//                    if (whenToFire == 1) {
//                        x = friendships[i][j];
//                    } else if (whenToFire == 2) {
//                        y = friendships[i][j];
//                        whenToFire = 0;
//                    }
//                }
//
//                //see e
//                if (whenToFire == 0) {
//                    if (!myAde.contains(x) || !myAde.contains(y)) {
//                        myAde.add(x);
//                        myAde.add(y);
//                        count += 1;
//                        System.out.println("x =" + x + "  y=" + y);
//                        System.out.println("size =" + myAde.size() + "  count" + count);
//                        countResult = myAde.size() * count;
//                        result += countResult;
//                    } else {
//                        result += countResult;
//                    }
//                }
//
//            }
//
//
//            static char[][] mBoard = new char[3][3];
//            static private void showBoard () {
//
//
//                for (int i = 0; i < 3; i++) {
//
//                    for (int j = 0; j < 3; j++) {
//                        mBoard[i][j] = '-';
//                    }
//                }
//
////print game
//                System.out.println("welcome to Tic tic");
//                System.out.println("..............................");
//                for (int i = 0; i < 3; i++) {
//                    System.out.print("   |  ");
//                    for (int j = 0; j < 3; j++) {
//
//
//                        System.out.print(mBoard[i][j]);
//                        System.out.print("   |  ");
//                    }
//                    System.out.println();
//                    System.out.println("..............................");
//                }
//
//
//            }
//
//            static private String CheckWinner () {
//                //horizontal O check
//                if (mBoard[0][0] != '-' && mBoard[0][0] == 'O' && mBoard[0][0] == mBoard[0][1] && mBoard[0][1] == mBoard[0][2]
//                        || (mBoard[1][0] != '-' && mBoard[1][0] == 'O' && mBoard[1][0] == mBoard[1][1] && mBoard[1][1] == mBoard[1][2])
//                        || (mBoard[2][0] != '-' && mBoard[2][0] == 'O' && mBoard[2][0] == mBoard[2][1] && mBoard[2][1] == mBoard[2][2])) {
//
//                    return "0 player win the game ";
//                }
//
//                //horizontal X check
//                if (mBoard[0][0] != '-' && mBoard[0][0] == 'X' && mBoard[0][0] == mBoard[0][1] && mBoard[0][1] == mBoard[0][2]
//                        || (mBoard[1][0] != '-' && mBoard[1][0] == 'X' && mBoard[1][0] == mBoard[1][1] && mBoard[1][1] == mBoard[1][2])
//                        || (mBoard[2][0] != '-' && mBoard[2][0] == 'X' && mBoard[2][0] == mBoard[2][1] && mBoard[2][1] == mBoard[2][2])) {
//
//                    return "X player win the game ";
//                }
//
//                return "";
//            }
//
//
//            public static void getAddSum ( int[] l1, int[] l2){
//                StringBuilder l1An = new StringBuilder();
//                StringBuilder l2An = new StringBuilder();
//                Integer[] liLength = new Integer[l1.length];
//                Arrays.setAll(liLength, i -> l1[i]);
//                LinkedList<Integer> l1conv = new LinkedList<>(Arrays.asList(liLength));
//                Iterator<Integer> iterator1 = l1conv.descendingIterator();
//
//
//                System.out.println(iterator1.toString());
//                while (iterator1.hasNext()) {
//                    l1An.append(iterator1.next());
//
//                }
//
//                Integer[] l2Length = new Integer[l2.length];
//                Arrays.setAll(l2Length, i -> l2[i]);
//
//                LinkedList<Integer> l2conv = new LinkedList<>(Arrays.asList(l2Length));
//
//                Iterator<Integer> iterator2 = l2conv.descendingIterator();
//
//                while (iterator2.hasNext()) {
//                    l2An.append(iterator2.next());
//                }
//
//                int aja = Integer.parseInt(l2An.toString()) + Integer.parseInt(l1An.toString());
//
//                l2An = new StringBuilder();
//                l2An.append(aja);
//                System.out.println(l2An.reverse());
//                String[] finalAnswer = l2An.toString().split("");
//                System.out.println(Arrays.asList(finalAnswer));
//            }
//
//
//            public static int getBottleLeft ( int sales ){
//                int reminder = 0;
//                if (sales > 24) {
//                    reminder = sales % 24;
//                    return 24 - reminder;
//                } else {
//                    return 24 - sales;
//                }
//            }
//
//            public static int getCartonLeft ( int bottle, int sales){
//                int cartonOpened = getCartonOpened(bottle, sales);
//                int CartonLeft;
//
//
//                //to get carton sold
//                // A =(number of carton * number of bottles)  == 240
//                //formula
//                //(A - cartonSold)/ 24  == number of untouched carton left in the warehouse
//                CartonLeft = (bottle - cartonOpened) / 24;
//
//                return CartonLeft;
//
//            }
//
//            public static int getCartonOpened ( int bottle, int sales){
//
//                int answer = 0;
//                for (int i = 24; i < bottle; i += 24) {
//
//                    if (i > sales) {
//                        return i;
//                    }
//
//                }
//
//                return answer;
//
//            }
//
//
//            public static List<Integer> index ( int[] nums, int target){
//
//                List<Integer> answer = new ArrayList<>() {
//                };
//
//                for (int i = 0; i < nums.length; i++) {
//                    for (int j = 1; j < nums.length; j++) {
//
//                        if (nums[i] + nums[j] == target) {
//
//                            answer.add(i);
//                            answer.add(j);
//                        }
//                    }
//                }
//
//                return answer;
//            }
//
//
//        }


    }

    static void addingPrimitive(){
//
//        List<Integer> myDaddy = new ArrayList<Integer>();
//
//        int[] kun = {3,4,5,6,7,4};
//
////
//
//        int index =3;
//
//        int[] kuns={};
//        System.arraycopy(kun, index + 1, kuns, index, 9);




//        List<Integer> sd = Arrays.asList(kuns);
//        sd{}


        char[] copyFrom = {'w','y','i','b','a'};

        char[] copyTo = new char[5];

        System.arraycopy(copyFrom,0,copyTo,0,5);

        System.out.println(Arrays.toString(copyTo));



    }


    static void  cuttingStick(int n , int[] arr){



        int[] damy = arr;

       // int[] result = new int[]{};

        List<Integer> l = new ArrayList();

        while( n >0){


            int biola ;

            for(int i = 0;i<damy.length  ; i++ ){

                biola   =  damy[i] - damy[0];

                if(biola> 0){
                    damy[i] = biola;
                }else {
                    List<Integer> arrayList = IntStream.of(damy)
                            .boxed()
                            .collect(Collectors.toList());

                    // Remove the specified element
                    arrayList.remove(i);
                }

            }
            n -=1;


            l.add(damy.length);


        }
    }

    static  void frequencyPath(){
        int[] fr = new int[]{2,3,4,6,7,5,2,5,7,5,5,3,3,3};

        Arrays.sort(fr);

        int count = 1;
        Map<Integer,Integer> ft = new HashMap<>();
        for(int i= 1 ; i < fr.length ; i++){

            if(fr[i] == fr[i-1]){
                count += 1;

            }else {
                ft.put(fr[i-1],count);
                count = 1 ;
            }
        }

        for(Map.Entry<Integer,Integer>   ser : ft.entrySet()){
            System.out.println(ser.getKey() + " | " + ser.getValue());
        }

    }

    static void letftToRight(){

        int[] a = {2, 3, 4, 2, 1};

        int  n = 3;
        for(int k = 0 ; k< n ; k++){
            int last = a[a.length -1];
            for (int j = a.length-1 ; j > 0 ; j-- ){
                 a[j] =  a[j-1];
            }
            a[0] = last;

        }
        System.out.print(Arrays.toString(a) + " ");
        //answer = [4, 2, 1, 2, 3]
    }

    static  void  rightToLeft(){
        int[] a = {2, 3, 4, 2, 1};

        int  n = 3;

        List<Integer>  sed = IntStream.of(a).boxed().collect(Collectors.toList());

        for(int k = 0 ; k< n ; k++){

            int first = a[0];
            for (int i=0; i<a.length-1; i++){
                a[i]= a[i+1];
            }
            a[a.length-1]= first;



        }

        System.out.print(Arrays.toString(a) + " ");

    //    [2, 1, 2, 3, 4]
    }

    static  void  ConvertIntToList() {
        int[] a = {2, 3, 4, 2, 1};

        int n = 3;

        List<Integer> sed = IntStream.of(a).boxed().collect(Collectors.toList());


        int[] edr = sed.stream().mapToInt(Integer::intValue).toArray();

        System.out.println(sed.toString());
        System.out.println(Arrays.toString(edr));


    }

    static void  reversSort(){
        int[] a = {2, 3, 4, 2, 1};


        List<Integer>  der = IntStream.of(a).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        Arrays.parallelSort(a);

        System.out.println(der.toString());
    }


    //Write a function that takes in an array of at least three integers and,
    // without sorting the input array of the three largest integers in the input array.
    // The function should return duplicate integers if necessary; for example, it should return [10, 10, 12]
    // for an input array of [10, 5, 9, 10, 12]
    //  
    static void test(){

        int[] aa = {10, 5, 9, 10, 12};


        List<Integer>  results = new ArrayList<>();

        int higst  = 0 ;
        for (int j= 1 ; j< aa.length; j++ ){

            if(  aa[j]> aa[j-1]){
                higst  =  aa[j];
            }



        }
        results.add(higst);


        System.out.println(results.toString());



//        for(int ade=0; ade<a.length;ade++){
//            System.out.println(a[ade]);
//            for(int j=0; j<a.length;j++){
//                System.out.print(a[j]);
//            }
//            System.out.println("");
//        }

//
//        int[] aa = {10, 5, 9, 10, 12};
//
//       int i;
//       int n = aa.length / a

    }
    public static long getNumberOfOptions(List<Integer> priceOfJeans, List<Integer> priceOfShoes, List<Integer> priceOfSkirts, List<Integer> priceOfTops, int budgeted) {
        // Write your code here

        long count =0;
        //four layer for loop to check all combinations of four arrays
        for(int i=0; i<priceOfJeans.size();i++) {
            for(int j=0; j<priceOfShoes.size();j++) {
                for(int k=0; k<priceOfSkirts.size();k++) {
                    for(int l=0; l<priceOfTops.size();l++) {
                        // Checking if the sum of this combination is less than
                        // or equal to given budget. If yes increment count
                        if (priceOfJeans.get(i)+priceOfShoes.get(j)+priceOfSkirts.get(k)+priceOfTops.get(l)<=budgeted)
                            count = count +1;
                    }
                }
            }
        }
        //count contain final result, it is returned to main() function
        return count;
    }

//
//    public class SumOfTwoToTargetNumber{
//
//        public static int[] getIndices(int[] arr, int tar){
//            int [] result = new int[2];
//            for(int i = 0; i<arr.length; i++){
//                for(int j = i + 1; j< arr.length; j++){
//                    if(arr[i] + arr[j] == tar){
//
//                    }
//                }
//            }
//        }
//    }




}