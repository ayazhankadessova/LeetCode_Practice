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
                QuadraticProbCreate(Numbers);
                break;
            case SepChain:
                // SepChainCreate(dictionary);
                break;
            case DoubleHash:
                DoubleHashCreate(Numbers);
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
                    System.out.println("Found " + number + " at " + place);
                    return place % HashTable.length;
                } else {
                    place++;
                }
            } else {
                return 0;
            }
        }
        return 0;
    }

    // Create a new Hashtable with linear probing
    /**
     * 1. Iterate through every item
     * 2. Initialize notplaced to be true
     * 3. If the slot is empty, place item, make notplaced false
     * 4. If the item is not placed, place it in the + i^2 slot while notplaced is
     * true
     * 5. If the item is not placed, increment the number of collisions
     */
    public void QuadraticProbCreate(int[] Numbers) {
        int collisions = 0;
        // HashTable = new int[10];
        for (int number : Numbers) {
            int place = 0;
            int i = 1;
            int Initialplace = HashFunction(number);
            boolean notPlaced = true;

            if (HashTable[Initialplace % HashTable.length] == 0) {
                HashTable[Initialplace % HashTable.length] = number;
                notPlaced = false;
            } else {
                while (notPlaced) {
                    place = Initialplace + (int) Math.pow(i, 2);
                    collisions++;
                    System.out.println("Collision with " + number);
                    if (HashTable[place % HashTable.length] == 0) {
                        HashTable[place % HashTable.length] = number;
                        notPlaced = false;
                        break;
                    } else {
                        i++;
                    }
                }

            }

        }
        System.out.println("Number of collisions: " + collisions);
    }

    // Search in a Hashtable with linear probing
    private int QuadraticProbSearch(int number) {
        int place = 0;
        int Initialplace = HashFunction(number);
        boolean notfound = true;
        int i = 1;
        int collisions = 0;
        // int num = 0;

        if (HashTable[Initialplace % HashTable.length] != 0) {
            System.out.println(HashTable[Initialplace % HashTable.length]);
            if (HashTable[Initialplace % HashTable.length] == number) {
                notfound = false;
                System.out.println("Found " + number + " at " + Initialplace);
                return Initialplace;
            } else {
                while (notfound) {
                    place = Initialplace + (int) Math.pow(i, 2);
                    collisions++;
                    if (HashTable[place % HashTable.length] == number) {
                        System.out.println("Found " + number + " at " + place);
                        notfound = false;
                        return place;
                    } else {
                        i++;
                    }
                }
            }
            return 0;
        } else {
            return 0;
        }
    }

    // Create a new Hashtable with Double Hashing
    /**
     * 1. Iterate through every item
     * 2. Initialize notplaced to be true
     * 3. If the slot is empty, place item, make notplaced false
     * 4. If the item is not placed, find the next availabe slot using the double
     * hashing formula => place = Initialplace + i * HashFunction2(number) while
     * notplaced is true
     * 5. If the item is not placed, increment i and repeat
     * 6. Sometimes it is impossible to place the item, so break the loop if i gets
     * too big
     */
    public void DoubleHashCreate(int[] Numbers) {
        int collisions = 0;
        // HashTable = new int[10];
        for (int number : Numbers) {
            int place = 0;
            int i = 1;
            int Initialplace = HashFunction(number);
            boolean notPlaced = true;

            if (HashTable[Initialplace % HashTable.length] == 0) {
                HashTable[Initialplace % HashTable.length] = number;
                notPlaced = false;
            } else {
                while (notPlaced) {
                    place = Initialplace + i * HashFunction2(number);
                    collisions++;
                    System.out.println("Collision with " + number);
                    if (HashTable[place % HashTable.length] == 0) {
                        HashTable[place % HashTable.length] = number;
                        notPlaced = false;
                        break;
                    } else if (i > HashTable.length) {
                        break;
                    } else {
                        i++;
                    }
                }

            }

        }
        System.out.println("Number of collisions: " + collisions);
    }

    // Search in a Hash table with Double Hashing
    private int DoubleHashSearch(int number) {
        int place = 0;
        int Initialplace = HashFunction(number);
        boolean notfound = true;
        int i = 1;
        int collisions = 0;
        // int num = 0;

        if (HashTable[Initialplace % HashTable.length] != 0) {
            // System.out.println(HashTable[Initialplace % HashTable.length]);
            if (HashTable[Initialplace % HashTable.length] == number) {
                notfound = false;
                System.out.println("Found " + number + " at " + Initialplace);
                return Initialplace;
            } else {
                while (notfound) {
                    place = Initialplace + i * HashFunction2(number);
                    collisions++;
                    if (HashTable[place % HashTable.length] == number) {
                        System.out.println("Found " + number + " at " + place);
                        notfound = false;
                        return place;
                    } else if (i > HashTable.length) {
                        System.out.println(number + " not found");
                        break;
                    } else {
                        i++;
                    }
                }
            }
            return 0;
        } else {
            return 0;
        }
    }

    private int HashFunction2(int number) {
        return 7 - (number % 7);
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

        // Testing Linear Probing Search
        for (int i = 0; i < Numbers.length; i++) {
            System.out.println(ht.LinProbSearch(Numbers[i]));
        }

        HashTable ht2 = new HashTable(DataStructure.QuadProb, Numbers);

        for (int i = 0; i < ht2.HashTable.length; i++) {
            System.out.println(ht2.HashTable[i]);
        }

        // Testing Quadratic Probing Search
        for (int i = 0; i < Numbers.length; i++) {
            System.out.println(ht2.QuadraticProbSearch(Numbers[i]));
        }

        HashTable ht3 = new HashTable(DataStructure.DoubleHash, Numbers);

        for (int i = 0; i < ht3.HashTable.length; i++) {
            System.out.println(ht3.HashTable[i]);
        }

        // Testing Double Hash Search
        for (int i = 0; i < Numbers.length; i++) {
            System.out.println(ht3.DoubleHashSearch(Numbers[i]));
        }

    }
}
