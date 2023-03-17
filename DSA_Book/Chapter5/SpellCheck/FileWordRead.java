package SpellCheck;

import java.io.BufferedInputStream;
import java.io.File;

/**
 * This program is for reading words from input file
 * First open input file for reading: in = new BufferedInputStream(new
 * FileInputStream(String fileName));
 * Next create an object of class FileWord Read: FileWordRead readWords = new
 * FileWordRead(in);
 * To read a word, first check that there is a next word in file: if (
 * readWords.hasNextWord() )
 * Finally, to read a word, use: String nextWord = readWords.nextWord();
 */

public class FileWordRead {

    private BufferedInputStream in;
    private String nextWord;
    private StringBuffer buf;
    private boolean endOfFile;

    public FileWordRead(BufferedInputStream inFile) throws java.io.IOException {
        in = inFile;
        endOfFile = false;
        nextWord = readWord();
    }

    // read word
    private String readWord() throws java.io.IOException {

        int ch;
        char nextChar;
        StringBuffer buf = new StringBuffer();

        // if there is no more word in file, return null
        ch = in.read();
        if (ch == -1) {
            endOfFile = true;
            return null;
        }

        // from ascii code to character
        nextChar = Character.toLowerCase((char) ch);

        // if the character is not a letter, return null
        while (!(nextChar >= 'a' && nextChar <= 'z')) {
            ch = in.read();
            // if there is no more word in file, return null
            if (ch == -1) {
                endOfFile = true;
                return null;
            }
            nextChar = Character.toLowerCase((char) ch);
        }

        // if the character is a letter, read the word
        while (nextChar >= 'a' && nextChar <= 'z') {
            buf.append(nextChar);
            ch = in.read();
            // if there is no more word in file, return null
            if (ch == -1) {
                endOfFile = true;
                return buf.toString();
            }
            nextChar = Character.toLowerCase((char) ch);
        }
        return buf.toString();
    }

    // check if there is next word
    public boolean hasNextWord() {
        if (nextWord != null)
            return true;
        else
            return false;
    }

    public String nextWord() throws java.io.IOException {
        String word = nextWord;
        if (!endOfFile) {
            word = readWord();
        } else {
            word = null;
        }

        return word;
    }
}
