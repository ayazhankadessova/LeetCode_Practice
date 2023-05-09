import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
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

        HashSet<Integer> tastes = new HashSet<>();
        generateWoks(0, toppings, toppings.length, tastes);

        if (tastes.size() <= 1) {
            out.write("YES");
        } else {
            out.write("NO");
        }

        out.flush();
        out.close();
    }

    public static void generateWoks(int wok, int[] toppings, int n, HashSet<Integer> tastes) {

        if (n == 0) {

            if (tastes.contains(wok)) {
                tastes.remove(wok);
            } else {
                tastes.add(wok);
            }
        } else {
            // Recursive case: consider adding each topping to the wok
            generateWoks(wok + toppings[n - 1], toppings, n - 1, tastes); // Add the last topping to wok

            generateWoks(wok, toppings, n - 1, tastes); // Don't add the last topping to wok
        }
    }
}
