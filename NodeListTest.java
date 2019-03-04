/**
 * Your Name: Michael Poust
 * Date: 3/4/2019
*/

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NodeListTest {

	static NodeList testList = new NodeList();
	static NodeList testList2 = new NodeList();
	static NodeList testList3 = new NodeList();
	static ByteArrayOutputStream outStream = new ByteArrayOutputStream();
	static PrintStream oldOutStream = System.out;
	
	/****** TEST SETUP ******/
	
	@Before
	static void initStreams() {
		System.setOut(new PrintStream(outStream));
	}
	
	@Before
	void initTestList() {
		testList.insert(0, new NodeList.Node("Bravo"));
		testList.insert(1, new NodeList.Node("Delta"));
		testList.insert(2, new NodeList.Node("Echo"));
		testList.insert(3, new NodeList.Node("Foxtrot"));
		
		testList2.insert(0, new NodeList.Node("Bravo"));
		testList2.insert(1, new NodeList.Node("Delta"));
		testList2.insert(2, new NodeList.Node("Echo"));
		testList2.insert(3, new NodeList.Node("Foxtrot"));
		
		testList3.insert(0, new NodeList.Node("Bravo"));
		testList3.insert(1, new NodeList.Node("Delta"));
		testList3.insert(2, new NodeList.Node("Echo"));
		testList3.insert(3, new NodeList.Node("Foxtrot"));
	}
	
	@After
	static void destroyStreams() {
		System.setOut(oldOutStream);
	}
	
//	@AfterEach
//	void destroyTestList() {
//		int length = testList.getLength();
//		for(int i = 0; i < length; i++)
//		{
//			testList.remove(i);
//		}
//			
//		testList.setLength(0);
//	}
	
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
		
		assertEquals("Alpha\nBravo\nDelta\nEcho\nFoxtrot",
					 outStream.toString(),
					 "Add Begging Test: addHead() does not print Alpha in list.");
	}
	
	@Test // Test Case 2
	void addItemEndTest() {
		// Should have 4 Items from initTestList()
		assertEquals(4,
					 testList2.getLength(),
					 "Add End Test starting condtions not met.");
		
		testList.addTail(new NodeList.Node("Golf"));
		
		assertEquals(5,
					 testList2.getLength(),
					 "Add End Test: addTail() does not increase list length.");
		
		assertTrue(testList2.getTail().getName().equals("Golf"),
				   "Add End Test: addTail() does not insert Golf Node.");
		
		testList2.print();
		
		assertEquals("Bravo\nDelta\nEcho\nFoxtrot\nGolf",
					 outStream.toString(),
					 "Add End Test: addTail() does not print Golf in list.");
	}
	
	@Test // Test Case 3
	void insertItemAtPositionTest() {
		// Should have 4 Items from initTestList()
		assertEquals(4,
					 testList3.getLength(),
					 "Insert Test starting conditions not met.");
		
		testList3.insert(0, new NodeList.Node("Alpha"));
		
		testList3.insert(2, new NodeList.Node("Charlie"));
		
		assertAll("list inserts",
				() -> assertEquals(6, testList3.getLength()),
				() -> assertEquals("Charlie", testList3.get(2).getName())
			);
		
		testList3.print();
		
		assertEquals("Alpha\nBravo\nCharlie\nDelta\nEcho\nFoxtrot",
					 outStream.toString(),
					 "Insert Test: insert() does not print Alpha or Charlie in list.");
	}
	
	// Test for numbers when creating Node?

}
