// Everybody Likes Good Arrays!

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
            
            String[] array = Template.readln().split(" "); // for fast input
            int op = 0; // minimum number of operations to form a good array.

            for(int index = 0; index < n - 1; index++){
                // update the number of operations whenever the adjacent element is of same parity
                if(Long.parseLong(array[index]) % 2 == Long.parseLong(array[index + 1]) % 2){
                    op += 1;
                }
                
            }

            result.add(op);

        }

        for(Integer i: result){
            System.out.println(i);
        }
    }
}