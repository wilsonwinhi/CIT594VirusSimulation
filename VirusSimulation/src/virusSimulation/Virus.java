package virusSimulation;

public interface Virus {
	

	/**
	 * set probability of the virus
	 * @param d probability
	 */
    public void setProbability(double d);
    
    /**
     * 
     * @return probability of the virus
     */
    public double getProbability();

    
    /**
     * set name of the virus
     * @param name virus name
     */
    public void setVirusName(String name);

}