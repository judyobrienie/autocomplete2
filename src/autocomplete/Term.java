package autocomplete;

import static com.google.common.base.MoreObjects.toStringHelper;





public class Term  implements Comparable<Term>{
	
	public String term;
	  static int   counter = 0;
	  public int   id;

	

	public Term()
	  {
	  }

	  public Term(double weight, String term)
	  {
	    setWeight(weight);
	    this.term = term;
	    this.id  = counter++;
	  }
	  
	  
	  
	  @Override
	  public String toString()
	  {
	    return toStringHelper(this).addValue(id)
	    						   .addValue(weight) 
	    						   .addValue(term)
	                               .toString();
	  }
	  
	  public double getWeight() {
			return weight;
		}

		public void setWeight(double weight) {
			if( weight >= 0){
				this.weight = weight;
				}
				else weight = 0;
		}

		public String getTerm() {
			return term;
		}

		public void setTerm(String term) {
			this.term = term;
		} 
	  
		

		@Override
		public int compareTo(Term that) {
			 if      (this.weight < that.weight) return +1;
		     else if (this.weight > that.weight) return -1;
		     else                              return  0;
		} 
		
		
	
		  public double weight;
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
