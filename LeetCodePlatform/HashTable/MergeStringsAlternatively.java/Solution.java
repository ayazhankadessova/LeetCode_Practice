import java.io.*;
import java.util.*;

// hash based on index
// add one that is not exhausted

class Solution {
    public String mergeAlternately(String word1, String word2) {

        String[] w1 = word1.split("");
        String[] w2 = word2.split("");

        Hashtable<Integer, String> numbers = new Hashtable<Integer, String>();

        int i = 0;
        int j = 0;
        while (i < w1.length && i < w2.length) {

            numbers.put(j, w1[i]);
            numbers.put(++j, w2[i]);
            i++;
            j++;
        }
        while (i < w1.length) {
            numbers.put(j, w1[i]);
            i++;
            j++;
        }

        while (i < w2.length) {
            numbers.put(j, w2[i]);
            i++;
            j++;
        }

        String res = "";
        for (int k = 0; k < (w1.length + w2.length); k++) {
            res += numbers.get(k);
            System.out.print(numbers.get(k));
        }

        return res;
    }
}