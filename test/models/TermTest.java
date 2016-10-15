package models;


import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import static models.Fixtures.listOfTerms;


import org.junit.After;
import org.junit.Test;

import autocomplete.Term;

/**
 * @author Judy
 * Test for Term Class
 * Method to set up data for testing.
 */


public class TermTest {


	Term term = new Term(500,"shop");
	Term term4 = new Term(-1,"Park");


	/**
	 *  1. Method to check constructor set up 
	 * 
	 */
	@Test
	public void testCreate()
	{
		assertEquals (500.0,term.weight,.01);
		assertEquals ("shop",term.term);
		assertEquals (0.0,term4.weight,.01);

	}
  
	
	

	/**
	 * 2. method set up to test id. Hashset created to ensure no duplicates
	 *
	 */
	@Test
	public void testIds()
	{
		Set<Integer> ids = new HashSet<>();
		for (Term term : listOfTerms)
		{
			ids.add(term.id);
		}
		assertEquals (listOfTerms.length, ids.size());
	}

	/**
	 * 3. Method set up to test the creation of toString()
	 *
	 */

	@Test
	public void testToString()
	{
		assertEquals ("Term{" + term.id +", 500.0, shop}", term.toString());
	}






	/**
	 * 4.0 Method set up to test the equality of two objects
	 */
	@Test
	public void testEquals()
	{
		Term term2 = new Term (500.0, "shop"); 
		Term term3   = new Term (600.0, "shops"); 

		assertEquals(term.term, term2.term);
		assertEquals(term2, term2);
		assertNotEquals(term, term3);

		assertSame(term, term);
		assertNotSame(term, term2);
	}  


/**
 * to shut down all tests
 * @throws Exception
 */
	@After
	public void tearDown() throws Exception {
	}

}

