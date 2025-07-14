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
            int sx = Integer.parseInt(inp[0]);
            int sy = Integer.parseInt(inp[1]);
            int dx = Integer.parseInt(inp[2]);
            int dy = Integer.parseInt(inp[3]);

            if(dy < sy){
                result.add(-1);
                continue;
            }

            int moves = dy - sy;

            sx += moves;

            if(dx > sx){
                result.add(-1);
            }
            else{
                moves += sx - dx;
                result.add(moves);
            }
            
        }

        for(Integer i: result){
            System.out.println(i);
        }
    }
}