// 1. Forked!

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

    // global arrays
    static int[] dx = {-1, 1, -1, 1};
    static int[] dy = {-1, -1, 1, 1};

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
        long a = in.nextLong();
        long b = in.nextLong();

        long xKing = in.nextLong();
        long yKing = in.nextLong();

        long xQueen = in.nextLong();
        long yQueen = in.nextLong();

        Set<String> kingHits = new HashSet<>();
        Set<String> queenHits = new HashSet<>();

        for(int i = 0; i < 4; i++){
            kingHits.add((xKing + dx[i] * a) + "," + (yKing + dy[i] * b));
            kingHits.add((xKing + dx[i] * b) + "," + (yKing + dy[i] * a));

            queenHits.add((xQueen + dx[i] * a) + "," + (yQueen + dy[i] * b));
            queenHits.add((xQueen + dx[i] * b) + "," + (yQueen + dy[i] * a));
        }

        int ans = 0;
        for(String pos: kingHits){
            if(queenHits.contains(pos)){
                ans++;
            }
        }

        out.println(ans);

    }
}
