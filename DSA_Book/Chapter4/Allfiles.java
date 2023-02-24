import java.io.*;
import java.util.Stack;

// Get all file names in a directory & subdirectory
// Approach:
// push directory to stack
// While not empty -> pop
// if what we pop is file -> print
// if what we pop is directory -> push all files in stack
// continue doing same w them

public class Allfiles {

    public static void main(String[] args) {
        // provide complete path for directory(to be changed
        // accordingly)
        String mainDir = "/Users/ayazhan/Documents/GitHub/LeetCode_Practice/Inspiration";
        // File object
        File file = new File(mainDir);
        Stack<File> s = new Stack<>();
        s.push(file);

        System.out.println("Content of directory: ");

        while (!s.isEmpty()) {
            File newF = s.pop();
            if (newF.isDirectory()) {
                // System.out.println("DIR");
                File[] files = newF.listFiles();
                for (File oneFile : files) {
                    s.push(oneFile);
                }
            } else if (newF.isFile()) {
                System.out.println(newF.getName());
            }
        }
    }
}
