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

            int x = 0;
            
            for(int index = 0; index < n; index++){
                x ^= Integer.parseInt(array[index]);
            }

            int ans = 0;

            for(int index = 0; index < n; index++){
                ans ^= (x ^ Integer.parseInt(array[index]));
            }

            if(ans == 0){
                result.add(x);
            }
            else{
                result.add(-1);
            }
            
        }

        for(Integer i: result){
            System.out.println(i);
        }
    }
}