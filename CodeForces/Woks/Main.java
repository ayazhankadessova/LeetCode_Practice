import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
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

    public static void main(String[] args) throws IOException {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = sc.nextInt();
        int[] toppings = new int[n];
        for (int i = 0; i < n; i++) {
            toppings[i] = sc.nextInt();
        }

        // if (n == 1 || n % 2 == 0) {
        // out.write("NO");
        // } else {
        // out.write("YES");
        // }

        boolean res = subsets(toppings);

        if (res == true) {
            out.write("YES");
        } else {
            out.write("NO");
        }

        out.flush();
        out.close();
    }

    public static boolean subsets(int[] nums) {
        HashSet<Integer> tastes = new HashSet<>();
        backtrack(tastes, new ArrayList<>(), nums, 0);

        return tastes.size() <= 1;

    }

    private static void backtrack(HashSet<Integer> list, List<Integer> tempList,
            int[] nums, int start) {

        int sum = tempList.stream().mapToInt(Integer::intValue).sum();
        if (list.contains(sum)) {
            list.remove(sum);
        } else {
            list.add(sum);
        }

        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

}

    hashmap

public static void generateWoks(int wok, int[] toppings, int n,
HashSet<Integer> tastes) {

if (n == 0) {

if (tastes.contains(wok)) {
tastes.remove(wok);
} else {
tastes.add(wok);
}
} else {
// Recursive case: consider adding each topping to the wok
generateWoks(wok + toppings[n - 1], toppings, n - 1, tastes); // Add the last
topping to wok

generateWoks(wok, toppings, n - 1, tastes); // Don't add the last topping to
wok
}
}
