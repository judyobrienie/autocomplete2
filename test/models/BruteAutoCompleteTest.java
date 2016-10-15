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






public class BruteAutoCompleteTest {


	String An = "An";
	String A = "A";
	String hello = "hello";
	List<Term> listOfTerm = new ArrayList<>();
	
	BruteAutoComplete bruteAutoComplete = new BruteAutoComplete(listOfTerm);

	@Before
	public void setup(){

		for (Term terms : listOfTerms)
		{
			listOfTerm.add(terms);
		}
	}
		  
		  
	@Test
	public void testlistOfTerm()
	{
		assertEquals (5,listOfTerm.size());

	}  



	@Test
	public  void testWeightOf()
	{ 
		double weight = bruteAutoComplete.weightOf(An);
		assertEquals (2000, weight,01);
	}
	
	@Test
	public void matches()
	{
		Iterable<String>it = bruteAutoComplete.matches(An,2);
				assertEquals(2,Iterables.size(it));
		
	}
	

	@Test
	public void bestMatch(){
		String bestMatch = bruteAutoComplete.bestMatch(A);
		assertEquals (An,  bestMatch);
		
	}

	

	@After
	public void tearDown() throws Exception {
	}

}
