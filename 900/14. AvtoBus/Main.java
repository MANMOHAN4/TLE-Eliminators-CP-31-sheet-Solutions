// 14. AvtoBus

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
    static void solve(FastReader in, PrintWriter out) {
        long n = in.nextLong();
        long ans = -1;
        long min = -1;
        long max = -1;

        if (n >= 4 && n % 2 == 0) {
            // Minimum possible buses
            if (n % 6 == 0) {
                min = n / 6;
            } else {
                long num = n;
                long twoAxelsBus = 0;
                while (num % 6 != 0) {
                    num -= 4;
                    twoAxelsBus += 1;
                }

                min = ((num / 6) + twoAxelsBus);
            }
            // Maximum possible buses
            if (n % 4 == 0) {
                max = n / 4;
            } else {
                long num = n;
                long threeAxelsBus = 0;
                while (num % 4 != 0) {
                    num -= 6;
                    threeAxelsBus += 1;
                }

                max = ((num / 4) + threeAxelsBus);
            }

            out.print(min + " " + max);

        } else {
            out.print(ans);
        }

        out.println();
    }
}
