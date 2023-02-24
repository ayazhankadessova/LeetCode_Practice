// Iterative Program to get all file names in Directory and
// SubDirectory

import java.io.*;
import java.util.Stack;

// Approach:
// push directory to stack
// While not empty -> pop
// if what we pop is file -> print
// if what we pop is directory -> push all files in stack
// continue doing same w them

class GFG {
    public static void main(String[] args) {
        // provide complete path for directory(to be changed
        // accordingly)
        String mainDir = "/Users/ayazhan/Documents/GitHub/LeetCode_Practice/Inspiration";
        // File object
        File file = new File(mainDir);
        Stack<File> s = new Stack<>();
        s.push(file);
        // initially stack is not empty
        System.out.println("Content of Directory " + mainDir
                + " is");
        while (!s.empty()) {
            File tmpF = s.pop();
            // check if it is a file or not
            if (tmpF.isFile()) {
                // print file name can code here according
                // to our need
                System.out.println(tmpF.getName());
            } else if (tmpF.isDirectory()) {
                // It's an directory hence list and push all
                // files in stack
                File[] f = tmpF.listFiles();
                for (File fpp : f) {
                    s.push(fpp);
                }
            } // else if ends here
        } // stack is not empty loop ends here
    } // main function ends here
}
