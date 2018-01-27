package tdd_1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Test1Test {
	private final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final static ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@BeforeAll
	static void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}
	
	@Test
	@DisplayName("WHAT!? (╯°□°)╯︵ ┻━┻")
	void testMain() {
		//setUpStreams();
		Test1.main(null);
		//restoreStreams();
		assertEquals("testing testing 123\ntesting testing 456\n", outContent.toString());
	}

	@AfterAll
	static void restoreStreams() {
	    System.setOut(System.out);
	    System.setErr(System.err);
	}

}
