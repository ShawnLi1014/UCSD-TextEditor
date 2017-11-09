/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		try {
			shortList.remove(2);
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		try {
			longerList.remove(-1);
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		int a =list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		for(int i = 0;i<LONG_LIST_LENGTH;i++) {
			int b = longerList.remove(0);
			assertEquals("Remove: check b is correct ", i, b);
		    assertEquals("Remove: check element 0 is correct ", (Integer)(i+1), longerList.get(0));
		    assertEquals("Remove: check size is correct ", LONG_LIST_LENGTH-i-1, longerList.size());
		}
		
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        try {
        	    list1.add(null);
        	    fail("Check invalid element");
        }
        catch(NullPointerException e) {
        	
        }
		boolean state = list1.add(0);
		assertEquals("AddEnd: check boolean state", false, state);
		assertEquals("AddEnd: check element 0 is correct" , (Integer)0, list1.get(3));
		assertEquals("AddEnd: check size is correct", 4, list1.size());// TODO: implement this test
		
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		assertEquals("Size: check emptyList", 0, emptyList.size());
		assertEquals("Size: check shortList", 2, shortList.size());
		assertEquals("Size: check longerList", 10, longerList.size());
		assertEquals("Size: check list1", 3, list1.size());
		// TODO: implement this test
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        try{
        	    list1.add(1,null);
        	    fail("Check invalid element");// TODO: implement this test
        }
        catch(NullPointerException e) {
        	
        }
        try {
        	    list1.add(-1, 0);
        	    fail("Check out of bounds");
        }
        catch(IndexOutOfBoundsException e) {
        	
        }
		try {
			list1.add(3,0);
			fail("Check out of bounds");
		}
        catch(IndexOutOfBoundsException e) {
        	
        }
		list1.add(0,0);
		assertEquals("AddAtIndex: check element is correct", (Integer)0, list1.get(0));
		assertEquals("AddAtIndex: check element 1 is correct", (Integer)65, list1.get(1));
		assertEquals("AddAtIndex: check size is correct", 4, list1.size());
		
		shortList.add(1,"C");
		assertEquals("AddAtIndex: check element is correct", (String)"C", shortList.get(1));
		assertEquals("AddAtIndex: check element 2 is correct", (String)"B", shortList.get(2));
		assertEquals("AddAtIndex: check size is correct", 3, shortList.size());
		
		
		
	}
        
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		try{
    	    list1.set(1,null);
    	    fail("Check invalid element");// TODO: implement this test
    }
    catch(NullPointerException e) {
    	
    }
    try {
    	    list1.set(-1, 0);
    	    fail("Check out of bounds");
    }
    catch(IndexOutOfBoundsException e) {
    	
    }
	try {
		list1.set(list1.size(),0);
		fail("Check out of bounds");
	}
    catch(IndexOutOfBoundsException e) {
    	
    }
	  list1.set(0, 1);
	  assertEquals("Set: check value is correct", (Integer)1, list1.get(0));
	  assertEquals("Set: check size is correct", 3, list1.size());
	  
	  list1.set(1, 5);
	  assertEquals("Set: check value is correct", (Integer)5, list1.get(1));
	  assertEquals("Set: check size is correct", 3, list1.size());
	  // TODO: implement this test
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
