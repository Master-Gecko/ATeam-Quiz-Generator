
public class HTest {

	public static void main(String[] args) {
		HashTable<String,Question> ht = new HashTable<String,Question>();
		try {
			ht.insert("math",new Question("math",null,null,null));
		} catch (IllegalNullKeyException e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	}

}
