package models;


import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import static models.Fixtures.listOfTerms;
import org.junit.After;
import org.junit.Test;

import autocomplete.Term;

public class TermTest {

	
	
	
	Term term = new Term(500,"shop");
	Term term4 = new Term(-1,"Park");

	
	
	 @Test
	public void testCreate()
	  {
	    assertEquals (500,term.weight);
	    assertEquals ("shop",term.term);
	    assertEquals (0,term4.weight);
	   
	  }

	 

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
	  @Test
	  public void testToString()
	  {
	    assertEquals ("Term{" + term.id +", 500, shop}", term.toString());
	  }
	
	


 
 
  @Test
  public void testEquals()
  {
    Term term2 = new Term (500, "shop"); 
    Term term3   = new Term (600, "shops"); 

    assertEquals(term, term);
    assertEquals(term, term2);
    assertNotEquals(term, term3);
    
    assertSame(term, term);
    assertNotSame(term, term2);
  }  




@After
public void tearDown() throws Exception {
}

}

