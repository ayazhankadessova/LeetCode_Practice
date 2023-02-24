import java.io.*;

// Approach:1. Start listing with depth 0 2. Print name->if dir:dir+name;if file:fileName+length 3. check if directory:if dir->repeat same for every file in dir

class FileSystem {

    private void list(File f) {
        list(f, 0);
    }

    private void list(File f, int depth) {

        // start listing with current
        // check if current is a directory
        // if yes -> list every files inside with depth + 1 (will check if those file in
        // their turn are dirs

        printName(f, depth);

        if (f.isDirectory()) {
            File[] files = f.listFiles();
            for (File file : files) {
                list(file, depth + 1);
            }
        }
    }

    private void printName(File file, int depth) {
        String name = file.getName();
        // deeper -> more - from the left side
        for (int i = 0; i < depth; i++) {
            System.out.print("-");
        }
        // if f directory -> print dir and name
        // if file -> name and length
        if (file.isDirectory()) {
            System.out.println("Directory: " + name);
        } else {
            System.out.println("Name: " + name + " Size: " + file.length());
        }
    }

    public static void main(String args[]) {
        FileSystem L = new FileSystem();
        File f = new File("/Users/ayazhan/Documents/GitHub/LeetCode_Practice/Inspiration");
        System.out.println(f);
        L.list(f);
    }
}