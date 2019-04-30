package application;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * adding to master branch
 * 
 * @author odmas
 *
 */
class FileOutTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		try {
			HashTable<Question> hash = new HashTable<Question>();
			FileIn in = new FileIn("application/questions_003.json", hash);
			ArrayList<Answer> answers = new ArrayList<Answer>();
			answers.add(new Answer(false, "answer1"));
			answers.add(new Answer(false, "answer2"));
			answers.add(new Answer(true, "answer3"));
			answers.add(new Answer(false, "answer4"));
			answers.add(new Answer(false, "answer5"));
			hash.insertQuestion(new Question("graph", "none", "questionText", "none", answers));
			FileOut out = new FileOut("application/questions_003_new.json", hash);
		} catch (Exception e) {
			e.printStackTrace();
			fail("threw exception");
		}
	}

	@AfterEach
	void tearDown() {
		
	}
}
