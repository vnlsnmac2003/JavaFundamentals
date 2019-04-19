/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Sorting;

import java.util.Arrays;

/**
 *
 * @author Personal
 */
public class BubbleSort {
    
    //TASK: sort a list of numbers into ascending order using bubble sort
    
    /* 'unsortedListRange' this specifies the range of numbers being sorted.
     * Each time it removes the last number as once the biggest number is picked up
     * it will always end up at the end meaning it doesn't need to be looked at anymore */
    
    /* The BIG O time complexity of bubble sort is: O(n2) as this involved nested a nested loop
     * and inside a regular loop. 2 nested loops inside a regular loop would make it O(n3)*/
    
     public static int[] bubbleSort(int[] list){
        int unsortedListRange = list.length - 1;
        while(true){
            int swaps = 0;
            for(int i = 0; i < unsortedListRange; i++){
                if(list[i] > list[i+1]){
                    int higher = list[i];
                    int lower = list[i+1];
                    list[i] = lower;
                    list[i+1] = higher;
                    swaps++;
                }
            }
            unsortedListRange--;
            if(swaps == 0)
                break;
        }
         return list;
    }
    
    public static void main(String[] args) {
        int[] numbers = {4,6,66,2,7,89,01,-5,82,33,-4,-67,111,0};
        
        System.out.println("BEFORE: "+Arrays.toString(numbers));
        System.out.println("AFTER: "+Arrays.toString(bubbleSort(numbers)));
    }
}
