package MusicFestival;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
        ArrayList<Integer> a1 = new ArrayList<>();
        int n = a.size();
        int mx = 0;
        for (int i = 0; i < n; ++i) {
            if (a.get(i) > mx) {
                a1.add(a.get(i));
                mx = a.get(i);
            }
        }
        return a1;
    }

    public static void main(String[] args) {
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

        int max = 0;
        for (int album = 0; album < newAlbums.size(); album++) {
            int compute = compute(newAlbums, album);
            if (compute > max) {
                max = compute;
            }
        }
        System.out.println(max);
    }
}
