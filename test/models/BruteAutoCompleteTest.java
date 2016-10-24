package models;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Iterables;

import autocomplete.BruteAutoComplete;
import autocomplete.Term;
import static models.Fixtures.listOfTerms;



/**
 * @author Judy
 *
 */
public class BruteAutoCompleteTest {


	String An = "An";
	String A = "A";
	String Box = "Box";
	String hello = "hello";
	List<Term> listOfTerm = new ArrayList<>();
	
	BruteAutoComplete bruteAutoComplete = new BruteAutoComplete(listOfTerm);


	/**
	 * 1. Method to set up new array list from a list of terms stored in Fixtures files
	 *
	 */
	
	@Before
	public void setup(){

		for (Term terms : listOfTerms)
		{
			listOfTerm.add(terms);
		}
	}
		
	
	/**
	 * 2. Method set up to test that the code is not adding duplicates
	 *
	 */
		  
	@Test
	public void testlistOfTerm()
	{
		assertEquals (5,listOfTerm.size());

	}  

	/**
	 * 3. Method to check that is is returning the correct weight associated with that particular term
	 *
	 */

	@Test
	public  void testWeightOf()
	{ 
		double weight = bruteAutoComplete.weightOf(An);
		assertEquals (2000, weight,01);
		
	}
	

	/**
	 * 4. Method to check that is is returning the correct size of iterable string 
	 *
	 */
	
	@Test
	public void testMatches()
	{
		Iterable<String>it = bruteAutoComplete.matches(An,2);
				assertEquals(2,Iterables.size(it));
		
	}
	

	/**
	 * 5. Method to check that we are getting back the highest weighted item 
	 *
	 */
	
	@Test
	public void bestMatch(){
		String bestMatch = bruteAutoComplete.bestMatch(A);
		assertEquals (An,  bestMatch);
		
	}

	/**
	 * 6. Method to check that is is returning the correct weight associated with that particular term
	 *
	 */

	@After
	public void tearDown() throws Exception {
	}

}
