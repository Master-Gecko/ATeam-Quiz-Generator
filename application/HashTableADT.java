package application;

import java.util.List;

/**
 * 
 * Filename:   HashTableADT.java
 * Project:    ATeam Quiz Generator
 * Course:     cs400
 * Authors:    Sammy Zopf 
 * 
 */
public interface HashTableADT<V> {
	
	/**
	 * Add the question to the hash table and increase the number 
	 * of keys if this question is a new topic.
	 * @param question to be inserted
	 * @throws IllegalNullKeyException question was null
	 */
	void insertQuestion(V question) throws IllegalNullKeyException ;
	
	/**
	 * Gets the list of questions for the given topic
	 * @param topic to be found in the hash table
	 * @return the list of questions associated with the topic
	 * @throws KeyNotFoundException topic was not found
	 * @throws IllegalNullKeyException topic was null
	 */
	List<V> getQuestionsForTopic(String topic) throws IllegalNullKeyException, KeyNotFoundException ;
	
	/**
	 * @return a list of every topic in the HashTable
	 */
	List<String> getAllTopics();
	
	/**
	 * @return the number of keys in the hash table
	 */
	int numKeys() ;
	
	/**
     * @return the number of questions in the hash table
     */
	int numQs() ;

	/**
	 * @return the load factor threshold
	 */
    double getLoadFactorThreshold() ;

    /**
     * @return the load factor
     */
    double getLoadFactor() ;
    
    /**
     * @return the capacity of the hash tables
     */
    int getCapacity() ;

}
