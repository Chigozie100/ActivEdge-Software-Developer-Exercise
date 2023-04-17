package com.example.ActivEdgeSoftwareDeveloperExercise.exercise1;

import java.util.Arrays;

public class SmallestNonOccurringInteger {
    public static int findSmallestNonOccurringInteger(int[] arr) {
        Arrays.sort(arr);
        int smallestNonOccurringInteger = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > smallestNonOccurringInteger) {
                return smallestNonOccurringInteger;
            }
            else if (arr[i] == smallestNonOccurringInteger) {
                smallestNonOccurringInteger++;
            }
        }
        return smallestNonOccurringInteger;
    }
}
