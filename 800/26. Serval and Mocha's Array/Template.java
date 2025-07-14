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

    private static int gcd(int num1, int num2){
        while(num1 != 0 && num2 != 0){
            if(num1 > num2){
                num1 %= num2;
            }else{
                num2 %= num1;
            }
        }

        if(num1 == 0){
            return num2;
        }else{
            return num1;
        }
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
            
            String[] array = Template.readln().split(" ");

            // flag variable to find whether the gcd <= 2 has found
            boolean flag = false;
            
            for(int index = 0; index < n; index++){
                for(int j = index + 1; j < n; j++){
                    if(gcd(Integer.parseInt(array[index]), Integer.parseInt(array[j])) <= 2){
                        flag = true;
                        break;
                    }
                }
            }

            if(flag){
                result.add("Yes");
            }
            else{
                result.add("No");
            }
        }

        for(String str: result){
            System.out.println(str);
        }

        
    }
}