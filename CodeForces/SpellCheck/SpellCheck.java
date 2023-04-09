// package CodeForces.SpellCheck;

import java.util.Scanner;

// package CodeForces.SpellCheck;

public class SpellCheck {

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
        // System.out.println(word.substring(0, index));
        // System.out.println(word.substring(index + 1));
        return word.substring(0, index) + word.substring(index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word1: ");

        String n = sc.nextLine().trim();

        System.out.println("Enter a word2: ");

        String m = sc.nextLine();

        int initHash = hashCode(m);

        // System.out.println("Init hash: " + initHash);

        LinkedList list = new LinkedList();

        // sc.nextLine();
        // String[] descriptions = new String[n];
        for (int i = 0; i < n.length(); i++) {

            String newWord = ignoreIndex(n, i);

            int newHash = hashCode(newWord);

            // System.out.println("New hash: " + newHash);

            // System.out.println("Trial" + i + 1);
            // System.out.println("Word: " + newWord);

            if (newHash == initHash) {
                // System.out.println("Word matches: " + newWord);
                list.add(i + 1);
                // System.out.println("Description: " + "Ignore " + n.charAt(i));
            }

        }

        System.out.println(list.getCount());
        list.print();
        // String[] input = new String[m];
        // for (int i = 0; i < m; i++) {
        // input[i] = sc.next();
        // }
        // sc.close();
        // SpellCheck spellCheck = new SpellCheck();
        // spellCheck.solve(words, descriptions, input);
    }

}
