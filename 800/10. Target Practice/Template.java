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
        
        for (int k = 0; k < t; k++) {
            
            int points = 0;

            for(int i = 1; i <= 10; i++){
                String inp = Template.readln();

                for(int j = 1; j <= 10; j++){
                    if(inp.charAt(j - 1) == 'X'){
                        int row = i;
                        int col = j;

                        if(i > 5){
                            row = 10 - i +1;
                        }

                        if(j > 5){
                            col = 10 - j +1;
                        }

                        points += Math.min(row, col);
                    }
                }
            }

            result.add(points);
    }

    for(Integer i: result){
        System.out.println(i);
    }
}

}