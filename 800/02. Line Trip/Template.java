import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Collections;
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
            int x = Integer.parseInt(inp[1]);
            List<Integer> array = new ArrayList<>();

            String[] entries = Template.readln().split(" ");
            for(String str: entries){
                array.add(Integer.parseInt(str));
            }
        
            int max = Math.max( array.get(0), 2 * (x - array.get(n - 1)));

            for(int k = 1; k < n; k++){
                max = Math.max(max, (array.get(k) - array.get(k - 1)));
            }

            result.add(max);
            
        }

        for(Integer i: result){
            System.out.println(i);
        }
        
    }
}