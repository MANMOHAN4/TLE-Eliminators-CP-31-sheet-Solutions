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

            int minOp = Integer.MAX_VALUE;

            for(int index = 1; index < n; index++){
                int dif = Integer.parseInt(array[index]) - Integer.parseInt(array[index - 1]);

                if(dif < 0){
                    minOp = dif;
                    break;
                }
                else if(dif < minOp){
                    minOp = dif;
                }
            }

            if(minOp < 0){
                result.add(0);
            }
            else{
                minOp = (minOp / 2) + 1;
                result.add(minOp);
            }
            
            
        }

        for(Integer i: result){
            System.out.println(i);
        }

        
    }
}