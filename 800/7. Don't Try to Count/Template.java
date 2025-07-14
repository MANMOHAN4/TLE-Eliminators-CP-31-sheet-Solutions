import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class Template
{
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static String readln() throws IOException
    {
        String line = input.readLine();
        return line;
    }

    private static boolean checks(String s, String x){
        if(x.length() < s.length()){
            return false;
        }

        for(int i = 0; i < (x.length() - s.length() + 1); i++){
            if(x.substring(i, i + s.length()).equals(s)){
                return true;
            }
        }

        return false;
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
            int m = Integer.parseInt(inp[1]);
            
            String x0 = Template.readln();
            String s = Template.readln();

            String x1 = x0 + x0;
            String x2 = x1 + x1;
            String x3 = x2 + x2;
            String x4 = x3 + x3;
            String x5 = x4 + x4;

            int ans = -1;

            if(checks(s, x0)){
                ans = 0;
            }
            else if(checks(s, x1)){
                ans = 1;
            }
            else if(checks(s, x2)){
                ans = 2;
            }
            else if(checks(s, x3)){
                ans = 3;
            }
            else if(checks(s, x4)){
                ans = 4;
            }
            else if(checks(s, x5)){
                ans = 5;
            }

            result.add(ans);
            
        }

        for(Integer i: result){
            System.out.println(i);
        }

        
    }
}