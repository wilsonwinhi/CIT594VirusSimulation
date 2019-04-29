package virusSimulation;

public interface Virus {
	

    /*
     * set probability of the virus
     * @parm double probability
     */
    public void setProbability(double d);
    
    /*
     * return probability of the virus
     * @parm double probability
     */
    public double getProbability();

    /*
     * set name of the virus
     * @parm String name
     */
    public void setVirusName(String name);

}