// 10. Odd Queries

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

    private static int gcd(int n1, int n2) {
        while (n1 != 0 && n2 != 0) {
            if (n1 > n2) {
                n1 = n1 % n2;
            } else {
                n2 = n2 % n1;
            }
        }

        if (n1 == 0) {
            return n2;
        } else {
            return n1;
        }
    }

    // Solution
    static void solve(FastReader in, PrintWriter out) {
        int n = in.nextInt();
        int q = in.nextInt();

        long[] array = in.nextLongArray(n);

        // prefix sum
        for (int i = 1; i < n; i++) {
            array[i] += array[i - 1];
        }

        while (q > 0) {
            int l = in.nextInt();
            int r = in.nextInt();
            long k = in.nextLong();

            // Since, array follows '0' based indexing
            l -= 1;
            r -= 1;

            long sum = array[n - 1];

            if (l == 0) {
                sum -= (array[r]);
            } else {
                sum -= (array[r] - array[l - 1]);
            }

            sum += ((r - l + 1) * k);

            if (sum % 2 == 0) {
                out.println("No");
            } else {
                out.println("Yes");
            }

            q--;
        }

    }
}
