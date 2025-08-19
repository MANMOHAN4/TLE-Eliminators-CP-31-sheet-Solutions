// 29. Three Indices

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
        int n = in.nextInt();
        int[] array = in.nextIntArray(n);
        boolean isThreeIndicesFound = false;

        for (int j = 0; j < (n - 1); j++) {
            int i = 0;
            int k = j + 1;

            // Case 1
            while (i < j) {
                if (array[i] < array[j]) {
                    break;
                }
                i++;
            }

            // If case 1 is not satisfied increment j.
            if (i == j) {
                continue;
            }

            // Case 2
            while (k < n) {
                if (array[k] < array[j]) {
                    break;
                }
                k++;
            }

            // If both cases satisfied, print the answer considering the array as " 1 - indexed ".
            if (k < n) {
                isThreeIndicesFound = true;
                out.println("Yes");
                out.println((i + 1) + " " + (j + 1) + " " + (k + 1));
                break;
            }
        }

        if (!isThreeIndicesFound) {
            out.println("No");
        }

    }
}
