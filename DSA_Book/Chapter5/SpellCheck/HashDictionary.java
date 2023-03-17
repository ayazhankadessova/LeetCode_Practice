package SpellCheck;

import java.util.Iterator;

public class HashDictionary implements Dictionary {

    private HashTable dict;
    private int averNumOps;

    // Simply call a Dictionary Exception when called
    public HashDictionary() throws DictionaryException {
        throw new DictionaryException();
    };

    /**
     * 
     * @param sH - User HashCode
     * @param sF - The Load Limit for the HashTable
     */
    public HashDictionary(StringHashCode sH, Float sF) {
        dict = new HashTable(7, sF, sH);
        averNumOps = 0;

    }

    @Override
    public void insert(String key) throws DictionaryException {
        // TODO Auto-generated method stub
        if (!dict.contains(key)) {
            dict.insert(key);
        } else {
            throw new DictionaryException(key + "Word already exists");
        }

    }

    @Override
    public void remove(String key) throws DictionaryException {
        // TODO Auto-generated method stub
        dict.remove(key);
        averNumOps++;
    }

    @Override
    public boolean find(String key) {
        // TODO Auto-generated method stub
        averNumOps++;
        if (dict.contains(key)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Iterator<String> elements() {
        Iterator<String> it = dict;

        return it;
    }

    public float averNumProbes() {
        // TODO Auto-generated method stub
        float averProbes = (float) dict.getProbes() / (float) averNumOps;
        return averProbes;
    }

}
