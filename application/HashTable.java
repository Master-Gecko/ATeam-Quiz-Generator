package application;

import java.util.ArrayList;
import java.util.List;

public class HashTable<V> implements HashTableADT<V> {

  /** the size of the HashTable **/
  private int tableSize;
  /** the load factor threshold of the HashTable **/
  private double loadFactorThreshold;
  /** the HashTable to store the question nodes in the HashTable **/
  private ArrayList<List<Question>>[] hashTable;
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
   * 
   * @param initialCapacity of the HashTable
   * @param loadFactorThreshold of the HashTable
   */
  @SuppressWarnings("unchecked")
  public HashTable(int initialCapacity, double loadFactorThreshold) {
    this.tableSize = initialCapacity;
    this.loadFactorThreshold = loadFactorThreshold;
    this.hashTable = (ArrayList<List<Question>>[]) new ArrayList<?>[this.tableSize];
  }

  @Override
  public void insertQuestion(V question) throws IllegalNullKeyException {
    if (question == null) {
      throw new IllegalNullKeyException();
    }
    String key = ((Question) question).getTopic();

    // check if current index is being utilized
    int hashIndex = Math.abs(key.hashCode()) % this.tableSize;
    if (hashTable[hashIndex] == null || hashTable[hashIndex].size() == 0) { // not utilized ->
                                                                            // insert ArrayList
                                                                            // first
      hashTable[hashIndex] = new ArrayList<List<Question>>();
      this.hashTable[hashIndex].add(new ArrayList<Question>());
      this.hashTable[hashIndex].get(0).add((Question) question); // adds question
      numKeys++;
    } else { // one (or more) keys are already present
      // check for topic
      Boolean added = false;
      for (int i = 0; i < this.hashTable[hashIndex].size(); i++) {
        if (key.equals(this.hashTable[hashIndex].get(i).get(0).getTopic())) {
          // append question to the ArrayList in the HashTable at HashIndex
          this.hashTable[hashIndex].get(i).add((Question) question);
          // Do not increment numKeys because we are tracking topics, not questions
          // numKeys++;
          added = true;
        }
      }
      if (!added) {
        List<Question> addMe = new ArrayList<Question>();
        addMe.add((Question) question);
        this.hashTable[hashIndex].add(addMe);
        numKeys++;
        added = true;
      }

    }
    if (this.getLoadFactor() > this.getLoadFactorThreshold())
      this.hashTable = rehashTable();
  }

  /**
   * Takes in the current hash table and rehashes all topics into a larger table
   * 
   * @return the new hashTable
   */
  @SuppressWarnings("unchecked")
  private ArrayList<List<Question>>[] rehashTable() {
    int oldTS = this.tableSize;
    this.tableSize = this.tableSize * 2 + 1;
    this.numKeys = 0;
    ArrayList<List<Question>>[] rehashedTable =
        (ArrayList<List<Question>>[]) new ArrayList<?>[this.tableSize];

    for (int i = 0; i < oldTS; i++) { // iterates the array
      if (!(this.hashTable[i] == null || this.hashTable[i].size() == 0)) {
        for (int j = 0; j < this.hashTable[i].size(); j++) { // iterates the 2D
          String key = this.hashTable[i].get(j).get(0).getTopic();
          List<V> valueList = (List<V>) this.hashTable[i].get(j);
          int hashIndex = Math.abs(key.hashCode()) % this.tableSize;

          if (rehashedTable[hashIndex] == null || rehashedTable[hashIndex].size() == 0) { // not
                                                                                          // utilized
                                                                                          // ->
                                                                                          // insert
                                                                                          // new
                                                                                          // List<V>
            rehashedTable[hashIndex] = new ArrayList<List<Question>>();
            rehashedTable[hashIndex].add((List<Question>) valueList);
            numKeys++; // += valueList.size();
          } else { // one (or more) keys are already present
            // append kvPair to the ArrayList in the table at HashIndex
            rehashedTable[hashIndex].add((List<Question>) valueList);
            numKeys++; // += valueList.size();
          }
        }
      }
    }
    return rehashedTable;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<V> getQuestionsForTopic(String topic)
      throws IllegalNullKeyException, KeyNotFoundException {
    if (topic == null) {
      throw new IllegalNullKeyException();
    } // cannot have null key
    int hashIndex = Math.abs(topic.hashCode()) % this.tableSize;
    if (hashTable[hashIndex] == null || hashTable[hashIndex].size() == 0) { // index is empty -> key
                                                                            // DNE
      throw new KeyNotFoundException();
    } else { // loop through the arrayList at hashIndex to find the key
      for (int i = 0; i < this.hashTable[hashIndex].size(); i++) {
        if (this.hashTable[hashIndex].get(i).get(0).getTopic().equals(topic)) {
          return (List<V>) this.hashTable[hashIndex].get(i);
        }
      }
    }
    throw new KeyNotFoundException(); // key was not found
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
    return (double) numKeys / (double) tableSize;
  }

  /** @return the capacity of the HashTable **/
  @Override
  public int getCapacity() {
    return this.tableSize;
  }

}
