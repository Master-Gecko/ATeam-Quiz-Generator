import java.util.ArrayList;
import java.util.List;

public class HashTable<K extends Comparable<K>,V> implements HashTableADT<K,V> {
  
  /** the size of the HashTable **/
  private int tableSize;
  /** the load factor threshold of the HashTable **/
  private double loadFactorThreshold;
  /** the HashTable to store the question nodes in the HashTable **/
  private ArrayList<List<Question>>[] hashTable;
//  /** the 2D storage of each hash index**/
//  private List<List<Question>> indexList;
  /** the number of key,value pairs in the HashTable **/
  private int numKeys;
  
  /**
   * no-arg constructor that calls the other constructor with values: <br>
   * initialCapacity = 11 <br>
   * loadFactorThreshold = 0.75
   */
  public HashTable() {
    this(11, 0.75);
  }
  
  /**
   * Builds the HashTable from inputed values.
   * @param initialCapacity of the HashTable
   * @param loadFactorThreshold of the HashTable
   */
  @SuppressWarnings("unchecked")
  public HashTable(int initialCapacity, double loadFactorThreshold) {
    this.tableSize = initialCapacity;
    this.loadFactorThreshold = loadFactorThreshold;
    this.hashTable = (ArrayList<List<Question>>[]) new ArrayList<?>[tableSize];
  }
  
  @Override
  public void insert(K key, V value) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public boolean remove(K key) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public V get(K key) {
    // TODO Auto-generated method stub
    return null;
  }

  /** @return the number of keys in the HashTable **/
  @Override
  public int numKeys() {
    return this.numKeys;
  }
  
  /** @return the load factor threshold **/
  @Override
  public double getLoadFactorThreshold() {
    return this.loadFactorThreshold;
  }
  
  /** @return the load factor **/
  @Override
  public double getLoadFactor() {
    return numKeys / (double) tableSize;
  }

  /** @return the capacity of the HashTable **/
  @Override
  public int getCapacity() {
    return this.tableSize;
  }
  
} 
