package autocomplete;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QuickAutoComplete {


	  public static Map<Integer, Term> termIndex = new HashMap<>();
	  
	  
	  public QuickAutoComplete(File usersFile) throws Exception
	  {
		  
		  Scanner inUsers = new Scanner(usersFile);
		  String delims = "[ ]";//each field in the file is separated(delimited) by a space.
		  while (inUsers.hasNextLine()) {
		    
			  // get user and rating from data source
		    String data = inUsers.nextLine();
		    // parse user details string
		      String[] arrayTerms = data.split(delims);
		 
		    
		    // output user data to console.
		    if (arrayTerms.length == 2) {
		     
		     
		      createTerm(Integer.parseInt(arrayTerms[0]), arrayTerms[1]);
		    }else
		    {
		      inUsers.close();
		      throw new Exception("Invalid member length: "+ arrayTerms.length);
		    }
		  }
		  inUsers.close();
		
	  }




	public static Collection<Term> getTerms ()
	  {
	    return termIndex.values();
	  }

	 
	public Term createTerm(int weight, String term) 
	  {
	    Term terms = new Term (weight, term);
	    termIndex.put(terms.id, terms);
	    return terms;
	    
	  }


	 
	}

