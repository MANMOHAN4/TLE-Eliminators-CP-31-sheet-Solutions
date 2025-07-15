// 27. One and Two

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ArrayList;
import java.util.List;

public class Template
{
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static String readln() throws IOException
    {
        String line = input.readLine();
        return line;
    }

    public static void main(String[] args) throws IOException
    {
        Locale.setDefault(Locale.US);

        String input = Template.readln();
        int t = Integer.parseInt(input); // number of test cases

        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < t; i++) {
            String[] inp = Template.readln().split(" ");
            int n = Integer.parseInt(inp[0]);
            
            String[] array = Template.readln().split(" ");

            // To store the occurence of 2 in the array
            int freq = 0;

            // Iterate through the array once to find the occurrence of 2
            for(int index = 0; index < n; index++){
                if(Integer.parseInt(array[index]) == 2){
                    freq++;
                }
            }

            // Case 1: If 2 does not exist in the array
            if(freq == 0){
                result.add(1);
            }
            // Case 2: Even number of 2 exists in the array
            else if(freq % 2 == 0){
                int required = freq / 2;
                int index = 0;

                while(required > 0){
                    if(Integer.parseInt(array[index]) == 2){
                        required--;
                    }
                    index++;
                }

                result.add(index);
            }
            // Case 3: Odd number of 2 exists in the array which results in unequal products
            else{
                result.add(-1);
            }

            
        }

        for(Integer i: result){
            System.out.println(i);
        }
    }
}