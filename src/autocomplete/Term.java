package autocomplete;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.Objects;




/**
 * @author Judy
 * @param A Term Class which implements java Comparable Interface so that Terms can be compared against each other
 * @returns a name of term
 * @returns a weight of a term
 * @returns an id for each term
 */
public class Term  implements Comparable<Term>{

	public double weight;
	public String term;
	static int   counter = 0;
	public int   id;



	/** Default Constructor for objects of class Term. 
     */
	public Term()
	{
	}
	
	/** Constructor for objects of class Term. 
     * @param weight    The weight of the Term
     * @param term      The  Name of the Term
     * @return an individual id for each term
     */

	public Term(double weight, String term)
	{
		setWeight(weight);
		setTerm(term);
		this.id  = counter++;
	}


	/**
     * Builds a String representing a user friendly representation of the object state
     * @return Details of the Term
     */
	@Override
	public String toString()
	{
		return toStringHelper(this).addValue(id)
				.addValue(weight) 
				.addValue(term)
				.toString();
	}

	

	/**
     * Getters and Setters
     */
 
	/**
	  * @return weight of Term
	  */ 
	public double getWeight() {
		return weight;
	}

	
	/**
	  * @return weight of Term but sets to 0.00 if a minus
	  */ 
	public void setWeight(double weight) {
		if( weight >= 0){
			this.weight = weight;
		}
		else weight = 0;
		//throw new IllegalArgumentException("Weight Set to Zero");
	}

	
	/**
	  * @return term name
	  */ 
	public String getTerm() {
		return term;
	}

	
	/**
	  * @return null value if term does not exist
	  */ 
	public void setTerm(String term) {
		this.term = Objects.requireNonNull(term);
	}

	
	/**
	  * @returns the weights in decending order
	  */ 

	@Override
	public int compareTo(Term that) {
		if      (this.weight < that.weight) return +1;
		else if (this.weight > that.weight) return -1;
		else                              return  0;
	} 


	/**
	* @return maps the memory address to an integer value.
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((term == null) ? 0 : term.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**@param used to make equal comparison between two objects. 
	 * 
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Term other = (Term) obj;
		if (id != other.id)
			return false;
		if (term == null) {
			if (other.term != null)
				return false;
		} else if (!term.equals(other.term))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}




}
