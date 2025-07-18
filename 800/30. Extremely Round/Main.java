// 30. Extremely Round
// Note: This is the Optimal Solution
// Gentle Remainder: Don't overwhelm by seeing the code. The logic is simple. Just understand it with the help of comments

import java.io.*;
import java.util.*;

public class Main {

    // FastReader class for fast input
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { throw new RuntimeException(e); }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            try { return br.readLine(); }
            catch (IOException e) { throw new RuntimeException(e); }
        }

        int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        char[] nextCharArray() {
            return next().toCharArray();
        }
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        while (t-- > 0) {
            solve(in, out);
        }

        out.flush();
    }

    // Solution
    static void solve(FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int leftmostDigit = 0;
        int placeValue = 0;
        int x = 0; // required answer (i.e the number of extremely round integers)

        while(n > 0){
            if(n < 10){
                leftmostDigit = n;
            }

            placeValue += 1;
            n /= 10;
        }

        switch (placeValue) {

            case 1: // Ones Place
                // if n < 10 there exists 'n' extremely round
                x = leftmostDigit;
                break;

            case 2: // Tens Place
                // if n <= 100
                x = 10; // there exists (1 to 10) extremely round
                x += (leftmostDigit - 1); // along with (leftmostDigit - 1) extremely round
                break;
                
                case 3: // Hundresds Place
                // if n <= 1000
                x = (10 + 9); // there exists ((1 to 10) + (20, 30, 40, ... 100)) extremely round
                x += (leftmostDigit - 1); // along with (leftmostDigit - 1) extremely round
                break;
                
                case 4: // One Thousands Place
                // if n <= 10000
                x = (10 + 9 + 9); // there exists ((1 to 10) + (20, 30, 40, ... 100) + (200, 300, 400, ... 1000)) extremely round
                x += (leftmostDigit - 1); // along with (leftmostDigit - 1) extremely round
                break;

            case 5: // Ten Thousands Place
                x = (10 + 9 + 9 + 9); // there exists ((1 to 10) + (20, 30, 40, ... 100) + (200, 300, 400, ... 1000) + (2000, 3000, 4000, ... 10000)) extremely round
                x += (leftmostDigit - 1); // along with (leftmostDigit - 1) extremely round
                break;

            case 6: // Hundred Thousands Place
                x = (10 + 9 + 9 + 9 + 9); // there exists ((1 to 10) + (20, 30, 40, ... 100) + (200, 300, 400, ... 1000) + (2000, 3000, 4000, ... 10000) + (20000, 30000, 40000, ... 100000)) extremely round
                x += (leftmostDigit - 1); // along with (leftmostDigit - 1) extremely round
                break;

            default:
                break;
        }

        out.println(x);
    }
}
