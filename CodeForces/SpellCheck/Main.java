// package CodeForces.SpellCheck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    class Word {
        String word;
        String description;

        public Word(String word, String description) {
            this.word = word;
            this.description = description;
        }
    }

    static int hashCode(String word) {
        return Math.abs(word.hashCode());
    }

    static String ignoreIndex(String word, int index) {
        return word.substring(0, index) + word.substring(index + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // System.out.println("Enter a word1: ");
        String n = br.readLine().trim();

        // System.out.println("Enter a word2: ");
        String m = br.readLine().trim();

        int initHash = hashCode(m);

        LinkedList list = new LinkedList();

        for (int i = 0; i < n.length(); i++) {
            String newWord = ignoreIndex(n, i);
            int newHash = hashCode(newWord);

            if (newHash == initHash) {
                list.add(i + 1);
            }
        }

        if (list.getCount() < 0) {
            System.out.println("0");
        } else {
            System.out.println(list.getCount());
            list.print();
        }

    }
}
