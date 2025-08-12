// 20. AB Balance

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
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
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

    private static int minOperations(String number, String possibleValue) {
        int operations = 0;
        int checkerIndex = possibleValue.length() - 1;
        int n = number.length() - 1;

        for (int i = n; i >= 0; i--) {
            if (number.charAt(i) == possibleValue.charAt(checkerIndex)) {
                checkerIndex--;
                if (checkerIndex < 0) {
                    break;
                }
            } else {
                operations++;
            }
        }

        if (checkerIndex >= 0) {
            operations = Integer.MAX_VALUE;
        }
        return operations;
    }

    static void solve(FastReader in, PrintWriter out) {
        String numberString = in.nextLine();
        int ans = Integer.MAX_VALUE;
        String[] possibleValues = { "00", "25", "50", "75" };

        for (String possibleValue : possibleValues) {
            ans = Math.min(ans, minOperations(numberString, possibleValue));
        }

        out.println(ans);

    }
}
