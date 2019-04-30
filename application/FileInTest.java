package application;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * adding to master branch
 * @author odmas
 *
 */
class FileInTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		try {
			//FileIn file = new FileIn("application/questions_001.json");
		} catch (FileNotFoundException e) {
			fail("unable to find file");
		}
		catch (Exception e) {
			fail("threw exception");
		}
	}

}
