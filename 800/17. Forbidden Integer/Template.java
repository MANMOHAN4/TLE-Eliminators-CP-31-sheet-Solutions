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
        
        List<String> inputArray = new ArrayList<>();

        for(int i = 0; i < t; i++){
            String entry = Template.readln();
            inputArray.add(entry);
        }
        
        for (String str: inputArray) {
            String[] inp = str.split(" ");
            int n = Integer.parseInt(inp[0]);
            int k = Integer.parseInt(inp[1]);
            int x = Integer.parseInt(inp[2]);

            if (x != 1) { // Case 2: 1 is available
                System.out.println("YES");
                System.out.println(n);
                for (int i = 0; i < n; i++) {
                    System.out.print(1 + " ");
                }
                System.out.println();
            } else { // x == 1
                if (k == 1) { // Case 1: only 1 is available and forbidden
                    System.out.println("NO");
                } else { // x == 1 and k > 1 (Case 3)
                    if (n % 2 == 0) { // n is even
                        System.out.println("YES");
                        System.out.println(n / 2);
                        for (int i = 0; i < n / 2; i++) {
                            System.out.print(2 + " ");
                        }
                        System.out.println();
                    } else { // n is odd
                        if (k >= 3) { // 3 is available
                            System.out.println("YES");
                            System.out.println((n - 3) / 2 + 1);
                            for (int i = 0; i < (n - 3) / 2; i++) {
                                System.out.print(2 + " ");
                            }
                            System.out.print(3);
                            System.out.println();
                        } else { // k == 2, only 2 is available
                            System.out.println("NO");
                        }
                    }
                }
            }
        }
    }
}