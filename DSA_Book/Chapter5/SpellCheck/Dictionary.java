//Interface your dictionary has to implement

package SpellCheck;

import java.util.Iterator;

public interface Dictionary {
    // insert

    public void insert(String word) throws DictionaryException;

    // Removes the entry with the specified key from the dictionary. Throws
    // DictionaryException if no entry with key in the dictionary
    public void remove(String word) throws DictionaryException;
    // find

    // Returns the entry with the specified key in the dictionary. Throws
    public boolean find(String word);

    // elements
    public Iterator elements();
}
