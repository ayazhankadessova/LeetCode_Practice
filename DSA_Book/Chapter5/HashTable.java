
// package DSA_Book.Chapter5;
import java.util.LinkedList;

// Creating HashTable with 
public class HashTable {
    int[] HashTable = new int[7];
    LinkedList<Integer>[] SepChainHashTable;
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
                SepChainCreate(Numbers);
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

    // Create a new Hashtable with Separate Chaining
    /**
     * 1. Iterate through every item
     * 2. If the slot is empty, create a new LinkedList
     * 3. Add the item to the LinkedList
     * 4. If the slot is not empty, add the item to the LinkedList
     * 5. The LinkedList will be created in the HashTable array
     */
    public void SepChainCreate(int[] Numbers) {
        SepChainHashTable = new LinkedList[155285];
        // HashTable = new int[10];
        for (int number : Numbers) {
            int Initialplace = HashFunction(number);

            if (SepChainHashTable[Initialplace % HashTable.length] == null) {
                SepChainHashTable[Initialplace % HashTable.length] = new LinkedList<Integer>();
                SepChainHashTable[Initialplace % HashTable.length].add(number);
            } else {
                SepChainHashTable[Initialplace % HashTable.length].add(number);
            }

        }
        System.out.println("No collisions in Separate Chaining : D  ");
    }

    // Search in a Hashtable with Separate Chaining
    private int SepChainSearch(int number) {
        int place = 0;
        int i = 0;
        place = HashFunction(number);

        boolean notfound = true;
        int word;
        while (notfound) {
            numSearched++;
            if (SepChainHashTable[place % SepChainHashTable.length] != null) {
                if (SepChainHashTable[place % SepChainHashTable.length].get(i) == number) {
                    System.out.println("Found " + number + " at " + place);
                    return i;
                } else {
                    i++;
                    if (SepChainHashTable[place % SepChainHashTable.length].size() <= i) {
                        System.out.println(number + " not found");
                        return 0;
                    }
                }
            } else {
                System.out.println(number + " not found");
                return 0;
            }
        }
        return 0;
    }

    private int HashFunction2(int number) {
        return 7 - (number % 7);
    }

    private int HashFunction(int number) {
        return number % HashTable.length;
    }

    public static void main(String[] args) {
        int[] Numbers = { 7, 22, 12, 5, 39, 72, 29, 14, 18, 65, 27, 62 };

        // Create a new HashTable with Linear Probing
        HashTable ht = new HashTable(DataStructure.LinProb, Numbers);

        for (int i = 0; i < ht.HashTable.length; i++) {
            System.out.println(ht.HashTable[i]);
        }

        // Testing Linear Probing Search
        for (int i = 0; i < Numbers.length; i++) {
            System.out.println(ht.LinProbSearch(Numbers[i]));
        }

        // Create a new HashTable with Quadratic Probing
        HashTable ht2 = new HashTable(DataStructure.QuadProb, Numbers);

        for (int i = 0; i < ht2.HashTable.length; i++) {
            System.out.println(ht2.HashTable[i]);
        }

        // Testing Quadratic Probing Search
        for (int i = 0; i < Numbers.length; i++) {
            System.out.println(ht2.QuadraticProbSearch(Numbers[i]));
        }

        // Create a new HashTable with Double Hashing
        HashTable ht3 = new HashTable(DataStructure.DoubleHash, Numbers);

        for (int i = 0; i < ht3.HashTable.length; i++) {
            System.out.println(ht3.HashTable[i]);
        }

        // Testing Double Hash Search
        for (int i = 0; i < Numbers.length; i++) {
            System.out.println(ht3.DoubleHashSearch(Numbers[i]));
        }

        // Create a new HashTable with Separate Chaining
        HashTable ht4 = new HashTable(DataStructure.SepChain, Numbers);

        for (int i = 0; i < ht4.HashTable.length; i++) {
            System.out.println("At index " + i + " : ");
            if (ht4.SepChainHashTable[i] != null) {
                for (int j = 0; j < ht4.SepChainHashTable[i].size(); j++) {
                    System.out.println(ht4.SepChainHashTable[i].get(j));
                }
            } else {

                System.out.println("null");
            }
        }

        // Testing Separate Chain Search
        for (int i = 0; i < Numbers.length; i++) {
            System.out.println(ht4.SepChainSearch(Numbers[i]));
        }

    }
}
