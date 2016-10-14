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
	
    
    String An = "An";
    String hello = "hello";
	List<Term> listOfTerm = new ArrayList<>();
	BruteAutoComplete bruteAutoComplete = new BruteAutoComplete(listOfTerm);
	
	@Before
	  public void setup()
	  {
	   
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
		   double weight = bruteAutoComplete.weightOf(An);
			assertEquals (2000, weight,01);
		
		    
		  }
private void hasItem(String an2, Iterable<String> matches) {
		
		
	}
	
	@Test
	public void Matchs(){
		hasItem (An, bruteAutoComplete.matches(An, 2) );
		hasItem(hello, bruteAutoComplete.matches(hello, 1));
		//System.out.println(bruteAutoComplete.matches(An, 2));
	}
	
	
	@After
	public void tearDown() throws Exception {
	}

}
