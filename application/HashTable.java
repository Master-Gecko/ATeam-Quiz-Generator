package application;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Filename: HashTable.java 
 * Project: ATeam Quiz Generator 
 * Course: cs400 
 * Authors: Sammy Zopf
 * 
 * 3 Dimensional HashTable to store all of the questions by hashing their topics
 */
public class HashTable<V> implements HashTableADT<V> {

  /** the size of the HashTable **/
  private int tableSize;
  /** the load factor threshold of the HashTable **/
  private double loadFactorThreshold;
  /** the HashTable to store the question nodes in the HashTable **/
  private ArrayList<List<Question>>[] hashTable;
  /** the number of topics in the HashTable **/
  private int numKeys;
  /** the number of questions in the HashTable **/
  private int numQs;

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
      numQs++;
    } else { // one (or more) keys are already present
      // check for topic
      Boolean added = false;
      for (int i = 0; i < this.hashTable[hashIndex].size(); i++) {
        if (key.equals(this.hashTable[hashIndex].get(i).get(0).getTopic())) {
          // append question to the ArrayList in the HashTable at HashIndex
          this.hashTable[hashIndex].get(i).add((Question) question);
          numQs++;
          added = true;
        }
      }
      if (!added) {
        List<Question> addMe = new ArrayList<Question>();
        addMe.add((Question) question);
        this.hashTable[hashIndex].add(addMe);
        numKeys++;
        numQs++;
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
    ArrayList<List<Question>>[] rehashedTable =
        (ArrayList<List<Question>>[]) new ArrayList<?>[this.tableSize];

    for (int i = 0; i < oldTS; i++) { // iterates the array
      if (!(this.hashTable[i] == null || this.hashTable[i].size() == 0)) {
        for (int j = 0; j < this.hashTable[i].size(); j++) { // iterates the 2D
          String key = this.hashTable[i].get(j).get(0).getTopic();
          List<V> valueList = (List<V>) this.hashTable[i].get(j);
          int hashIndex = Math.abs(key.hashCode()) % this.tableSize;

          // not utilized -> insert new List<V>
          if (rehashedTable[hashIndex] == null || rehashedTable[hashIndex].size() == 0) {
            rehashedTable[hashIndex] = new ArrayList<List<Question>>();
            rehashedTable[hashIndex].add((List<Question>) valueList);
            // numKeys++; // += valueList.size();
          } else { // one (or more) keys are already present
            // append kvPair to the ArrayList in the table at HashIndex
            rehashedTable[hashIndex].add((List<Question>) valueList);
            // numKeys++; // += valueList.size();
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

  @Override
  public List<String> getAllTopics() {
    List<String> topicList = new ArrayList<String>();
    for (int i = 0; i < hashTable.length; i++) {
      for (int j = 0; j < hashTable[i].size(); j++) {
        // add the question's topic to the topic list
        topicList.add(hashTable[i].get(j).get(0).getTopic());
      }
    }
    return topicList;
  }

  @Override
  public int numKeys() {
    return this.numKeys;
  }

  @Override
  public double getLoadFactorThreshold() {
    return this.loadFactorThreshold;
  }

  @Override
  public double getLoadFactor() {
    return (double) numKeys / (double) tableSize;
  }

  @Override
  public int getCapacity() {
    return this.tableSize;
  }

  @Override
  public int numQs() {
    return this.numQs;
  }

}
