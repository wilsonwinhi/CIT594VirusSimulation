package virusSimulation;

public class unmutableVirus implements Virus {

	double probability;
	String name;

	public unmutableVirus(double probability, String name) {
		this.probability = probability;
		this.name = name;
	}
	/*
	 * set probability of the virus
	 * @parm: double probability of the virus
	 */
	@Override
	public void setProbability(double d) {
		// TODO Auto-generated method stub
		this.probability = d;
	}
	/*
	 * get the virus probability
	 * @return: virus probability
	 */
	@Override
	public double getProbability() {
		// TODO Auto-generated method stub
		return this.probability;
	}
	/*
	 * set virus name
	 * parm String virus name
	 */
	@Override
	public void setVirusName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
		
	}


}