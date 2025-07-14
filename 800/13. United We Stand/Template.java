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

        List<List<Integer>> inputArrays = new ArrayList<>();
        
        for (int i = 0; i < t; i++) {
            String[] inp = Template.readln().split(" ");
            int n = Integer.parseInt(inp[0]);
            String[] array = Template.readln().split(" ");

            List<Integer> temp = new ArrayList<>();

            for(int j = 0; j < n; j++){
                temp.add(Integer.parseInt(array[j]));
            }

            inputArrays.add(temp);
        }

        for(int index = 0; index < t; index++){
            List<Integer> temp = new ArrayList<>(inputArrays.get(index));
            int n = inputArrays.get(index).size();

            int max = Collections.max(temp);

            List<Integer> b = new ArrayList<>();
            List<Integer> c = new ArrayList<>();

            for(int i = 0; i < n; i++){
                
                if(temp.get(i) == max){
                    c.add(temp.get(i));
                }
                else{
                    b.add(temp.get(i));
                }
            }

            
            if(b.size() == 0){
                System.out.println(-1);
            }
            else{
                System.out.println(b.size() + " " + c.size());
                for(Integer ele: b){
                    System.out.print(ele + " ");
                }

                System.out.println();

                for(Integer ele: c){
                    System.out.print(ele + " ");
                }
            }
        }

        
    }
}