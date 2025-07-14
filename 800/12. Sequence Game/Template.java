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

        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < t; i++) {
            String[] inp = Template.readln().split(" ");
            int m = Integer.parseInt(inp[0]);
            String[] array = Template.readln().split(" ");

            List<Integer> temp = new ArrayList<>();

            temp.add(Integer.parseInt(array[0]));

            for(int j = 1; j < m; j++){
                if(Integer.parseInt(array[j]) >= Integer.parseInt(array[j - 1])){
                    temp.add(Integer.parseInt(array[j]));
                }
                else{
                    temp.add(Integer.parseInt(array[j]));
                    temp.add(Integer.parseInt(array[j]));
                }
            }

            result.add(temp);
            
        }

        for(int i = 0; i < t; i++){
            System.out.println(result.get(i).size());
            for(Integer j: result.get(i)){
                System.out.print(j + " ");
            }
        }

        
    }
}