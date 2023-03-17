import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

public class Spell {

    public static HashDictionary dictionary;
    // public static ListDictionary dictionary;

    public Spell() {
        StringHashCode sH = new StringHashCode();
        dictionary = new HashDictionary(sH, (float) 0.75);
        // dictionary = new ListDictionary();
    }

    /**
     * Take a word and replace every letter with every letter from
     * the alphabet.
     * 
     * @param word
     * @param suggested
     * @return - A list of new words
     */
    public static LinkedList<String> subLetter(String word, LinkedList<String> words) {

        char letter = 'a';
        String newWord = "";

        StringBuffer buffer = new StringBuffer(word);

        // Try to replace every letter in the word with another letter to make a new
        // letter
        for (int i = 0; i < word.length(); i++) {
            for (letter = 'a'; letter <= 'z'; letter++) {

                newWord = buffer.replace(i, i + 1, String.valueOf(letter)).toString();

                if (dictionary.find(newWord)) {
                    if (!words.contains(newWord)) {
                        words.add(newWord);
                    }
                }
                // Reset buffer
                buffer = new StringBuffer(word);
            }
        }

        return words;
    }

    public static LinkedList<String> omitLetter(String word, LinkedList<String> words) {

        String newWord = "";

        StringBuffer buffer = new StringBuffer(word);
        for (int i = 0; i < word.length(); i++) {
            newWord = buffer.delete(i, i + 1).toString();

            if (dictionary.find(newWord)) {
                if (!words.contains(newWord)) {
                    words.add(newWord);
                }
            }
            // Reset buffer
            buffer = new StringBuffer(word);
        }
        return words;
    }

    /**
     * Try inserting a letter at every position to make a new word
     * 
     * @param word
     * @param suggested
     * @return
     */
    public static LinkedList<String> insertLetter(String word, LinkedList<String> words) {

        String newWord = "";

        StringBuffer buffer = new StringBuffer(word);
        for (int i = 0; i < word.length(); i++) {
            for (char letter = 'a'; letter <= 'z'; letter++) {
                newWord = buffer.insert(i, letter).toString();

                if (dictionary.find(newWord)) {
                    if (!words.contains(newWord)) {
                        words.add(newWord);
                    }
                }

                // Reset buffer
                buffer = new StringBuffer(word);
            }
        }
        return words;
    }

    /**
     * Swap every adjacent letter in turn to make a new word
     * 
     * @param word
     * @param suggested
     * @return
     */
    public static LinkedList<String> swapLetter(String word, LinkedList<String> words) {

        String newWord = "";

        StringBuffer buffer = new StringBuffer(word);
        StringBuffer toSwap = new StringBuffer();

        for (int i = 0; i < word.length() - 1; i++) {
            toSwap = new StringBuffer(buffer.substring(i, i + 2)).reverse();
            buffer.delete(i, i + 2);
            newWord = buffer.insert(i, toSwap).toString();

            if (dictionary.find(newWord)) {
                if (!words.contains(newWord)) {
                    words.add(newWord);
                }
            }

            // Reset buffer
            buffer = new StringBuffer(word);
        }
        return words;

    }

    public static void main(String[] args) throws java.io.IOException {

        long startTime = System.currentTimeMillis();
        long endTime;
        int time;
        Spell spell = new Spell();

        if (args.length != 2) {
            System.out.println("Usage: spell dictionaryFile.txt inputFile.txt ");
            System.exit(0);
        }

        BufferedInputStream file = null, dict = null;
        FileWordRead wordReader;

        try {

            dict = new BufferedInputStream(new FileInputStream(args[0]));
            file = new BufferedInputStream(new FileInputStream(args[1]));
            // To read from specific files, comment the 2 lines above and
            // uncomment 2 lines below
            // dict = new BufferedInputStream(new
            // FileInputStream("C:\\dictionary.txt"));
            // file = new BufferedInputStream(new
            // FileInputStream("C:\\checkText.txt"));

        } catch (IOException e) { // catch exceptions caused by file
                                  // input/output errors
            System.out.println("Check your file name");
            System.exit(0);
        }

        wordReader = new FileWordRead(dict);

        while (wordReader.hasNextWord()) {
            try {
                dictionary.insert(wordReader.nextWord().toLowerCase());
            } catch (DictionaryException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        wordReader = new FileWordRead(file);
        String word = "";
        LinkedList<String> suggested = new LinkedList<String>();
        Iterator<String> it;
        boolean first = true;

        while (wordReader.hasNextWord()) {

            word = wordReader.nextWord().toLowerCase();
            if (!dictionary.find(word)) {
                first = true;

                suggested = new LinkedList<String>();
                System.out.print(word + " => ");

                suggested = (subLetter(word, suggested));
                suggested = (omitLetter(word, suggested));
                suggested = (insertLetter(word, suggested));
                suggested = (swapLetter(word, suggested));

                it = suggested.iterator();

                if (!suggested.isEmpty()) {
                    while (it.hasNext()) {
                        if (first) {
                            System.out.print(it.next());
                            first = false;
                        } else {
                            System.out.print(", " + it.next());
                        }
                    }
                } else {
                    System.out.print("Could not find word in dictionary");
                }
                System.out.println("");
            }
        }

        endTime = System.currentTimeMillis();
        time = (int) (endTime - startTime);

        System.out.println("\nProgram took " + time + "ms to complete.");

    }
}
