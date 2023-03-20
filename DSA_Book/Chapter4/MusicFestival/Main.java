package MusicFestival;

// https://codeforces.com/problemset/problem/1801/C

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static int compute(ArrayList<ArrayList<Integer>> a, int x) {
        int start = a.get(x).size() - 1;

        ArrayList<Integer> newArr = a.get(x);
        int currentMax = a.get(x).get(start);

        for (int i = 0; i < a.size(); i++) {
            int length = a.get(i).size();
            if (i != x && a.get(i).get(0) > currentMax) {
                start += length;
                currentMax = a.get(i).get(length - 1);
                newArr.addAll(a.get(i));
            }
        }

        for (int i = 0; i < newArr.size(); i++) {
            System.out.print(newArr.get(i) + " ");
        }
        System.out.println("result" + start + "\n");
        return start;
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

    static void solve() {
        Scanner in = new Scanner(System.in);
        int numberAlbums = in.nextInt();
        ArrayList<ArrayList<Integer>> allAlbums = new ArrayList<>();

        for (int i = 0; i < numberAlbums; ++i) {
            int numberSongs = in.nextInt();
            ArrayList<Integer> songs = new ArrayList<>();
            for (int j = 0; j < numberSongs; ++j) {
                songs.add(in.nextInt());
            }
            allAlbums.add(songs);
        }

        // resize
        ArrayList<ArrayList<Integer>> newAlbums = new ArrayList<>();
        for (int j = 0; j < numberAlbums; j++) {
            newAlbums.add(resize(allAlbums.get(j)));
        }

        for (int i = 0; i < numberAlbums; i++) {
            System.out.println("Album : ");
            for (int j = 0; j < newAlbums.get(i).size(); j++) {
                System.out.print(newAlbums.get(i).get(j) + " ");
            }
        }

        TreeMap<Integer, ArrayList<Integer>> b = new TreeMap<>();
        // int x = 0;
        for (int i = 0; i < numberAlbums; ++i) {
            for (int x : newAlbums.get(i)) {
                if (!b.containsKey(x)) {
                    System.out.println("contains" + x);
                    b.put(x, new ArrayList<>());
                }
                b.get(x).add(i);
            }
        }

        System.out.println(b);

        int[] dp = new int[numberAlbums];
        int closed = 0;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : b.entrySet()) {
            int c = entry.getKey();
            System.out.println("Testing with " + c);
            int newclosed = 0;
            for (int i : entry.getValue()) {
                if (c == newAlbums.get(i).get(newAlbums.get(i).size() - 1)) {
                    dp[i] = Math.max(dp[i] + 1, closed + 1);
                    System.out.println("new max 1:" + dp[i]);
                    newclosed = Math.max(newclosed, dp[i]);
                    continue;
                }
                if (c == newAlbums.get(i).get(0)) {
                    dp[i] = closed + 1;
                    System.out.println("new max 2:" + dp[i]);
                    continue;
                }
                dp[i] = Math.max(dp[i] + 1, closed + 1);
                System.out.println("new max end:" + dp[i]);
            }
            closed = Math.max(closed, newclosed);
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int k = 0; k < t; k++) {
            solve();
        }
    }
}
