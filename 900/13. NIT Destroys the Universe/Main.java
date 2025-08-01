// 13. NIT Destroys the Universe

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
        long[] array = in.nextLongArray(n);

        int numOfSegments = 0;
        boolean insideSegment = false;
        int index = -1;

        // Find the index of the first non-zero (+ve) integer
        for (int i = 0; i < n; i++) {
            if (array[i] != 0) {
                index = i;
                break;
            }
        }

        // Count the number of segments that has no zero in-between
        if (index > -1) {
            for (int i = index; i < n; i++) {
                if (array[i] != 0) {
                    if (!insideSegment) {
                        numOfSegments += 1;
                        insideSegment = true;
                        if (numOfSegments == 2) {
                            break;
                        }
                    }
                } else {
                    insideSegment = false;
                }
            }
        }

        out.println(numOfSegments);

    }
}
