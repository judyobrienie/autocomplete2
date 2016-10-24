package autocomplete;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Judy
 * @param QuickAutoCompletet that implements give Interface AutoComplete
 * @returns populated Array of type Terms
 * @returns weight of any given Term
 * @bestMatch hightest matching weighted Term
 * @matches itereble string of matching term in decending order of weight
 */

	public class QuickAutoComplete implements AutoComplete {
		/**
		 * creates arraylist of type Term
		 */
		List<Term> listOfTerm = new ArrayList<>();

		

		/**
		 * @param Constructor to take array list  of Type term for test class BruteAutoCompleteTest
		 */
		public QuickAutoComplete(List<Term> listOfTerm ){
			this.listOfTerm = listOfTerm;

		}

		
		/**
		 * @param Construcor to read in a File 
		 * @returns a populated "Sorted" array list of type Term
		 */

		public  QuickAutoComplete(File usersFile) throws Exception {


			Scanner inUsers = new Scanner(usersFile);
			String delims = "[ 	]";//each field in the file is separated(delimited) by a space.
			while (inUsers.hasNextLine()) {
				// get user and rating from data source
				String userDetails = inUsers.nextLine();
				userDetails=userDetails.trim();

				// parse user details string
				String[] userTokens = userDetails.split(delims);

				//create Term
				String lowerCaseTerm = userTokens[1];
				Term list = new Term(Double.parseDouble(userTokens[0]), lowerCaseTerm.toLowerCase());
				if(!listOfTerm.contains(list)) // checking for doubles not working
					listOfTerm.add(list);
				   
				//sorting arraylist using java built in comparator
				listOfTerm.sort(Comparator.comparing(Term :: getTerm));
					
			}
					inUsers.close();
			}
		

	
		/**
		 *@param weightOf The weight of a Term
		 *@return the weight of the term, or 0.0 if no such term.
		 */


		@Override
		public double weightOf(String term)  {
			int index = 0;
			double weight = 0;
			boolean match = false;

			for(Term t: listOfTerm){

				if (t.getTerm().toLowerCase().equals(term.toLowerCase())){
					match = true;


					weight = listOfTerm.get(index).getWeight();
					break;
				}
				index++;
			}

			if(!match){
				System.out.println("No Result Found");
				weight = 0;
			}

			return weight;
		}


		/**
		 *@param matches An Iterable String of Terms
		 *@return  the highest weighted k matching terms (in descending order of weight), as an
	     * iterable.
	     * If fewer than k matches, return all matching terms (in descending order
	     * of weight).
		 */

		@Override
		public Iterable<String> matches(String prefix, int k) {
			List<Term> subTerms = new ArrayList<>();
			List<String> sorted = new ArrayList<>();
			int count = 1;
			
			
			try{
			if ((prefix != null) && (k > 0)){
				
				int startIndex=Collections.binarySearch(listOfTerm, new Term(0, prefix),Comparator.comparing(Term :: getTerm)); 
				
				
				 if (startIndex > 0)
			        {
			        
					 for( int i = startIndex; i < listOfTerm.size(); i++ )
					    {
					       if (listOfTerm.get(i).getTerm().toLowerCase().startsWith(prefix.toLowerCase())){
					        		 subTerms.add(listOfTerm.get(i));}
					        }
					 
			        
			        }
				
				Collections.sort(subTerms);

				for (Term t : subTerms) {
					if(count <= k){
					sorted.add(((Term) t).getTerm());
					}
					count++;
					}
			
			}else {throw new NullPointerException();
			}
			
			}catch (Exception e){ 
					System.err.println("Check Your Input Details: " + e);
			
			}
		
			return sorted;

		}




		/**
		 *@param bestMatch The highest weighted Term
		 *@return Returns the highest weighted matching term, or null if no matching term.
		 */

		public String bestMatch(String prefix) {
			String bestmatch = null;
			if (prefix != null) {
				try{
					Iterator<String> itr = matches(prefix, 1).iterator();
					bestmatch = itr.next(); 
				}
				catch (Exception e){ 
					System.err.println("There are no matching terms: " + e);
				}
			}

			return      bestmatch;

		}

		
	


	}//end







	 
	

