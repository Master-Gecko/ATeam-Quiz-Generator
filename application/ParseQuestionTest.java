package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParseQuestionTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		try {
			ParseQuestion parser = new ParseQuestion("topic", "question1", "T,Answer1\nF,Answer2\nF,Answer3");
			System.out.println(parser.getQuestion());
		} catch (Exception e) {
			e.printStackTrace();
			fail("threw exception");
		}
	}

}
