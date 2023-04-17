import java.math.BigInteger;

public class HashTableSum<K, V> {

    Entry[] storage = new Entry[10];
    int count = 0;

    class Entry<K, V> {
        K key;
        V value;
        boolean deleted = false;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity() {
        return storage.length;
    }

    public int nextPrime(int num) {
        BigInteger bigInt = new BigInteger("" + num);
        BigInteger prime = bigInt.nextProbablePrime();
        int primeIne = prime.intValue();
        return primeIne;
    }

    public int hash2(K key, int i) {
        return (7 - ((Integer) key % 7)) * i;
    }

    private void set(K key, V value) {
        if (count / capacity() >= 0.5) {
            rehash();
        }

        int index = hash(key);
        int i = 1;
        while (i < storage.length) {
            if (storage[index] == null) {
                count++;
                storage[index] = new Entry(key, value);
                return;
            } else if (storage[index].key.equals(key) && storage[index].deleted == false) {
                storage[index] = new Entry(key, value);
                return;
            } else if (storage[index].deleted) {
                storage[index] = new Entry(key, value);
                count++;
                return;
            } else {
                index = (hash(key) + hash2(key, i)) % storage.length;
                // System.out.println(index);
                i++;
            }
        }
    }

    public void rehash() {
        Entry[] oldStorage = storage;
        this.storage = new Entry[nextPrime(oldStorage.length * 2)];

        for (Entry<K, V> obj : oldStorage) {
            if (obj != null & !obj.deleted) {
                set(obj.key, obj.value);
            }
        }
    }

    private V remove(K key) {

        int index = hash(key);
        int i = 0;
        while (i < storage.length) {
            if (storage[index] == null) {
                return null;
            } else if (storage[index].key.equals(key) && storage[index].deleted == false) {
                storage[index].deleted = true;
                count--;
                return (V) storage[index].value;
            } else {
                index = (hash(key) + hash2(key, i)) % storage.length;
                i++;
            }
        }
        return null;
    }

    private V get(K key) {

        int index = hash(key);
        int i = 0;
        while (i < storage.length) {
            if (storage[index] == null) {
                return null;
            } else if (storage[index].key.equals(key) && storage[index].deleted == false) {
                return (V) storage[index].value;
            } else {
                index = (hash(key) + hash2(key, i)) % storage.length;
                i++;
            }
        }
        return null;
    }

    public int hash(K key) {
        // System.out.println(key);
        return Math.abs((Integer) key % storage.length);
    }

    public int Quadratic(K key, int i) {
        return (hash(key) + (i * i)) % storage.length;
    }

    private Object[] keys() {
        Object[] keys = new Object[count];

        int i = 0;
        for (Entry<K, V> obj : storage) {
            if (obj != null && obj.deleted == false) {
                keys[i] = obj.key;
                i++;
            }
        }

        return (Object[]) keys;
    }

    public V[] TwoSum(int[] numbers, int target) {
        Object[] result = new Object[2];

        Integer j = 0;
        for (int i = 0; i < numbers.length; i++) {
            Integer num = target - numbers[i];
            V contains = get((K) num);

            if (contains != null) {

                result[0] = i;
                result[1] = contains;
                return (V[]) result;
            } else {
                Integer number = (Integer) numbers[i];
                set((K) number, (V) j);
            }
            j++;
        }
        return (V[]) new Object[] { 0, 0 };
    }

    public static void main(String[] args) {

        HashTableSum<Integer, String> dict2 = new HashTableSum<>();

        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        Object[] result = dict2.TwoSum(nums, target);
        System.out.print(result[0] + " ");
        System.out.print(result[1]);
        System.out.println();

        HashTableSum<Integer, String> dict3 = new HashTableSum<>();

        int[] nums3 = { 3, 2, 4 };
        int target3 = 6;
        Object[] result3 = dict2.TwoSum(nums3, target3);
        System.out.print(result3[0] + " ");
        System.out.print(result3[1]);
    }

}
