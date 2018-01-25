package tdd_1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class SqliteDBMakerTest {

	@Test
	void testCreateNewDatabase() {
		File database = new File("/home/jjcombs/workspace-fcdtdebug/test.db");

		assertFalse( database.exists(), "The database already exists!" );

		SqliteDBMaker.createNewDatabase("test.db");
		assertTrue( database.exists(), "The database wasn't created!" );

		assertTrue( database.delete(), "The database couldn't be deleted!" );
		System.out.println("The new database has been deleted. Test and test cleanup complete.");
	}
}
