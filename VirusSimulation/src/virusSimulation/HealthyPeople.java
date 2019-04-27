package virusSimulation;

import java.util.*;

public class HealthyPeople implements People{
	
	String name;
	double resistence;
	List<People> socialNetwork;
	
	
	public HealthyPeople(String name) {
		this.name = name;
	}
	
	public void infect() {
		//do nothing there, healthy people cann't infect other people
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getResistence() {
		return this.resistence;
	}
	
	public List<People> getSocialNetwork(){
		return this.socialNetwork;
	}
	
	
	public void setResistence(double value) {
		this.resistence = value;
	}
	
	public void setNetwork(List<People> network) {
		this.socialNetwork = network;
	}

}
