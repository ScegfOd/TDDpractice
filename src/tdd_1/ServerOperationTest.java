package tdd_1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ServerOperationTest {
	private final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final static ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	    System.setOut(System.out);
	    System.setErr(System.err);
	}


	@Test
	final void testHelloTo() throws RemoteException {
		ServerOperation test = new ServerOperation();
		assertEquals(test.helloTo("John"), "Server says hi to John");
	}

	@Test
	final void testMain() throws RemoteException {
		//ServerOperation test = new ServerOperation();
		ServerOperation.main(null);
		assertEquals(errContent.toString(), "The server is ready!");
		fail("Not yet implemented"); // TODO
	}

}
