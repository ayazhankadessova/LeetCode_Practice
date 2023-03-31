
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

        // System.out.println("Input length of string: ");
        int length = sc.nextInt();
        // System.out.println("Input word: ");
        String s = sc.nextLine();
        int Combinations = 1;
        Character current = s.charAt(0);
        int count = 1;
        // ArrayList<ArrayList<Integer>> allAlbums = new ArrayList<>();

        for (int i = 1; i < length; ++i) {
            char newCurrent = s.charAt(i);
            if (current.equals(newCurrent) && count > 2) {
                continue;
            } else {
                if (i > 2) {
                    Combinations++;
                }
                if (current.equals(newCurrent)) {
                    count++;
                } else if (!current.equals(newCurrent)) {
                    current = newCurrent;
                    count = 1;
                }
            }
        }
        out.println(Combinations);

    }

    public static void main(String[] args) {

        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        // System.out.println("Input test cases: ");

        int testcases = sc.nextInt();
        // sc.close();
        while (testcases-- > 0) {
            solve(sc);
        }

        out.close();
    }

}
