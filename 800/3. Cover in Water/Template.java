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

        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < t; i++) {
            String[] inp = Template.readln().split(" ");
            int n = Integer.parseInt(inp[0]);

            String cells = Template.readln();
            boolean continuous = false;
            int emptyCells = 0;

            for(int j = 0; j < n; j++){
                if((cells.charAt(j) == '.') && ( j + 1 < n) && (cells.charAt(j + 1) == '.') && (j + 2 < n) && (cells.charAt(j + 2) == '.')){
                    continuous = true;
                    break;
                }

                if(cells.charAt(j) == '.'){
                    emptyCells++;
                }
            }

            if(continuous){
                result.add(2);
            }
            else{
                result.add(emptyCells);
            }
            
        }

        for(Integer i : result){
            System.out.println(i);
        }

        
    }
}