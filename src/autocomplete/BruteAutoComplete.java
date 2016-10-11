package autocomplete;



import java.io.File;
//import java.text.NumberFormat;
import java.util.*;


public class BruteAutoComplete implements AutoComplete {
	
	List<Term> listOfTerm = new ArrayList<>();

	
	
	
	public  BruteAutoComplete(File usersFile) throws Exception {
		
		
		 Scanner inUsers = new Scanner(usersFile);
		  
		 
		
		  
		  String delims = "[ 	]";//each field in the file is separated(delimited) by a space.
		  while (inUsers.hasNextLine()) {
		    // get user and rating from data source
		    String userDetails = inUsers.nextLine();
		    
		  System.out.println("Stuff: "+userDetails+".");
		    
		    userDetails=userDetails.trim();
		    // parse user details string
		    
		    String[] userTokens = userDetails.split(delims);
		    
		    //create Term
		  
		    
		 
		   
		    
		    
		   Term list = new Term(Double.parseDouble(userTokens[0]), userTokens[1]);
		    //create an array of type Term
		    
		    // output user data to console.
		    
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
	

		   
		 
		  
	

  /*  public List<String> getListOfTerms()
    {
    	return listOfTerms;
    }
    
    public List<Integer> getListOfWeights()
    {
    	return listOfWeights;
    }*/
	 public List<Term> getListOfTerm()
	    {
	    	return listOfTerm;
	    }
	 

	
		@Override
	public double weightOf(String term) {
			int index = 0;
			double weight = 0;
			if (term != null) {
				for (Term s : listOfTerm) {
					if (s.getTerm().toLowerCase().equals(term.toLowerCase()))
					index++;
				    weight = listOfTerm.get(index).getWeight();}
					
					}
				
			
				return weight;
		}
			
		
		
		
	@Override
	public Iterable<String> matches(String prefix, int k) {
		List<String> subTerms = new ArrayList<>();
		int count =-1;
		if (prefix != null) {
			for (Term t : listOfTerm) {
				count++;
				//t.getTerm().indexOf(prefix);
				if (t.getTerm().toLowerCase().contains(prefix.toLowerCase()) && count <= k)
					subTerms.add(t.getTerm());
					
			}
		}
		
		return subTerms;

	}

	@Override
	public String bestMatch(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}



}
