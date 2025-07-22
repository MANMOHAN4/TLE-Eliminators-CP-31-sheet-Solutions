// 03. Vasilije in Cacak

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
        long n = in.nextLong();
        long k = in.nextLong();
        long x = in.nextLong();
        
        long s1 = (n * (n + 1)) / 2; // Sum of 'n' natural numbers
        long s2 = ((n - k) * ((n - k) + 1)) / 2; // Sum of 'n - k' natural numbers
        
        long minSum = (k * (k + 1)) / 2; // Sum of first 'k' natural numbers from 1 to n
        long maxSum = s1 - s2; // Sum of last 'k' natural numbers from 1 to n

        if(x >= minSum && x <= maxSum){
            out.println("Yes");
        }
        else{
            out.println("No");
        }
        
    }
}
