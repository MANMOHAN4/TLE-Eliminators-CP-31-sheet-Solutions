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
        
        List<String> inputArray = new ArrayList<>();

        for(int i = 0; i < t; i++){
            String entry = Template.readln();
            inputArray.add(entry);
        }
        
        for (String str: inputArray) {
            String[] inp = str.split(" ");
            int x = Integer.parseInt(inp[0]);
            int k = Integer.parseInt(inp[1]);

            if(x % k != 0){
                System.out.println(1);
                System.out.println(x);
            }
            else{
                x--;
                System.out.println(2);
                System.out.print(x + " ");
                System.out.println(1);
            }
        }
    }
}