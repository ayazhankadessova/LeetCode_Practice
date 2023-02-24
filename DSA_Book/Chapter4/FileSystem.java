class FileSystem {

    Node root;

    class Node {
        Node firstChild;
        Node NextSibling;
        String value;

        Node(String value) {
            this.value = value;
        }
    }

    // String : 'usr/bin'

    public void insert(String value) {
        String[] stringArray = value.split("/");
        String name = stringArray[stringArray.length - 1];
        Node newNode = new Node(name);
        if (root == null) {
            root = newNode;
            System.out.println("insertHere: " + root.value);
        } else {
            Node current = root;
            for (int i = 0; i < stringArray.length - 1; i++) {
                Node insertHere;
                if (current.firstChild != null) {
                    System.out.println("insertHere: " + current.firstChild);
                    insertHere = dfs(current.firstChild, stringArray[i]);
                    if (insertHere == null) {
                        while (current.firstChild.NextSibling != null) {
                            current = current.firstChild.NextSibling;
                        }
                        current.firstChild.NextSibling = newNode;

                    }

                }
            }
        }
    }

    public Node dfs(Node firstChild, String parent) {
        if (firstChild.value.compareTo(parent) == 0) {
            return firstChild;
        }
        while (firstChild.NextSibling != null) {

            if (firstChild.NextSibling.value.compareTo(parent) == 0) {
                return firstChild.NextSibling;
            }
        }
        return null;
    }

    public FileSystem() {
        root = null;
    }

    public static void main(String[] args) {
        FileSystem files = new FileSystem();
        files.insert("usr");
        files.insert("usr/bin");
    }
}