package virusSimulation;

public interface Node {

	
	/**
	 * This function aims to return the name of the node 
	 * @return the name of the node 
	 */
	public String getName() ;
	
	
	/**
	 * This function aims to override the equals method
	 * @param o to compare 
	 * @return boolean that represents whether two objects are the same
	 */
	public boolean equals(Object o); 
}