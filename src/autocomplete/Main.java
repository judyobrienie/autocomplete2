package autocomplete;



import java.io.File;
import java.math.BigDecimal;
import java.util.*;







public class Main {

	private static Scanner input = new Scanner(System.in);
	public static final File usersFile = new File("../autocomplete2/lib/test.txt");

	public static void main(String[] args) throws Exception {

		BruteAutoComplete bruteAutoComplete = new BruteAutoComplete(usersFile);


		int k  = 0;
		String s = null;


		System.out.println("Terms Database");
		System.out.println("-----------------");

		boolean goodInput = false;
		do{
			try{
				int option = mainMenu();
				while (option != 0)
				{
					goodInput = true;

					switch (option)
					{
					case 1:               
						System.out.println("What prefix would you like to search for?");
						input.nextLine();//swollow bug
						s = input.nextLine();
						System.out.println("How many results do you require?");
						try{
							k = input.nextInt();
						}
						catch(Exception e)
						{
							System.err.println("Enter numbers only not text: " + e);
						}

						System.out.println("\nList of Highest Matching Terms that start with your Prefix in Decending Order : " +  "\n\n" + bruteAutoComplete.matches(s, k));
						System.out.println("\nThe Highest Weighted Term is : " + bruteAutoComplete.bestMatch(s));
						break;


					case 2:
						System.out.println("What Term would you like the Weight Value of?");
						input.nextLine();// Swallow bug
						s = input.nextLine();
						
						BigDecimal bd = new BigDecimal(bruteAutoComplete.weightOf(s));
						System.out.println(bd);
						break;

					default: System.err.println("Invalid option entered: " + option);
					mainMenu();
					break;
					}

					//pause the program so that the user can read what we just printed to the terminal window
					System.out.println("\nPress any key to continue...");

					input.nextLine();

					//display the main menu again
					option = mainMenu();
					//the user chose option 0, so exit the program
				}
				System.out.println("Exiting... bye");
				System.exit(0);

			}

			catch (Exception e) {
				input.nextLine(); //swallows bug
				System.err.println("Num expected - You Entered Text. Try Again...\n");
			}
		} while (!goodInput); 
	}// end of 


	private static  int mainMenu()
	{ 
		System.out.println("1) Search For A List Of Matching Terms in Decending Weighted Order");
		System.out.println("2) Get The Weight of a Term");
		System.out.println("0) Exit");
		System.out.print("==>>");
		int option = input.nextInt();
		return option;
	}
} //end of main



/* Tried this but caused infinite loop with this message in debugger : toString() unavailable - no suspended threads

 * boolean goodInput = false;
	        	do {    
	            try {
	            	System.out.println("How many results do you require?");
	            	k = input.nextInt();
		        	goodInput = true;
					}
	            catch (Exception e) {
				        System.err.println("Num expected - you entered text");
				        }
	        	} while (!goodInput);*/




	  