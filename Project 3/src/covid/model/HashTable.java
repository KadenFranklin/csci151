package covid.model;

import java.util.ArrayList;
import java.util.Optional;

@SuppressWarnings("unchecked")
public class HashTable<K,V> {
    private HashNode<K,V>[] table;
    private int size;
    private final double MAX_LOAD = 0.75;

    public HashTable() {
        initTable(16);
    }

   public void initTable(int size) {
        table = (HashNode<K,V>[])new HashNode[size];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    int capacity() {
        return table.length;
    }

    public double load() {
        return (double)size() / capacity();
    }

    /**
     * @param key
     * @return Index associated with key, given the size of the table.
     */
    int index(K key) {
        return Math.abs(key.hashCode() % capacity());
    }

    /**
     * Stores a value in the HashTable for the given key.
     * Implement the separate chaining method of resolving
     * collisions in the table.
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        int i = index(key);
        if (table[i] == null) {
            HashNode<K, V> this_hashnode = new HashNode<K, V>(key, value);
            table[i] = this_hashnode;
            size += 1;
        }else {
            boolean reset = false;
            for(HashNode<K,V> spot = table[i]; spot != null; spot = spot.getNext() ) {
                if (spot.getKey().equals(key)) {
                    spot.setValue(value);
                    reset = true;

                }
            }
            if (!reset) {
                HashNode<K, V> that_hashnode = new HashNode<K, V>(key, value, table[i]);
                table[i] = that_hashnode;
                size += 1;
            }
        }
        if (load() > MAX_LOAD ) {
            HashNode<K, V> [] temp = table;
            initTable(capacity() * 2);
            for (int c = 0; c < temp.length; c++ ) {
                for(HashNode<K,V> spot = temp[c]; spot != null; spot = spot.getNext() ) {
                    put(spot.getKey(), spot.getValue());
                }
            }
        }
    }


    /**
     * Retrieves the value stored in the table when given a key, if present.
     */
    public Optional<V> get(K key) {
        int i = index(key);
        if (table[i] != null) {
            for(HashNode<K,V> spot = table[i]; spot != null; spot = spot.getNext() ) {
                if (spot.getKey().equals(key)) {
                    return Optional.of(spot.getValue());
                }
            }
        }
        return Optional.empty();
    }

    /**
     * Returns a list of all the keys found in the HashTable.
     * @return
     */
    public ArrayList<K> allKeys() {
        ArrayList<K> all = new ArrayList<>();
        for (int i = 0; i < capacity(); i++ ){
            for(HashNode<K,V> spot = table[i]; spot != null; spot = spot.getNext() ){
                all.add(spot.getKey());
            }
        }
        return all;
    }
}