package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileInOutTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		try {
			FileInOut file = new FileInOut("questions_001");
		} catch (FileNotFoundException e) {
			fail("unable to find file");
		}
		catch (Exception e) {
			fail("threw exception");
		}
	}

}
