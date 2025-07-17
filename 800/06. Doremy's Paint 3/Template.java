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

        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < t; i++) {
            String[] inp = Template.readln().split(" ");
            int n = Integer.parseInt(inp[0]);
            
            String[] nums = Template.readln().split(" ");

            LinkedHashMap<Integer, Integer> hashMap = new LinkedHashMap<>();

            for(String s: nums){
                int key = Integer.parseInt(s);

                if(hashMap.containsKey(key)){
                    int currentValue = hashMap.get(key);
                    hashMap.put(key, currentValue + 1);
                }
                else{
                    hashMap.put(key, 1);
                }
            }

            if(hashMap.size() > 2){
                result.add("No");
            }
            else{
                // Get first value
                int freq1 = hashMap.values().stream().findFirst().orElse(null);

                // Get last value
                int freq2 = hashMap.values().stream().reduce((first, second) -> second).orElse(null);

                if(freq1 == freq2){
                    result.add("Yes");
                }
                else if(n % 2 == 1 && Math.abs(freq1 - freq2) == 1){
                    result.add("Yes");
                }
                else{
                    result.add("No");
                }
            }
            
        }

        for(String str: result){
            System.out.println(str);
        }

        
    }
}