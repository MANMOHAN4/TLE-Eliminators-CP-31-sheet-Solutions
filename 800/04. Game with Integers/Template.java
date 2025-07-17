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

        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < t; i++) {
            String[] inp = Template.readln().split(" ");
            int n = Integer.parseInt(inp[0]);

            if( (n - 1) % 3 == 0 || (n + 1) % 3 == 0){
                result.add("First");
            }
            else if( n % 3 == 0){
                result.add("Second");
            }
            
        }

        for(String str: result){
            System.out.println(str);
        }

        
    }
}