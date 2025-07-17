// 28. Make it Beautiful

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> inputArrays = new ArrayList<>();
        
        int t = sc.nextInt();
        
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            List<Integer> array = new ArrayList<>();

            
            // Input array of integers
            for(int index = 0; index < n; index++){
                array.add(sc.nextInt());
            }

            // Add the input array ArrayList
            inputArrays.add(array);
        }

        for (List<Integer> array : inputArrays) {
            int n = array.size();
            Collections.sort(array);

            // Case 1: All elements are same (i.e minNumber == maxNumber)
            if(array.get(0) == array.get(n - 1)){
                System.out.println("No");
            }
            // Case 2: minNumber not equal to maxNumber
            else{
                System.out.println("Yes");

                // First print the maxNumber
                System.out.print(array.get(n - 1) + " ");

                // Then print remaining elements except maxNumber
                for(int i = 0; i < n - 1; i++){
                    System.out.print(array.get(i) + " ");
                }

                // Next Line
                System.out.println();
            }
        }
    }
}