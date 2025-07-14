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

            int consecutive = 0;
            int longestConsecutive = 0;

            for(int index = 0; index < n; index++){
                if(Integer.parseInt(array[index]) == 0){
                    consecutive += 1;
                }
                else{
                    consecutive = 0;
                }

                longestConsecutive = Math.max(longestConsecutive, consecutive);
            }

            result.add(longestConsecutive);
            
        }

        for(Integer i: result){
            System.out.println(i);
        }
    }
}