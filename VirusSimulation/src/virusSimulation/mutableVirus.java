package virusSimulation;

public class mutableVirus implements Virus {
	
	double probability;
	String name;


	public mutableVirus(double probability, String name) {
		this.probability = probability;
		this.name = name;
	}
	

	public void setProbability(double d) {
		// TODO Auto-generated method stub
		this.probability= d;
	}

	public double getProbability() {
		return probability;
	}


	@Override
	public void setVirusName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
		
	}
	
	/**
	 * make the virus stronger
	 * @return new infectious probability
	 */
	public double mutateToStrong() {
		// TODO Auto-generated method stub
		double mute = probability+0.5;
		if(mute>1) {
			this.probability = 1;
			mute = 1;
		}
		else {
			this.probability = mute;
		}
		return mute;
	}

	/**
	 * make the virus weaker
	 * @return new infectious probability
	 */
	public double mutateToWeak() {
		// TODO Auto-generated method stub
		double mute = probability-0.5;
		if(mute<0) {
			this.probability = 0;
			mute = 0;
		}
		else {
			this.probability = mute;
		}
		return mute;
	}
    
}
