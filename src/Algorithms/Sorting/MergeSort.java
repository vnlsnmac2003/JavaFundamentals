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
public class MergeSort {
    
    public static int[] mergeSort(int[] list){
        System.out.println("LIST: "+Arrays.toString(list));
        if(list.length <= 1){
            return list;
        }
        
        int arraySize = list.length;
        int midpoint =  arraySize / 2;
        int[] leftHalf = new int[midpoint];
        int[] rightHalf = new int[arraySize - midpoint];

        for(int i = 0; i < midpoint; i++){
            leftHalf[i] = list[i];
        }

        for(int i = 0; i < rightHalf.length; i++){
            rightHalf[i] = list[midpoint + i];
        }
        
        int[] result = new int[list.length];
        
        leftHalf = mergeSort(leftHalf);
        System.out.println("LEFT HALF: "+Arrays.toString(leftHalf));
        rightHalf = mergeSort(rightHalf);
        System.out.println("RIGHT HALF: "+Arrays.toString(rightHalf));
        
        result = merge(leftHalf, rightHalf);
        System.out.println("MERGE RESULT: "+Arrays.toString(result)+" \n");
        
        return result;
    }
    
    public static int[] merge(int[] leftHalf, int[] rightHalf){
        
        int[] result = new int[leftHalf.length + rightHalf.length];
        
        int leftPointer = 0, rightPointer = 0, resultPointer = 0;
        
        //if either list has a value
        while(leftPointer < leftHalf.length || rightPointer < rightHalf.length){
            
            //if both lists have a value
            if(leftPointer < leftHalf.length && rightPointer < rightHalf.length){
                
                if(leftHalf[leftPointer] < rightHalf[rightPointer]){
                    
                    result[resultPointer++] = leftHalf[leftPointer++];
                }
                else{
                    result[resultPointer++] = rightHalf[rightPointer++];
                }
            }
            else if(leftPointer < leftHalf.length){
                //if there are only elements in the LEFT array, merge them.
                result[resultPointer++] = leftHalf[leftPointer++];
            }
            else if(rightPointer < rightHalf.length){
                //if there are only elements in the RIGHT array, merge them.
                result[resultPointer++] = rightHalf[rightPointer++];
            }
        }
        return result;
    }
    
    
    public static void main(String[] args){
        int[] numbers = {4,6,66,2,7,89,01,-5,82,33,-4,-67,111,0};
        System.out.println(Arrays.toString(mergeSort(numbers)));
    }
    
}