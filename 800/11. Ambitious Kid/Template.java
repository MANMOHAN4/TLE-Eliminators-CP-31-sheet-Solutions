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

        String[] inp = Template.readln().split(" ");
        int n = Integer.parseInt(inp[0]);

        String[] array = Template.readln().split(" ");

        int ans = Math.abs(Integer.parseInt(array[0]));

        for (int i = 1; i < n; i++) {

            int ele = Math.abs(Integer.parseInt(array[i]));

            if(ele == 0){
                ans = 0;
                break;
            }
            else{
                ans = Math.min(ans, ele);
            }
            
        }

        System.out.println(ans);

        
    }
}