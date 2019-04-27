package virusSimulation;

import java.util.*;

public class UnhealthyPeople implements People {

	String name;
	double resistence;
	List<People> socialNetwork;
	
	public UnhealthyPeople(String name, double resistence, List<People> socialNetwork) {
		this.name = name;
		this.resistence = resistence;
		this.socialNetwork = socialNetwork;
	}
	
	public void infect() {
		
	}
	
	
}
