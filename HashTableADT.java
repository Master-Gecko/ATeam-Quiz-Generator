import java.util.List;

/**
 * 
 * Filename:   HashTableADT.java
 * Project:    ATeam Quiz Generator
 * Course:     cs400
 * Authors:    Sammy Zopf 
 * 
 */
public interface HashTableADT<K extends Comparable<K>,V> {
	
	/**
	 * Add the key and value to the hash table and increase the number of keys.
	 * @param key Key to be inserted
	 * @param value Value to be inserted
	 * @throws IllegalNullKeyException 
	 */
	void insert(K key, V value) throws IllegalNullKeyException ;
	
	/**
	 * Remove the key from the hash table and decrease the number of keys.
	 * @param key Key to be removed
	 * @return true if key was removed; otherwise false.
	 */
	boolean remove(K key) ;
	
	/**
	 * Gets the value paired with the key
	 * @param key Key to be found in the hash table
	 * @return the value associated with the key
	 * @throws KeyNotFoundException 
	 * @throws IllegalNullKeyException 
	 */
	List<V> get(K key) throws IllegalNullKeyException, KeyNotFoundException ;
	
	/**
	 * @return the number of keys in the hash table
	 */
	int numKeys() ;

	/**
	 * @return the load factor threshold
	 */
    public double getLoadFactorThreshold() ;

    /**
     * @return the load factor
     */
    public double getLoadFactor() ;
    
    /**
     * @return the capacity of the hash tables
     */
    public int getCapacity() ;

}
