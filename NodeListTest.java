/**
 * Your Name: Michael Poust
 * Date: 3/4/2019
*/

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NodeListTest {

	static NodeList testList;
	static ByteArrayOutputStream outStream;
	static PrintStream oldOutStream = System.out;
	
	/****** TEST SETUP ******/
	
	@BeforeEach
	 void initStreams() {
		outStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outStream));
	}
	
	@BeforeEach
	void initTestList() {
		testList = new NodeList();
		
		//testList.addHead(new NodeList.Node("Bravo"));
		testList.insert(0, new NodeList.Node("Bravo"));
		testList.insert(1, new NodeList.Node("Delta"));
		testList.insert(2, new NodeList.Node("Echo"));
		testList.insert(3, new NodeList.Node("Foxtrot"));
	}
	
	/****** TEST CASES ******/
	
	@Test // Test Case 1
	void addItemBeginningTest() {
		// Should have 4 Items from initTestList()
		assertEquals(4,
					 testList.getLength(),
					 "Add Begging Test starting conditions not met.");
		
		testList.addHead(new NodeList.Node("Alpha"));
		
		assertEquals(5,
					 testList.getLength(),
					 "Add Begging Test: addHead() does not increase list length.");
		
		assertTrue(testList.getHead().getName().equals("Alpha"),
				   "Add Begging Test: addHead() does not insert Alpha Node.");
		
		testList.print();
		
		String expected = "Alpha\nBravo\nDelta\nEcho\nFoxtrot\n"
						.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
		
		assertEquals(expected,
					 outStream.toString(),
					 "Add Begging Test: addHead() does not print Alpha in list.");
	}
	
	@Test // Test Case 2
	void addItemEndTest() {
		// Should have 4 Items from initTestList()
		assertEquals(4,
					 testList.getLength(),
					 "Add End Test starting condtions not met.");
		
		testList.addTail(new NodeList.Node("Golf"));
		
		assertEquals(5,
					 testList.getLength(),
					 "Add End Test: addTail() does not increase list length.");
		
		assertTrue(testList.getTail().getName().equals("Golf"),
				   "Add End Test: addTail() does not insert Golf Node.");
		
		testList.print();
		
		String expected = "Bravo\nDelta\nEcho\nFoxtrot\nGolf\n"
							.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
		
		assertEquals(expected,
					 outStream.toString(),
					 "Add End Test: addTail() does not print Golf in list.");
	}
	
	@Test // Test Case 3
	void insertItemAtPositionTest() {
		// Should have 4 Items from initTestList()
		assertEquals(4,
					 testList.getLength(),
					 "Insert Test starting conditions not met.");
		
		testList.insert(0, new NodeList.Node("Alpha"));
		
		testList.insert(2, new NodeList.Node("Charlie"));
		
		assertAll("list inserts",
				() -> assertEquals(6, testList.getLength()),
				() -> assertEquals("Charlie", testList.get(2).getName())
			);
		
		testList.print();
		
		String expected = "Alpha\nBravo\nCharlie\nDelta\nEcho\nFoxtrot\n"
						  .replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
		
		assertEquals(expected,
					 outStream.toString(),
					 "Insert Test: insert() does not print Alpha or Charlie in list.");
	}
	
	// Test for numbers when creating Node?

}
