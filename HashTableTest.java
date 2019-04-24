import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
 * JUnit test class for HashTable.java
 * @author Sammy
 */
public class HashTableTest {

  // TODO: add other fields that will be used by multiple tests
  HashTable<Integer, String> ht1;
  HashTable<String, String> ht2;
  
  @Before
  public void setUp() throws Exception {
    ht1 = new HashTable<Integer, String>();
    ht2 = new HashTable<String, String>();
  }

  @After
  public void tearDown() throws Exception {
     ht1 = null;
     ht2 = null;
  }

  /**
   * IMPLEMENTED AS EXAMPLE FOR YOU Tests that insert(null,null) throws IllegalNullKeyException
   */
  @Test
  public void test001_IllegalNullKey() {
    try {
      HashTableADT htIntegerKey = new HashTable<Integer, String>();
      htIntegerKey.insert(null, null);
      fail("should not be able to insert null key");
    //} catch (IllegalNullKeyException e) {
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
      // insert 10
      ht1.insert(10, "1st Key inserted");
    } catch (Exception e) {
      fail("Unexpected exception 002: " + e.getMessage());
    }
  }

  /**
   * Tests that insert() works for and collision of two KeyValuePairs
   */
  @Test
  public void test003_insert_collision() {
    try {
      // insert 10, 120
      ht1.insert(10, "1st Key inserted");
      ht1.insert(120, "2nd Key inserted");
    } catch (Exception e) {
      fail("Unexpected exception 002: " + e.getMessage());
    }
  }
  
  /**
   * Tests that remove() throws illegal null exception
   */
  @Test
  public void test004_remove_illegalNullException() {
    try {
      ht1.insert(10, "1st Key inserted");
      ht1.remove(null);
      fail("should not be able to remove null key");
    //} catch (IllegalNullKeyException e) {
      /* expected behavior */
    } catch (Exception e) {
      fail("remove null key should not throw exception " + e.getClass().getName());
    }
  }
 
  /**
   * Tests that get() throws illegal null exception
   */
  @Test
  public void test005_get_illegalNullException() {
    try {
      ht1.insert(10, "1st Key inserted");
      ht1.get(null);
      fail("should not be able to get null key");
    //} catch (IllegalNullKeyException e) {
      /* expected behavior */
    } catch (Exception e) {
      fail("get null key should not throw exception " + e.getClass().getName());
    }
  }
  
  /**
   * Tests that insert() throws DuplicateKeyException when two of the same key are inserted
   */
  @Test
  public void test006_insert_DuplicateKeyException() {
    try {
      // insert 10, 10
      ht1.insert(10, "1st Key inserted");
      ht1.insert(10, "2nd Key inserted");
      fail("should not be able to insert two of the same key");
    //} catch (DuplicateKeyException e) {
      /* expected behavior */
    } catch (Exception e) {
      fail("Unexpected exception 002: " + e.getMessage());
    }
  }
  
  /**
   * Tests that remove() works on one key insertion -> remove
   */
  @Test
  public void test007_remove_one_key() {
    try {
      // insert 10
      ht1.insert(10, "1st Key inserted");
      assertTrue(ht1.remove(10));
    } catch (Exception e) {
      fail("Unexpected exception 007: " + e.getMessage());
    }
  }
  
  /**
   * Tests that get() throws KeyNotFoundException when HashTable is empty
   */
  @Test
  public void test008_get_KeyNotFoundException_when_HashTable_is_empty() {
    try {
      ht1.get(10);
      fail("should not be able to get a key");
    //} catch (KeyNotFoundException e) {
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
      ht1.insert(20, "1st Key inserted");
      ht1.get(10);
      fail("should not be able to get a key");
    //} catch (KeyNotFoundException e) {
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
      ht1.insert(10, "1st Key inserted");
      String expectedString = "1st Key inserted";
      
      assertTrue(expectedString.equals(ht1.get(10)));
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
      ht1.insert(10, "1st Key inserted");
      ht1.insert(20, "2nd Key inserted");
      ht1.insert(30, "3rd Key inserted");
      ht1.insert(40, "4th Key inserted");
      ht1.insert(50, "5th Key inserted");
      ht1.insert(60, "6th Key inserted");     
      ht1.insert(70, "7th Key inserted");
      ht1.insert(80, "8th Key inserted"); // Should rehash on the 9th insert
      ht1.insert(90, "9th Key inserted");
      ht1.insert(100, "10th Key inserted");
      assertTrue(ht1.getCapacity()>startingCapacity);
    } catch (Exception e) {
      System.out.println(e.getClass());
      fail("Unexpected exception 011: " + e.getMessage());
    }
  }
  // TODO add your own tests of your implementation

}
