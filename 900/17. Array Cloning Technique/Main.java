// 17. Array Cloning Technique

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

        /*
         * Sort the array. So that it helps us to find the most frequently occurred
         * element at T(c) -> O(n). As, equal elements are consecutive to each other
         */
        Arrays.sort(array);

        // initialization
        int maxOccurrence = 1;
        long maxOccurred = array[0];
        int freq = 1;

        // Find frequency of the most frequently occurred element
        for (int i = 1; i < n; i++) {
            if (array[i] == maxOccurred) {
                freq += 1;
            } else {
                freq = 1;
                maxOccurred = array[i];
            }
            maxOccurrence = Math.max(freq, maxOccurrence);
        }

        /*
         * Note: The below code(logic) don't alter the array as we are not asked to
         * print the array. We are supposed to find only the minimal number of
         * operations needed to create at least one copy where all elements are equal.
         */

        int cloneOp = 0; // Number of clone operations performed
        int swapOp = 0; // Number of swap operations performed

        // While all elements of the array are not equal
        while (maxOccurrence < n) {

            // There is a need to clone the array
            cloneOp += 1;

            // The number of elements that are required to make all elements equal
            int req = (n - maxOccurrence);

            /*
             * Case 1: If number of equal elements available in the clone is greater than
             * elements that are required to make all elements equal
             */
            if (maxOccurrence > req) {
                // Swap only elements that are required to make all elements equal.
                swapOp += req;
                // Update the number of equal elements available.
                maxOccurrence += req;
            }
            /*
             * Case 2: If number of equal elements available in the clone is not greater
             * than elements that are required to make all elements equal
             */
            else {
                // Swap the elements that are available in the cloned array.
                swapOp += maxOccurrence;
                // Update the number of equal elements available.
                maxOccurrence += maxOccurrence;
            }
        }

        /*
         * Print the minimal number of operations needed to create at least one copy
         * where all elements are equal.
         */
        out.println(cloneOp + swapOp);
    }
}
