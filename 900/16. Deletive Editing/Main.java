// 16. Deletive Editing

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
        String s = in.next();
        String t = in.next();

        String ans = "";

        // to handle when the character in the 't' appears more than once
        boolean[] visited = new boolean[s.length()];

        // Iterate from the rear side of the string 't'
        for (int i = t.length() - 1; i >= 0; i--) {
            // Iterate from the rear side of the string 's' untill we find the character
            // from string 't'
            for (int index = s.length() - 1; index >= 0; index--) {
                // Once we find the character that is not visited, mark it as visited
                if (t.charAt(i) == s.charAt(index) && !visited[index]) {
                    visited[index] = true;
                    break;
                }
            }
        }

        // Group all the characters that are marked as visited to form a string
        for (int i = 0; i < s.length(); i++) {
            if (visited[i]) {
                ans += s.charAt(i);
            }
        }

        // If the ans and the initial word (i.e sting 't') are same: o/p -> Yes
        if (t.equals(ans)) {
            out.println("Yes");
        } else {
            out.println("No");
        }

    }
}
