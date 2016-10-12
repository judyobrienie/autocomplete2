package models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static models.Fixtures.listOfTerms;
import autocomplete.Term;
import autocomplete.BruteAutoComplete;


public class BruteAutoCompleteTest {

	Term term = new Term(500,"shop");
	Term term4 = new Term(-1,"Park");

	
	
	
	
	@Test
	 public  void weightOf()
		  {
		    assertEquals (0,term4.weight,01);
		    assertEquals (500,term.weight,01);
		    
		    
		   
		  }
	
	
	@After
	public void tearDown() throws Exception {
	}

}
