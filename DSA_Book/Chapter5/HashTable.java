// package DSA_Book.Chapter5;

// Creating HashTable with 
public class HashTable {
    int[] HashTable = new int[10];
    // LinkedList<Word>[] SepChainHashTable;
    DataStructure dataStru;
    int numSearched = 0;

    // Create a new Hashtable with probing type and array of Eord objects
    public HashTable(DataStructure dataStru, int[] Numbers) {
        this.dataStru = dataStru;
        switch (dataStru) {
            case LinProb:
                LinProbCreate(Numbers);
                break;
            case QuadProb:
                // QuadProbCreate(dictionary);
                break;
            case SepChain:
                // SepChainCreate(dictionary);
                break;
            case DoubleHash:
                // DoubleHashCreate(dictionary);
                break;
        }
    }

    public enum DataStructure {
        LinProb, QuadProb, SepChain, DoubleHash
    }

    // Create a new Hashtable with linear probing
    /**
     * 1. Iterate through every item
     * 2. Initialize notplaced to be true
     * 3. If the slot is empty, place item, make notplaced false
     * 4. If the item is not placed, place it in the next available slot while
     * notplaced is true
     * 5. If the item is not placed, increment the number of collisions
     */
    public void LinProbCreate(int[] Numbers) {
        int collisions = 0;
        // HashTable = new int[10];
        for (int number : Numbers) {
            int place = 0;
            place = HashFunction(number);
            boolean notPlaced = true;

            while (notPlaced) {
                if (HashTable[place % HashTable.length] == 0) {
                    HashTable[place % HashTable.length] = number;
                    notPlaced = false;
                } else {
                    place++;
                    collisions++;
                    System.out.println("Collision with " + number);
                }
            }
        }
        System.out.println("Number of collisions: " + collisions);
    }

    // Search in a Hashtable with linear probing
    private int LinProbSearch(int number) {
        int place = 0;
        place = HashFunction(number);
        boolean notfound = true;

        int num = 0;

        while (notfound) {
            numSearched++;
            if (HashTable[place % HashTable.length] != 0) {
                if (HashTable[place % HashTable.length] == number) {
                    num = HashTable[place % HashTable.length];
                    notfound = false;
                    return num;
                } else {
                    place++;
                }
            } else {
                return 0;
            }
        }
        return 0;
    }

    private int HashFunction(int number) {
        return number % HashTable.length;
    }

    public static void main(String[] args) {
        int[] Numbers = { 4371, 1323, 6173, 4199, 4344, 9679, 1989 };
        HashTable ht = new HashTable(DataStructure.LinProb, Numbers);
        // System.out.println(ht.LinProbSearch(1));
        // System.out.println(ht.numSearched);

        for (int i = 0; i < ht.HashTable.length; i++) {
            System.out.println(ht.HashTable[i]);
        }
    }
}
