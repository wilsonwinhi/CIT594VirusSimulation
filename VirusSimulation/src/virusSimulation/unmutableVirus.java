package virusSimulation;

public class unmutableVirus implements Virus {

	double probability;
	String name;

	public unmutableVirus(double probability, String name) {
		this.probability = probability;
		this.name = name;
	}
	
	@Override
	public void setProbability(double d) {
		// TODO Auto-generated method stub
		this.probability = d;
	}

	@Override
	public double getProbability() {
		// TODO Auto-generated method stub
		return this.probability;
	}

	@Override
	public void setVirusName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
		
	}


}