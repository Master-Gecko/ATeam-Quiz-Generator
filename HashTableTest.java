import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
 * JUnit test class for HashTable.java
 * @author Sammy
 */
public class HashTableTest {

  // TODO: add other fields that will be used by multiple tests
  HashTable<String, Question> ht1;
  
  @Before
  public void setUp() throws Exception {
    ht1 = new HashTable<String, Question>();
  }

  @After
  public void tearDown() throws Exception {
     ht1 = null;
  }

  /**
   * IMPLEMENTED AS EXAMPLE FOR YOU Tests that insert(null,null) throws IllegalNullKeyException
   */
  @Test
  public void test001_IllegalNullKey() {
    try {
      ht1.insert(null,null);
      fail("should not be able to insert null key");
    } catch (IllegalNullKeyException e) {
      /* expected */ } catch (Exception e) {
      fail("insert null key should not throw exception " + e.getClass().getName());
    }
  }

  /**
   * Tests that insert() works for one key,value pair
   */
  @Test
  public void test002_insert_one_KeyValuePair() {
    try {
      ht1.insert("math", new Question("math", null, null, null));
    } catch (Exception e) {
      fail("Unexpected exception 002: " + e.getMessage());
    }
  }

  /**
   * Tests that insert() works for two questions that have the same topic
   */
  @Test
  public void test003_insert_same_topic() {
    try {
      // insert 10, 120
      ht1.insert("math", new Question("math", null, null, null));
      ht1.insert("math", new Question("math", null, null, null));
    } catch (Exception e) {
      fail("Unexpected exception 002: " + e.getMessage());
    }
  }
  
  /**
   * Tests that remove() throws illegal null exception
   */
//  @Test
//  public void test004_remove_illegalNullException() {
//    try {
//      ht1.insert("math", new Question("math", null, null, null));
//      ht1.remove(null);
//      fail("should not be able to remove null key");
//    //} catch (IllegalNullKeyException e) {
//      /* expected behavior */
//    } catch (Exception e) {
//      fail("remove null key should not throw exception " + e.getClass().getName());
//    }
//  }
 
  /**
   * Tests that get() throws illegal null exception
   */
  @Test
  public void test005_get_illegalNullException() {
    try {
      ht1.insert("math", new Question("math", null, null, null));
      ht1.get(null);
      fail("should not be able to get null key");
    } catch (IllegalNullKeyException e) {
      /* expected behavior */
    } catch (Exception e) {
      fail("get null key should not throw exception " + e.getClass().getName());
    }
  }
  
  /**
   * Tests that insert() throws DuplicateKeyException when two of the same key are inserted
   */
//  @Test
//  public void test006_fix_test() {
//    try {
//      fail("Fix test006");
//    } catch (Exception e) {
//      fail("Unexpected exception 002: " + e.getMessage());
//    }
//  }
  
  /**
   * Tests that remove() works on one key insertion -> remove
   */
//  @Test
//  public void test007_remove_one_key() {
//    try {
//      ht1.insert("math", new Question("math", null, null, null));
//      assertTrue(ht1.remove("math"));
//    } catch (Exception e) {
//      fail("Unexpected exception 007: " + e.getMessage());
//    }
//  }
  
  /**
   * Tests that get() throws KeyNotFoundException when HashTable is empty
   */
  @Test
  public void test008_get_KeyNotFoundException_when_HashTable_is_empty() {
    try {
      ht1.get("math");
      fail("should not be able to get a key");
    } catch (KeyNotFoundException e) {
      /* expected behavior */
    } catch (Exception e) {
      fail("Unexpected exception 008: " + e.getMessage());
    }
  }
  
  /**
   * Tests that get() throws KeyNotFoundException when key does not exist
   */
  @Test
  public void test009_get_KeyNotFoundException_when_key_DNE() {
    try {
      ht1.insert("math", new Question("math", null, null, null));
      ht1.get("english");
      fail("should not be able to get a key");
    } catch (KeyNotFoundException e) {
      /* expected behavior */
    } catch (Exception e) {
      fail("Unexpected exception 008: " + e.getMessage());
    }
  }
  
  /**
   * Tests that get() works with one key
   */
  @Test
  public void test010_get_works_with_one_key() {
    try {
      Question q = new Question("math", null, null, null);
      ht1.insert("math", q);
      List<Question> expectedList = new ArrayList<Question>();
      expectedList.add(q);
      
      assertTrue(expectedList.equals(ht1.get("math")));
    } catch (Exception e) {
      fail("Unexpected exception 010: " + e.getMessage());
    }
  }
  
  /**
   * Tests that rehashing works with one rehash method call
   */
  @Test
  public void test011_rehash_works_with_one_rehash() {
    try {
      int startingCapacity = 11;
      ht1.insert("math", new Question("math", null, null, null));
      ht1.insert("science", new Question("science", null, null, null));
      ht1.insert("english", new Question("english", null, null, null));
      ht1.insert("computer science", new Question("computer science", null, null, null));
      ht1.insert("anthropology", new Question("anthropology", null, null, null));
      ht1.insert("biology", new Question("biology", null, null, null));
      ht1.insert("physics", new Question("physics", null, null, null));
      ht1.insert("psychology", new Question("psychology", null, null, null)); // Should rehash on the 9th insert
      ht1.insert("sociology", new Question("sociology", null, null, null));
      ht1.insert("economics", new Question("economics", null, null, null));
      System.out.println("ht1: "+ht1.getCapacity() + " sc: "+startingCapacity);
      assertTrue(ht1.getCapacity()>startingCapacity);
    } catch (Exception e) {
      System.out.println(e.getClass());
      fail("Unexpected exception 011: " + e.getMessage());
    }
  }

}
