package autocomplete;



import java.io.File;
import java.util.*;







public class Main {
	
	private static Scanner input = new Scanner(System.in);
	public static final File usersFile = new File("../autocomplete2/lib/test.txt");
	
	public static void main(String[] args) throws Exception {
		
		

		// new QuickAutoComplete(usersFile);
		

	 BruteAutoComplete bruteAutoComplete = new BruteAutoComplete(usersFile);
		 
		 List<Term> listOfTerm = bruteAutoComplete.getListOfTerm();
		
		  System.out.println(listOfTerm);
		  
		    /*Collection<Term> terms = QuickAutoComplete.getTerms();
		    System.out.println(terms);*/
	    
	   
		    System.out.println("type word");
		    String s = input.nextLine();
		    System.out.println("how many");
		    int k = input.nextInt();
		    
		System.out.println(bruteAutoComplete.weightOf(s));
		System.out.println(bruteAutoComplete.matches(s, k));
	  
	}





	
	   
	  }