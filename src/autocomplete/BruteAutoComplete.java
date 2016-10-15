package autocomplete;



import java.io.File;

import java.util.*;


public class BruteAutoComplete implements AutoComplete {

	List<Term> listOfTerm = new ArrayList<>();

	
	public BruteAutoComplete(List<Term> listOfTerm ){
		this.listOfTerm = listOfTerm;

	}


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


	// help Martin

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






