
// https://codeforces.com/problemset/problem/1801/C

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    // static MyScanner sc = new MyScanner();
    public static PrintWriter out;

    // -----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader sc;
        StringTokenizer st;

        public MyScanner() {
            sc = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(sc.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
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
            String str = "";
            try {
                str = sc.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }

    static ArrayList<Integer> resize(ArrayList<Integer> a) {
        ArrayList<Integer> newAlbums = new ArrayList<>();
        int n = a.size();
        int mx = 0;
        for (int i = 0; i < n; ++i) {
            if (a.get(i) > mx) {
                newAlbums.add(a.get(i));
                mx = a.get(i);
            }
        }
        return newAlbums;
    }

    static void solve(MyScanner sc) {
        // Scanner sc = new Scanner(System.sc);

        int numberAlbums = sc.nextInt();
        ArrayList<ArrayList<Integer>> allAlbums = new ArrayList<>();

        for (int i = 0; i < numberAlbums; ++i) {
            int numberSongs = sc.nextInt();
            ArrayList<Integer> songs = new ArrayList<>();
            for (int j = 0; j < numberSongs; ++j) {
                songs.add(sc.nextInt());
            }
            allAlbums.add(songs);
        }

        // resize
        ArrayList<ArrayList<Integer>> newAlbums = new ArrayList<>();
        for (int j = 0; j < numberAlbums; j++) {
            newAlbums.add(resize(allAlbums.get(j)));
        }

        TreeMap<Integer, ArrayList<Integer>> b = new TreeMap<>();
        // int x = 0;
        for (int i = 0; i < numberAlbums; ++i) {
            for (int x : newAlbums.get(i)) {
                if (!b.containsKey(x)) {
                    b.put(x, new ArrayList<>());
                }
                b.get(x).add(i);
            }
        }

        int[] dp = new int[numberAlbums];
        int closed = 0;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : b.entrySet()) {
            int c = entry.getKey();
            // System.out.println("Testing with " + c);

            int newclosed = 0;
            for (int i : entry.getValue()) {
                if (c == newAlbums.get(i).get(newAlbums.get(i).size() - 1)) {
                    dp[i] = Math.max(dp[i] + 1, closed + 1);
                    // System.out.println("new max 1:" + dp[i]);
                    newclosed = Math.max(newclosed, dp[i]);
                    continue;
                }
                if (c == newAlbums.get(i).get(0)) {
                    dp[i] = closed + 1;
                    // System.out.println("new max 2:" + dp[i]);
                    continue;
                }
                dp[i] = Math.max(dp[i] + 1, closed + 1);
                // System.out.println("new max end:" + dp[i]);
            }
            closed = Math.max(closed, newclosed);
        }
        out.println(Arrays.stream(dp).max().getAsInt());

    }

    public static void main(String[] args) {

        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int testcases = sc.nextInt();
        // sc.close();
        while (testcases-- > 0) {
            solve(sc);
        }

        out.close();
    }

}
