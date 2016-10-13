package models;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import autocomplete.BruteAutoComplete;
import autocomplete.Term;
import static models.Fixtures.listOfTerms;





public class BruteAutoCompleteTest {
	
	private BruteAutoComplete bruteAutoComplete;
	
	List<Term> listOfTerm = new ArrayList<>();
	
	@Before
	  public void setup()
	  {
	   bruteAutoComplete = new BruteAutoComplete();
	    for (Term terms : listOfTerms)
	    {
	      listOfTerm.add(terms);
	    }
	    
	  }
	@Test
	  public void testlistOfTerm()
	  {
	    assertEquals (6,listOfTerm.size());
	  
	  }  
	
	
	
	@Test
	 public  void testWeightOf()
		  { 
		   
		    String An = null;
			assertEquals (2000, bruteAutoComplete.weightOf(An),01);
		
		    
		  }
	
	
	@After
	public void tearDown() throws Exception {
	}

}
