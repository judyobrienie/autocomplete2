package autocomplete;



import java.io.File;

import java.util.*;


public class BruteAutoComplete implements AutoComplete {
	
	List<Term> listOfTerm = new ArrayList<>();
	

	
	
	
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
		   
		    if (userTokens.length == 2) {
		    	listOfTerm.add(list);
		    	
		   }else
		    {
		      inUsers.close();
		      throw new Exception("Invalid member length: "+ userTokens.length);
		    }
		  }
		  inUsers.close();
		
		  
	    
	      
	}
	

		   
		 
	 public BruteAutoComplete() {
		// TODO Auto-generated constructor stub
	}




	public List<Term> getListOfTerm()
	    {
	    	return listOfTerm;
	    }
	 

	
		@Override
	public double weightOf(String term)  {
			int index = 0;
			double weight = 0;
			boolean match = false;
			
				for(Term t: listOfTerm){
					index++;
				    if (t.getTerm().toLowerCase().equals(term.toLowerCase())){
				    	match = true;
				    	break;
				    }
				    weight = listOfTerm.get(index).getWeight();
				   	
					}
				 
				if(!match){
				 System.out.println("No Result Found");
				}
				return weight;
			}
			    	
		
		
		
	@Override
	public Iterable<String> matches(String prefix, int k) {
		List<Term> subTerms = new ArrayList<>();
		List<String> sorted = new ArrayList<>();
		int count = 1;
		if (prefix != null) {
			
			for (Term t : listOfTerm) {
				
				//t.getTerm().indexOf(prefix);
				//Arrays.asList(listOfTerm).indexOf(prefix) ==0 ;
				if (t.getTerm().toLowerCase().startsWith(prefix.toLowerCase()))
					subTerms.add(t);
			}
			Collections.sort(subTerms);
			
			//System.out.println(subTerms);
			
			 for (Term t : subTerms) {
				 
		            if(count <= k){
		            	sorted.add(t.getTerm());
		            }
		            count++;
		            }
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
			System.out.println("There are no matching terms: " + e);
			}
		}
			 
		return      bestmatch;
		
	}
	
	
	
	
	}//end
		
		




