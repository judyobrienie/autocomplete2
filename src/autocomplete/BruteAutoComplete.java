package autocomplete;



import java.io.File;

import java.util.*;



/**
 * @author Judy
 * @param BruteAutoCompletet that implements give Interface AutoComplete
 * @returns populated Array of type Terms
 * @returns weight of any given Term
 * @bestMatch hightest matching weighted Term
 * @matches itereble string of matching term in decending order of weight
 */
public class BruteAutoComplete implements AutoComplete {

	
	/**
	 * creates arraylist of type Term
	 */
	List<Term> listOfTerm = new ArrayList<>();
	
	

	/**
	 * @param Constructor to take array list  of Type term for test class BruteAutoCompleteTest
	 */
	public BruteAutoComplete(List<Term> listOfTerm ){
		this.listOfTerm = listOfTerm;
	}
	
	
	/**
	 * @param Construcor to read in a File 
	 * @returns a populated array list of type Term
	 */
	
	public  BruteAutoComplete(File usersFile) throws Exception {


		Scanner inUsers = new Scanner(usersFile);
		String delims = "[ 	]";//each field in the file is separated(delimited) by a space.
		while (inUsers.hasNextLine()) {
			// get user and rating from data source
			String userDetails = inUsers.nextLine();
			userDetails=userDetails.trim();

			// parse user details string
			String[] userTokens = userDetails.split(delims);

			//create Term
			Term list = new Term(Double.parseDouble(userTokens[0]), userTokens[1]);
			if(!listOfTerm.contains(list)) // checking for doubles not working
				listOfTerm.add(list);
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

			for (Term t : listOfTerm) {

				//t.getTerm().indexOf(prefix);
				//Arrays.asList(listOfTerm).indexOf(prefix) ==0 ;
				if (t.getTerm().toLowerCase().startsWith(prefix.toLowerCase()))
					subTerms.add(t);
			}
			Collections.sort(subTerms);

			for (Term t : subTerms) {
				if(count <= k){
				sorted.add(t.getTerm());
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






