package com.aks.learnings.arrays.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentRowElimination {

    public static void main(String[] args) {

        Integer[] students = { 9, 1, 2, 3, 1, 5 };

        int size = 6;

        
        removeStudents(students, size);

        Integer[] h = {1,7,8,4,5,6,-1,9};

        int n = h.length;

        removeStudents(h, n);

        Integer[] h2 = {4, 2, 3, 5, 1, 4};

        int n2 = h2.length;

        removeStudents(h2, n2);
    }

    public static int removeStudents(Integer[] H, int N) {

        List<Integer> lis = new ArrayList<>();

        System.out.println("\n\n\ninarr : " + (new ArrayList<>(Arrays.asList(H))).toString());
        int val = H[0];

        lis.add(val);

        int len = 1;

        System.out.println("\nlis : " + lis + " len : " + len);

        for (int i = 1; i < N; i++) {

            val = H[i];

            len = lis.size();

            if (len == 1) {

                /*
                 * if len == 1, then only 1 element inserted so far. Replace
                 * lisVal with val, only if val is less than lisVal
                 * 
                 */
                int lisVal = lis.get(0);

                if (val <= lisVal) {
                    lis.set(0, val);
                } else {
                    lis.add(val);
                }

            } else {

                int idx = Collections.binarySearch(lis, val);

                System.out.println("\nval : " + val + " len : " + len + " BS : " + idx + " BS - : " + ((idx * -1) -1));

                if(idx < len && idx > -1) {
                    System.out.println("inside 1");
                    lis.set(idx, val);
                } else if(idx < 0 && idx >= (len*-1)) {
                    System.out.println("inside 12 idx : ");
                    lis.set((idx * -1) -1 , val);
                }  else {
                    System.out.println("inside 13");
                    lis.add(val);
                }
            }

            len = lis.size();

            System.out.println("lis : " + lis + " len : " + len);

        }

        return N-len;
    }

    private static void lowerBound(List<Integer> lis, int val) {

        int len = lis.size();

        /*
         * else, the LIS array is sorted. using logic like binary search, to
         * find index where val > mid -1 and val <= mid.
         * 
         * But first check the val for less than 1st lisVal and greater than
         * last lisVal
         * 
         */

        if (val < lis.get(0)) {
            lis.set(0, val);
        } else if (val > lis.get(len - 1)) {
            lis.add(val);
        }

        int mid = (len / 2) - 1;

        int midVal = lis.get(mid);

        if (val < midVal) {

        }
    }
}
